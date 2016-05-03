package prop.grup3;

import org.la4j.iterator.VectorIterator;

import java.util.Vector;
import java.util.Scanner;
import org.la4j.vector.SparseVector;

public class DriverResultats {
    public static void main(String[] args) { /*
        while (true) {
            System.out.println("0 Test prop.grup3.ResImportant \n1 Test prop.grup3.ResClustering\n2 Test ConjRes");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    QueryRelimportant qri = new QueryRelimportant();
                    SparseVector sv = new SparseVector(0) {
                        @Override
                        public double getOrElse(int i, double defaultValue) {
                            return 0;
                        }

                        @Override
                        public boolean nonZeroAt(int i) {
                            return false;
                        }

                        @Override
                        public VectorIterator nonZeroIterator() {
                            return null;
                        }

                        @Override
                        public void set(int i, double value) {

                        }

                        @Override
                        public org.la4j.Vector blankOfLength(int length) {
                            return null;
                        }

                        @Override
                        public org.la4j.Vector copyOfLength(int length) {
                            return null;
                        }

                        @Override
                        public byte[] toBinary() {
                            return new byte[0];
                        }
                    };
                    ResImportant rri =  new ResImportant(qri, sv);
                    System.out.println("0 Obtenir Resultat \n1 Obtenir Query\n2 Sortir");
                    int opcionri = sc.nextInt();
                    while (opcionri != 2) {
                        switch (opcionri) {
                            case 0:
                                SparseVector sv1 = rri.Resultat();
                                System.out.println("Resultat Obtingut\n");
                                break;

                            case 1:
                                QueryRelimportant qri1 = rri.getQuery();
                                System.out.println("Query Obtinguda\n");
                                break;
                        }
                        opcionri = sc.nextInt();
                    }
                    break;

                case 1:
                    QueryClustering qc = new QueryClustering();
                    Vector<Vector<String>> conj = new Vector<Vector<String>>();
                    ResClustering rc =  new ResClustering(qc, conj);
                    System.out.println("0 Obtenir Resultat \n1 Obtenir Query\n2 Sortir");
                    int opcionc = sc.nextInt();
                    while (opcionc != 2) {
                        switch (opcionc) {
                            case 0:
                                Vector<Vector<String>> conj1 = rc.Resultat();
                                System.out.println("Resultat Obtingut\n");
                                break;

                            case 1:
                                QueryClustering qc1 = rc.getQuery();
                                System.out.println("Query Obtinguda\n");
                                break;
                        }
                        opcionc = sc.nextInt();
                    }
                    break;

                case 2:
                    ConjRes cr = new ConjRes();
                    System.out.println("0 Obtenir Resultat de Relació Important \n1 Obtenir Resultat de Clustering\n" +
                            "2 Afegir Resultat de Relació Important\n3 Afegir Resultat de Clustering\n" +
                            "4 Consultar mida de Conjunts de Resultats de Relacions Importants\n" +
                            "5 Consultar mida de Conjunts de Resultats de Clustering\n6 Sortir");
                    int opcioncr = sc.nextInt();
                    while (opcioncr != 6) {
                        switch (opcioncr) {
                            case 0:
                                System.out.println("Insereix el número de resultat de 0 a 5 que vols obtindre\n");
                                int pos = sc.nextInt();
                                if(pos >= cr.sizeRelImps()) {
                                    System.out.println("No hi ha tants resultats com l'índex introduit, pots provar d'afegir-ne\n");
                                }
                                else {
                                    ResImportant rri1 = cr.getRelImp(pos);
                                    System.out.println("Resultat Obtingut\n");
                                }
                                break;
                            case 1:
                                System.out.println("Insereix el número de resultat de 0 a 5 que vols obtindre\n");
                                int pos2 = sc.nextInt();
                                if(pos2 >= cr.sizeClusts()) {
                                    System.out.println("No hi ha tants resultats com l'índex introduit, pots provar d'afegir-ne\n");
                                }
                                else {
                                    ResClustering rc1 = cr.getClust(pos2);
                                    System.out.println("Resultat Obtingut\n");
                                }
                                break;
                            case 2:
                                QueryRelimportant qri2 = new QueryRelimportant();
                                SparseVector sv2 = new SparseVector(0) {
                                    @Override
                                    public double getOrElse(int i, double defaultValue) {
                                        return 0;
                                    }

                                    @Override
                                    public boolean nonZeroAt(int i) {
                                        return false;
                                    }

                                    @Override
                                    public VectorIterator nonZeroIterator() {
                                        return null;
                                    }

                                    @Override
                                    public void set(int i, double value) {

                                    }

                                    @Override
                                    public org.la4j.Vector blankOfLength(int length) {
                                        return null;
                                    }

                                    @Override
                                    public org.la4j.Vector copyOfLength(int length) {
                                        return null;
                                    }

                                    @Override
                                    public byte[] toBinary() {
                                        return new byte[0];
                                    }
                                };
                                ResImportant rri2 =  new ResImportant(qri2, sv2);
                                cr.addRelImp(rri2);
                                System.out.println("Resultat Afegit\n");
                                break;
                            case 3:
                                QueryClustering qc2 = new QueryClustering();
                                Vector<Vector<String>> vec2 = new Vector<Vector<String>>();
                                ResClustering rc2 =  new ResClustering(qc2, vec2);
                                cr.addClust(rc2);
                                System.out.println("Resultat Afegit\n");
                                break;
                            case 4:
                                System.out.println("La mida és " + cr.sizeRelImps() + "\n");
                                break;
                            case 5:
                                System.out.println("La mida és " + cr.sizeClusts() + "\n");
                                break;
                        }
                        System.out.println("0 Obtenir Resultat de Relació Important \n1 Obtenir Resultat de Clustering\n" +
                                "2 Afegir Resultat de Relació Important\n3 Afegir Resultat de Clustering\n" +
                                "4 Consultar mida de Conjunts de Resultats de Relacions Importants\n" +
                                "5 Consultar mida de Conjunts de Resultats de Clustering\n6 Sortir");
                        opcioncr = sc.nextInt();
                    }
                    break;
            }
        }
    */}
}