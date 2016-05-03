package prop.grup3;

import org.la4j.Matrix;
import org.la4j.matrix.SparseMatrix;
import org.la4j.vector.SparseVector;

/**
 * Created by Albert on 09/04/2016.
 */
public class QueryRelimportant extends Query {
    private Integer entitat1;
    public QueryRelimportant(String path, Integer entitat1, Metrica m, Matrix[] m1) {
        super(path,m,m1);
        this.entitat1 = entitat1;
        this.m1 = m1;
    }
    public Integer getID(){
        return entitat1;
    }
    public SparseVector Cerca(){  //vector ordenat de id de Entitats
        return m.ComputarMetrica(entitat1,path,m1);
    }

}
