package prop.grup3;

import org.la4j.*;
import org.la4j.Vector;
import org.la4j.iterator.VectorIterator;
import org.la4j.matrix.sparse.CCSMatrix;
import org.la4j.vector.sparse.CompressedVector;


public class Metrica {

    private static final String relationTypes[] = {"AP", "PA", "PC", "CP", "PT", "TP"};
    private static final int precision = 12; //Nombre de xifres significatives

    private boolean IsRelationType(String s) {
        for (String rel : relationTypes) {
            if (rel.equals(s))
                return true;
        }
        return false;
    }

    //Normalitza la matriu per fila
    private Matrix ConvertToU(Matrix mat) {
        for (int i = 0; i < mat.rows(); i++) {
            Vector a = mat.getRow(i);
            double sum = a.sum();
            if (sum != 0) {
                a = a.multiply(1 / sum);
                mat.setRow(i, a);
            }
        }
        return mat;
    }

    //Normalitza la matriu per columna
    private Matrix ConvertToV(Matrix mat) {
        for (int i = 0; i < mat.columns(); i++) {
            Vector a = mat.getColumn(i);
            double sum = a.sum();
            if (sum != 0) {
                a = a.multiply(1 / sum);
                mat.setColumn(i, a);
            }
        }
        return mat;
    }


    //Retorna una copia de la matriu de adjacencia entre type (ex: PA,AP,PC...)
    private Matrix GetMatrixType(Matrix m[], String type) {
        assert (IsRelationType(type));
        switch (type.charAt(0)) {
            case 'P':
                switch (type.charAt(1)) {
                    case 'A':
                        return m[0].copy();
                    case 'C':
                        return m[1].copy();
                    case 'T':
                        return m[2].copy();
                }
                break;
            case 'A':
                return m[0].copy().transpose();
            case 'C':
                return m[1].copy().transpose();
            case 'T':
                return m[2].copy().transpose();
        }
        return null;
    }

    //Per depuració
    private void PrintMatrix(Matrix m) {
        for (int i = 0; i < m.rows(); i++) {
            System.out.print("| ");
            for (int j = 0; j < m.columns(); j++) {
                System.out.print(" " + m.get(i, j));
            }
            System.out.println("| ");
        }
    }

    //Retorna la longitud d'un vector espars eficientment
    private double CalculateLength(CompressedVector v) {
        VectorIterator it = v.nonZeroIterator(); //Només itera sobre els elements diferents de 0
        double squareSum = 0;

        while (it.hasNext()) {
            it.next();
            squareSum += it.get() * it.get();
        }
        return Math.sqrt(squareSum);
    }

    //Retorna el nombre de relacions (arestes) donada una matriu d'adjacencia
    private int GetNumRelations(Matrix mat){
        int num = 0;
        for(int i = 0; i < mat.columns();i++) {
            CompressedVector v = (CompressedVector) mat.getColumn(i);
            num += v.sum();
        }
        return num;
    }

    // Retorna un double amb precision decimals
    // lleig pero funciona ja que les rellevancies sempre estan en [0,1],no hi ha overflow
    // Elimina les rellevancies = 0.99999999999999,1.00000000001 etc...
    private double Round(double val){
        long factor = (long) Math.pow(10, precision);
        val = val * factor;
        long tmp = Math.round(val);
        return (double) tmp / factor;
    }

    //Aqueta funció descomposa una relació tipus type en dos matrius LME i RME de tal manera que MM = LME*RME
    //on MM es la matriu d'adjacencia de type.
    //Aixo s'aconsegueix creant una entitat "imaginaria" de tipus E tal que type.S ~ E <=> E ~ type.T
    //en el paper hi han mes detalls
    private Matrix[] Decompose(Matrix m[],String type){

        Matrix MM = GetMatrixType(m,type);
        int numRelations = GetNumRelations(MM);
        Matrix LME = new CCSMatrix(MM.rows(),numRelations);
        Matrix RME = new CCSMatrix(numRelations,MM.columns());
        // Recodeu que MM mapeja de type.S a type.T, per tant una fila representa les relacions de un type.S i una columna de un type.T
        //               type.T
        //          | 0 1 1 0 .... |
        //          | 0 1 0 1 .... |
        //          | ...          |
        //  type.S  | ..           |
        //          | ..           |
        //
        //
        for(int row = 0,column = 0,i = 0; i < numRelations;i++){ //Hi han tans elements "ficticis" com a relacions entre type.S i type.T
            while(MM.get(row,column) != 1 ){ //Trobem la "instancia" de tipus type.S (la row) i la "instancia" de tipus T (column)
                column++;
                if(column >= MM.columns()) {
                    column = 0;
                    row++;
                }
            }
                                    //Sabem que las instancies row i column de type.S i type.T estan relacionades
            LME.set(row,i,1.0);    //"Mapejem" el type.S amb el element fitici i
            RME.set(i,column,1.0); // e i el mapejem a type.T

            column++;              //finalment incrementem el index de la matriu.
            if(column >= MM.columns()) {
                column = 0;
                row++;
            }
        }
        return new Matrix[]{LME,RME};
    }

    //Calcula la matriu de rellevancia,la matriu esquerra i dreta
    private Matrix[] CalcularMatrius(String path, Matrix m[]){
        int pathLength = path.length();
        Matrix RM;
        Matrix LM;
        Matrix relevanceMatrix;

        if (pathLength % 2 == 1)
        {
            LM = ConvertToU(GetMatrixType(m, path.substring(0, 2)));
            for (int i = 1; i < (pathLength / 2); i++) {
                LM = LM.multiply(ConvertToU(GetMatrixType(m, path.substring(i, i + 2))));
            }

            RM = ConvertToV(GetMatrixType(m, path.substring(pathLength / 2, (pathLength / 2) + 2)));
            for (int i = pathLength / 2 + 1; i < (pathLength - 1); i++) {
                RM = RM.multiply(ConvertToV(GetMatrixType(m, path.substring(i, i + 2))));
            }
        } else
        {
            LM = ConvertToU(GetMatrixType(m, path.substring(0, 2)));
            for (int i = 1; i < (pathLength / 2) - 1; i++) {
                LM = LM.multiply(ConvertToU(GetMatrixType(m, path.substring(i, i + 2))));
            }

            String type = path.substring(pathLength / 2-1, (pathLength / 2) + 1); // Relacio atomica a descomposar
            Matrix matrius[] = Decompose(m,type);

            if(pathLength > 2)
                LM = LM.multiply(ConvertToU(matrius[0]));
            else
                LM = ConvertToU(matrius[0]);

            RM = ConvertToV(matrius[1]);
            for (int i = pathLength / 2; i < (pathLength - 1); i++) {
                RM = RM.multiply(ConvertToV(GetMatrixType(m, path.substring(i, i + 2))));
            }
        }

        relevanceMatrix = LM.multiply(RM);
        return new Matrix[]{LM,RM,relevanceMatrix};
    }

    ////////
    // Mètodes publics
    ////////
    public double ComputarMetrica(int entidad1, int entidad2, String path, Matrix m[]) {
        System.out.println("Començo a calcular");
        Matrix matrius[] = CalcularMatrius(path,m);
        System.out.println("0");
        double val = matrius[2].get(entidad1, entidad2);
        System.out.println("1");
        double l1 = CalculateLength((CompressedVector) matrius[0].getRow(entidad1)); //Aixo només funciona si les matrius son de tipus SparseMatrix
        System.out.println("2");
        double l2 = CalculateLength((CompressedVector) matrius[1].getColumn(entidad2)); //Un cast es la unica manera eficient de obtenir els vectors esparsos de les matrius
        System.out.println("Acabo");
        if (l1 == 0 || l2 == 0)
            return 0;
        return Round(val / (l1 * l2));
    }

    public CompressedVector ComputarMetrica(int entidad, String path, Matrix m[]) {
        Matrix matrius[] = CalcularMatrius(path,m);

        CompressedVector v = (CompressedVector)matrius[2].getRow(entidad);

        VectorIterator it = v.nonZeroIterator();
        double l1 = CalculateLength((CompressedVector)matrius[0].getRow(entidad)); //Aixo només funciona si les matrius son de tipus SparseMatrix
        while(it.hasNext()){
            it.next();
            double l2 = CalculateLength((CompressedVector)matrius[1].getColumn(it.index())); //Un cast es la unica manera eficient de obtenir els vectors esparsos de les matrius
            if(l1 != 0 && l2 != 0)
                v.set(it.index(),Round(it.get()/(l1*l2)));
            else
                v.set(it.index(),0);
        }
        return v;
    }

    public Matrix ComputarMetrica(String path,Matrix m[]){
        Matrix matrius[] = CalcularMatrius(path,m);

        for(int j = 0;j < matrius[2].columns();j++) {
            CompressedVector v = (CompressedVector) matrius[2].getColumn(j);

            VectorIterator it = v.nonZeroIterator();
            double l2 = CalculateLength((CompressedVector) matrius[1].getColumn(j)); //Un cast es la unica manera eficient de obtenir els vectors esparsos de les matrius
            while (it.hasNext()) {
                it.next();
                double l1 = CalculateLength((CompressedVector) matrius[0].getRow(it.index())); //Aixo només funciona si les matrius son de tipus SparseMatrix
                if (l1 != 0 && l2 != 0)
                    v.set(it.index(), Round(it.get() / (l1 * l2)));
                else
                    v.set(it.index(), 0);
            }
            matrius[2].setColumn(j,v);
        }
        return matrius[2];
    }
}
