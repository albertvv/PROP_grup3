package prop.grup3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * Created by alvar.hernandez on 10/05/2016.
 */
public class comptar_rep {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> repeticions = new HashMap<>();
        ControladorGrafoPersist cgp = new ControladorGrafoPersist();
        Vector<Vector<String>> m = cgp.getPapers();
        for (int i = 0; i < m.size(); i++) {
            if(repeticions.containsKey(m.get(i).get(1))) {
                Integer j = repeticions.get(m.get(i).get(1));
                ++j;
                repeticions.put(m.get(i).get(1), j);
            }
            else repeticions.put(m.get(i).get(1), 0);
        }
        Set<String> noms = repeticions.keySet();
        Iterator<String> it = noms.iterator();
        while(it.hasNext()) {
            String nom = it.next();
            if(repeticions.get(nom) != 0) {
                System.out.println(nom + " " + repeticions.get(nom));
            }
        }
    }
}
