package prop.grup3;
import java.util.Vector;

public class ConjRes {
    //ATRIBUTOS
    Vector<ResImportant> RelImps;
    Vector<ResClustering> Clusts;

    //CREADORA
    public ConjRes() {
        this.RelImps = new Vector<ResImportant>();
        this.Clusts = new Vector<ResClustering>();
    }

    //METODOS
    public Vector<ResImportant> getRelImp() { return RelImps; }
    public Vector<ResClustering> getClust() {
        return Clusts;
    }
    public void addRelImp(ResImportant r) {
        if (RelImps.size() < 5) {
            RelImps.add(r);
        }
        else{
            RelImps.remove(0);
            RelImps.add(r);
        }
    }
    public void addClust(ResClustering r) {
        if (Clusts.size() < 5) {
            Clusts.add(r);
        }
        else{
            Clusts.remove(0);
            Clusts.add(r);
        }
    }
    public int sizeRelImps() {
        return RelImps.size();
    }
    public int sizeClusts() {
        return Clusts.size();
    }
}