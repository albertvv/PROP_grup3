package prop.grup3;import java.util.Vector;

public class ResClustering {
    //ATRIBUTOS
    private QueryClustering q;
    private Vector<Vector<Integer>> ConjGrups;

    //CREADORA
    public ResClustering(QueryClustering q, Vector< Vector<Integer> > conj) {
        this.q = q;
        this.ConjGrups = conj;
    }

    //METODOS
    public Vector<Vector<Integer>> Resultat() {
        return ConjGrups;
    }
    public QueryClustering getQuery() {
        return q;
    }
}
