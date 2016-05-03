package prop.grup3;

import org.la4j.Matrix;
import org.la4j.matrix.SparseMatrix;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Albert on 09/04/2016.
 */
public class QueryClustering extends Query {
    private int ngrups;
    private int niteracions;
    public QueryClustering(String path, int numgrups, Vector<Integer> vs, Matrix[] m1, Metrica m, int niteracions){
        super(path,vs,m,m1);
        this.ngrups = numgrups;
        this.niteracions = niteracions;
    }

    public Vector<Vector<Integer>> Cerca(){
        Vector<Vector<Integer>> vvs = new Vector<>();
        randommedioides(vvs);
        assignagrups(vvs);
        for(int i=0;i<niteracions;++i) { // es podria fer un while escentren on fos una var bool retornada pel conjunt de centramedioide
            for(int j=0;j<ngrups;++j) { System.out.println("En el grup "+j+" "); centramedioide(vvs.get(j));} //es podria fer que retornes un bool per si es recentren o ja no es mouen mes
            reassigna(vvs);
        }
        return vvs;
    }

    private void reassigna(Vector<Vector<Integer>> vvs) {
        for (int i = 0; i < vvs.size(); i++) { //recorrem la tots els grups mes la fila d'elements que no s'han pogut agrupar
            int j=1;
            while(j<vvs.get(i).size()){
                double relmedioide=0;
                int num=ngrups;
                for (int k = 0; k < ngrups ; k++) {
                    double aux = dist(vvs.get(i).get(j), vvs.get(k).get(0)); // vs no conté els medioides
                    System.out.println(vvs.get(i).get(j)+" te una rellevancia amb medioide grup :"+k+" de :"+aux);
                    if (aux > relmedioide) {
                        num = k; //num es el grup on va
                        relmedioide = aux;
                    }
                }
                System.out.println("L'entitat amb nom "+vvs.get(i).get(j)+" anirà al grup :"+num);
                if(num!=i) {
                    vvs.get(num).add(vvs.get(i).get(j)); //Afegim al nou grup
                    vvs.get(i).remove(j); // l'esborrem del antic no fa falta aumentar el comptador perque al esborrar-ne un ja decrementen els indexos
                }else ++j;
            }
        }
    }

    private void assignagrups(Vector<Vector<Integer>> vvs) {
        for (int i = 0; i < vs.size() ; i++) {
            double relmedioide=0;
            int num=ngrups; //si no superen la rellevancia 0 no es fiquen a cap grup que significa anar a una fila especial
            for (int j = 0; j < ngrups ; j++) {
                double aux = dist(vs.get(i), vvs.get(j).get(0)); // vs no conté els medioides
                System.out.println(vs.get(i)+" i "+vvs.get(j).get(0)+" amb rellevancia : "+aux);
                if (aux > relmedioide) {
                    num = j;
                    relmedioide = aux;
                }
            }
            System.out.println("L'entitat amb nom "+vs.get(i)+" anirà al grup "+num);
            vvs.get(num).add(vs.get(i));
        }
    }

    private double dist(Integer s, Integer s1) {
        return m.ComputarMetrica(s,s1,path,m1);
    }

    private void randommedioides(Vector<Vector<Integer>> vvs) {
        Random r = new Random();
        for(int i=0;i<ngrups;++i){
            int randomint = r.nextInt(vs.size());
            vvs.add(new Vector<>());
            System.out.println(vs.get(randomint)+" es el medioide del grup "+i);
            vvs.get(i).add(vs.get(randomint)); //Cada fila es un grup;
            vs.remove(randomint);
        }
        vvs.add(new Vector<>()); // nova fila per a les entitats no agrupades
    }

    private void centramedioide(Vector<Integer> vec) { // es podria fer que retornes un bool per si no ha fet falta recentrar i aixi no faria falta fer iteracions de centreig
        int posmed = 0;
        double dmitja = calculadistmitja(vec,0);
//        System.out.println("distmitja medioide :"+dmitja);  // dmitja del medioide
        for (int i = 1; i < vec.size() ; i++) {
            double aux = calculadistmitja(vec,i);
//            System.out.println("distmitja del element :"+i+" és :"+aux);
            if(aux>dmitja){
                posmed = i;
                dmitja=aux;
            }
        }
//        System.out.println("nou medioide posicio :"+posmed);
        if(posmed!=0){
            Collections.swap(vec,0,posmed);
            System.out.println(vec.firstElement()+" s'ha convertit en el nou medioide");
        }else System.out.println("No hem canviat el medioide");
        //calcula relevanciamitja per a cada element de la fila i busquem qui té la maxima que serà el nou medioide
        //relevanciamitja = Erelevancies/ #elements-1 (no es fa amb ell mateix)
    }

    private Double calculadistmitja(Vector<Integer> vec, int j) {
        double dmitja=0;
        for (int i = 0; i < vec.size() ; i++) {
            if(i!=j){
                dmitja+= m.ComputarMetrica(vec.get(i),vec.get(j),path,m1);
            }
        }
        dmitja/= vec.size()-1; //no es fa sobre si mateix
        return dmitja;
    }

}
