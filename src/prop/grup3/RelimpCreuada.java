package prop.grup3;

import javafx.util.Pair;
import org.la4j.iterator.VectorIterator;
import org.la4j.vector.SparseVector;

import java.util.Vector;

/**
 * Created by Albert on 09/04/2016.
 */
public class RelimpCreuada {
        private ResImportant r1,r2;
        public RelimpCreuada(ResImportant r1, ResImportant r2){
            this.r1 = r1;
            this.r2 = r2;
        }

    public Vector<Pair<Integer,Double>> CreuaResultats(){ //suposem està ordenat per nom
        Vector<Pair<Integer,Double>> vd = new Vector<>(); //pels dos sparsevectors son de mateixa mida
        VectorIterator it = r1.Resultat().nonZeroIterator();
        SparseVector v = r2.Resultat();
        while(it.hasNext()){
            Double val = it.next();
            if(v.nonZeroAt(it.index())){
                vd.add(new Pair<>(it.index(), (val+v.get(it.index()))/2));
            }
        }
        return vd;
    }
}
