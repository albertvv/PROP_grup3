package prop.grup3;

import org.la4j.Matrix;
import org.la4j.matrix.SparseMatrix;

import java.util.Vector;

/**
 * Created by Albert on 08/04/2016.
 */
public abstract class Query {
    protected String path;
    protected Vector<Integer> vs; //fa falta que estigui a query?
    protected Metrica m;
    protected Matrix [] m1;

    protected Query(String path, Vector<Integer> vs, Metrica m, Matrix [] m1) {
        this.path = path;
        this.vs = vs;
        this.m = m;
        this.m1 = m1;
    }

    protected Query(String path, Metrica m,Matrix[] m1) {
        this.path = path;
        this.m = m;
        this.m1 = m1;
    }

    public String getPath() {
        return path;
    }
}
