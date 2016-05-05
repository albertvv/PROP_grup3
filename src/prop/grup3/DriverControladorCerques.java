package prop.grup3;

import javafx.util.Pair;
import org.la4j.iterator.VectorIterator;
import org.la4j.vector.SparseVector;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Albert on 20/04/2016.
 */
public class DriverControladorCerques {
    public static void main(String[] args) throws IOException {
        Scanner b = new Scanner(System.in);
        boolean exit = false;
        ControladorCerques qc = new ControladorCerques();
        while(!exit) {
            System.out.println("Escull cerca:");
            System.out.println("\t 1) Cerca de Rellevància");
            System.out.println("\t 2) Cerca de Relacions importants");
            System.out.println("\t 3) Cerca de Relacions directes");
            System.out.println("\t 4) Cerca Creuada");
            System.out.println("\t 5) Clustering");
            System.out.println("\t 6) Filtrat Relació important");
            System.out.println("\t 7) Filtrat Clustering");
            System.out.println("\t 8) Existeix entitat");
            System.out.println("\t 9) Nom entitat a partir de id");
            System.out.println("\t 10) Llista últimes relacions importants");
            System.out.println("\t 11) Llista últims clusterings");
            int opc= b.nextInt();
            try {
                switch(opc){
                    case 1:
                        System.out.println("Escriu un path ");
                        System.out.println("(No es comprova si és valid) ");
                        String path = b.next();
                        while(path.length()<2) {
                            System.out.println("Un path és minim de dos elements!!");
                            path = b.next();
                        }
                        System.out.println("Escriu els elements del path ");
                        System.out.println("Si no vols fixar un dels elements escriu la id -1");
                        Vector<Integer> vs = new Vector<>();
                        for (int i = 0; i <path.length() ; i++) {
                            Integer id = b.nextInt();
                            if(!id.equals(-1)) {
                                vs.add(id);
                                System.out.println("Has afegit :"+id);
                            }else if(i==0 || i==path.length()-1){
                                System.out.println("El primer i l'últim element han d'estar fixats!!");
                                --i;
                                System.out.println("Torna a introduir-lo");
                            }else{
                                System.out.println("Element no fixat");
                                vs.add(null);
                            }
                        }
                        System.out.println("La rellevancia entre "+vs.firstElement()+" i "+vs.lastElement()+" pel path "+path+" és  "+qc.CercaRellevancia(path,vs));
                        break;
                    case 2:
                        System.out.println("Introdueix path");
                        path = b.next();
                        System.out.println("Introdueix el nom de la primera entitat del path");
                        Integer entitat1= b.nextInt();
                        EscriuSparseVector(qc.CercaRelimportant(path,entitat1));
                        break;
                    case 3:
                        System.out.println("Introdueix la id de l'entitat");
                        System.out.println("Aquí no es comprova si existeix ");
                        Integer id = b.nextInt();
                        System.out.println("Introdueix el tipus d'entitat");
                        String tipus = b.next();
                        Escriuvector(qc.CercaRelDirecta(id,tipus)); //canviar rel directa perque funcioni per id
                        break;
                    case 4:
                        System.out.println("Introdueix index dels ultims resultats( tactil de cara al usuari )");
                        EscriuCreuada(qc.CercaCreuada(b.nextInt(),b.nextInt())); // sol pot ser o 0 o 1 l'index de moment
                        break;
                   /* case 5:
                        System.out.println("Introdueix path amb mateix tipus d'entitat a l'inici i al final ( no es comprova )");
                        path = b.next();
                        System.out.println("Introdueix el nombre d'entitats a agrupar i el seu nom (del tipus de la primera entitat del path)");
                        vs = new Vector<>();
                        int nentitats = b.nextInt();
                        while(vs.size()<nentitats){
                            vs.add(b.next());
                        }
                        System.out.println("Introdueix el nombre de grups per a agrupar entitats");
                        int ngrups = b.nextInt();
                        System.out.println("Introdueix el nombre de iteracions del algorisme d'agrupament ( + iteracions, + precisió");
                        int it = b.nextInt();
                        System.out.println("numgrups seleccionats :"+ngrups);
                        EscriuClustering(qc.Clustering(path,ngrups,vs,it));
                        break;
                    case 6:
                        System.out.println("Introdueix index resultat a filtrar ( sol el 0 i 1 donen output ja que utilitzem ResImportant que és un stub)");
                        int ind = b.nextInt();
                        System.out.println("Introdueix num etiqueta a filtrar, escriu ' no ' si qualsevol, sol donen output etiq0,etiq1,etiq2,etiq3 ja que Entitat és un stub");
                        String etiq = b.next();
                        System.out.println("Introdueix a continuació la rellevancia minima i el nombre de resultats sino escriu -1");
                        System.out.println("Per defecte la rellevancia minima és 0.01 i es visualitzen tots els resultats");
                        double rel = b.nextDouble();
                        int nres = b.nextInt();
                        if(rel == -1) rel = 0.01;
                        System.out.println("(t'ho dona ordenat per id )");
                        EscriuSparseVector(qc.FiltraRelimportant(ind,rel,nres,etiq));
                        break;
                    case 7:
                        System.out.println("Introdueix index resultat a filtrar, sol dona output la 0 ja que ResClustering és un stub");
                        int index = b.nextInt();
                        System.out.println("Introdueix num etiqueta a filtrar, sol donen output etiq0,etiq1,etiq2,etiq3 ja que Entitat és un stub"); // no es filtrarà si son temes
                        etiq = b.next();
                        EscriuClustering(qc.FilterClustering(index,etiq));
                        break;*/
                    case 8:
                        System.out.println("Introdueix l'id de l'entitat  i el seu tipus ");
                        String exist;
                        b.nextLine();
                        id = b.nextInt();
                        tipus = b.next();
                        if(qc.existentitat(id,tipus)) exist= "SI";
                        else exist = "NO";
                            System.out.println("Aquesta entitat "+exist+" existeix");
                        break;
                    case 9:
                        System.out.println("Afegeix l'id d'una entitat i el seu tipus ");
                        System.out.println("El nom de l'entitat és : "+qc.getnomEntitat(b.nextInt(),b.next()));
                        break;
                    case 10:
                        System.out.println("Llista últimes relacions importants:");
                        Escriullista(qc.getListImp());
                        break;
                   /* case 11:
                        System.out.println("Llista últims clusterings :");
                        Escriuclusters(qc.getListClust());
                        break; */
                    default:
                        System.out.println("Exit");
                        exit=true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void EscriuSparseVector(SparseVector doubles) {
        System.out.println("Aquestes son les entitats amb rellevància no nu·la :");
        VectorIterator it = doubles.nonZeroIterator();
        while(it.hasNext()){
            Double rel = it.next();
            System.out.println("Entitat amb id "+it.index()+" i rellevancia "+rel);
        }
    }

    private static void EscriuClustering(Vector<Vector<String>> clustering) {
        for(int i=0;i<clustering.size();++i){
             if(i!=clustering.size()-1) System.out.println("Grup #"+i);
            else System.out.println("Entitats no agrupades :");
            for (int j = 0; j < clustering.get(i).size() ; j++) {
                System.out.println(clustering.get(i).get(j));
            }
        }
    }

    private static void EscriuCreuada(Vector<Pair<Integer, Double>> pairs) {
        System.out.println("Elements comuns:");
        for (int i = 0; i <pairs.size() ; i++) {
            System.out.println("Element "+i+" té la id "+pairs.get(i).getKey()+" i el valor "+pairs.get(i).getValue());
        }
    }

    private static void Escriuclusters(Vector<Pair<String, Vector<Vector<String>>>> listClust) {

        for (int i = 0; i <listClust.size() ; i++) {
            System.out.println("Path :"+listClust.get(i).getKey());
            for (int j = 0; j <listClust.get(i).getValue().size() ; j++) {
                System.out.println("Grup #"+j);
                for (int k = 0; k <listClust.get(i).getValue().get(j).size() ; k++) {
                    System.out.println("Entitat #"+k+" amb nom :"+listClust.get(i).getValue().get(j).get(k));
                }
            }
        }
    }

    private static void Escriullista(Vector<Pair<String, SparseVector>> listImp) {
        System.out.println(listImp.size());
        for (int i = 0; i < listImp.size() ; i++) {
            String nomipath = listImp.get(i).getKey();
            Pair<String,String> np = EscriunpE(nomipath);
            System.out.println("Relació " + i + " : " + np.getKey());
            System.out.println("Path definit :" + np.getValue());
            System.out.println("mida sparsevector "+listImp.get(i).getValue().length());
            VectorIterator it = listImp.get(i).getValue().nonZeroIterator();
            while (it.hasNext()) {
                Double val = it.next();
                System.out.println("id entitat: " + it.index() + " rellevancia: " + val);
            }
        }
    }

    private static Pair<String,String> EscriunpE(String key) {
        int i=0;
        Pair<String,String> p;
        while(key.charAt(i)!= '$'){
            ++i;
        }
        String nom = key.substring(0,i);
        p = new Pair<>(key.substring(0,i),key.substring(i+1)); // ara sol queda dintre el path
        return p;
    }

    private static void Escriuvector(Vector<String> strings) {
        for (int i = 0; i <strings.size() ; i++) {
            System.out.println("Entitat #"+i+" : "+strings.get(i));
        }
    }

}
