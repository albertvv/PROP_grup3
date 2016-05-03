package prop.grup3;import org.la4j.vector.SparseVector;

public class ResImportant {
    //ATRIBUTOS
    private QueryRelimportant q;
    private SparseVector vecEntRel;

    //CREADORA
    public ResImportant(QueryRelimportant q, SparseVector vec) {
        this.q = q;
        this.vecEntRel = vec;
    }

    //METODOS
    public SparseVector Resultat() {
        return vecEntRel;
    }
    public QueryRelimportant getQuery() {
        return q;
    }
}
