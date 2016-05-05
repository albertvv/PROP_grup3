package prop.grup3;

import javafx.util.Pair;
import org.la4j.Matrix;
import org.la4j.iterator.VectorIterator;
import org.la4j.vector.SparseVector;
import org.la4j.vector.sparse.CompressedVector;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Albert on 15/04/2016.
 */
public class ControladorCerques {
    private Metrica m;
    private ConjRes lr;
    private ControladorGrafo cg;
    private Matrix[] m1;
    public ControladorCerques() throws IOException {
        cg = new ControladorGrafo();
        cg.cargarGrafo();
        this.m= new Metrica();
        lr = new ConjRes();
        System.out.println("matrius");
        m1 = new Matrix[]{cg.getGrafo().getMatriz("Autor"),
                cg.getGrafo().getMatriz("Conferencia"),cg.getGrafo().getMatriz("Termino")};
        System.out.println("fimatrius");
    }
    public Double CercaRellevancia(String path, Vector<Integer> vs){
        for (int i = 0; i < vs.size() ; i++) {
           if(!vs.get(i).equals(-1)) vs.set(i,IDtoindex(vs.get(i),Entitatequivalent(path.charAt(i))));
        }
        QueryRellevancia qr = new QueryRellevancia(path,vs,m,m1);
        return qr.Cerca();
    }

    private Integer IDtoindex(Integer id,String tipus) {
        System.out.println("el index de :"+id+" es :"+cg.getGrafo().getIndiceid(id,tipus));
        return cg.getGrafo().getIndiceid(id,tipus);
    }
    private Integer IndextoID(Integer index,String tipus){
        System.out.println("la id del index :"+index+" es: "+cg.getGrafo().getidIndice(index,tipus));
        return cg.getGrafo().getidIndice(index,tipus);
    }

    public SparseVector CercaRelimportant(String path, Integer entitat1){
        entitat1 = IDtoindex(entitat1,Entitatequivalent(path.charAt(0)));
        QueryRelimportant qi= new QueryRelimportant(path,entitat1,m,m1);
        SparseVector sv= qi.Cerca();
        SparseVector sv2= new CompressedVector(cg.getGrafo().getLastID()+1);
        VectorIterator it = sv.nonZeroIterator();
        while(it.hasNext()) {
            Double rel = it.next();
            sv2.set(IndextoID(it.index(),Entitatequivalent(path.charAt(path.length()-1))),rel);
        }
        ResImportant r = new ResImportant(qi,sv2);
        lr.addRelImp(r);
        return sv2;
    }
    public Vector<String> CercaRelDirecta(Integer id,String tipusentitat){ // s'hauria de canviar per id ja que fixat nom i tipus poden haver-hi repetits
        Vector<Entidad> ve= cg.getGrafo().getRelacion(id,tipusentitat);
        Vector<String> vs = new Vector<>(); //canviar a integer
        for (int i = 0; i <ve.size() ; i++) {
            vs.add(ve.get(i).getNombre());
        }
        return vs;
    }
    public Vector<Pair<Integer,Double>> CercaCreuada(int i1, int i2){
        RelimpCreuada creu = new RelimpCreuada(lr.getRelImp().get(i1),lr.getRelImp().get(i2));
        return creu.CreuaResultats();
    }
    public Vector<Vector<Integer>> Clustering(String path, int numgrups, Vector<Integer> vs, int niteracions){
        QueryClustering c = new QueryClustering(path,numgrups,vs,m1,m,niteracions);
        return c.Cerca();
    }
    public SparseVector FiltraRelimportant (int i1,double threshold,int numres,String etiq){ //id resultat que es vol filtrar , sino s'indica threshold es 0 per defecte
        ResImportant r = lr.getRelImp().get(i1);
        SparseVector sv = (SparseVector) r.Resultat().copy(); //clonem
        //threshold
        Vector<Pair<Integer,Double>> v = new Vector<>(); //guardarem els valors per
        VectorIterator it = sv.nonZeroIterator();
        while(it.hasNext()){
            Double rel = it.next();
            String p = r.getQuery().getPath();
             p=Entitatequivalent(p.charAt(p.length()-1));
            if(rel< threshold ||  ( !etiq.equals("no") && !getEntitat(getnomEntitat(it.index(),p),it.index(),p).getEtiqueta().equals(etiq))) it.set(0);
            else v.add(new Pair<>(it.index(),rel)); // ens quedem sol si estan o per sobre el threshold o mateix etiqueta
        }
        Collections.sort(v, new Comparator<Pair<Integer, Double>>() { //ordeno aqui per rellevancia per filtrar per rellevancia i nombre de resultats
            @Override
            public int compare(Pair<Integer, Double> o1, Pair<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        if(numres!=-1) {
            while (v.size() > numres) {
                sv.set(v.get(v.size() - 1).getKey(), 0.0);
                v.removeElementAt(v.size() - 1);
            }
        }
        return sv;
    }
    public Vector<Vector<Integer>> FilterClustering(int i1,String etiq){ //etiqueta a filtar
        ResClustering r = lr.getClust().get(i1);
        Vector<Vector<Integer>> vs = (Vector<Vector<Integer>>) r.Resultat().clone();
        for (int i = 0; i < vs.size() ; i++) {
            for (int j = 0; j <vs.get(i).size() ; j++) {
                String p = Entitatequivalent(r.getQuery().getPath().charAt(0));
                if(!cg.getGrafo().getEntidad(getnomEntitat(vs.get(i).get(j),p),vs.get(i).get(j),p).getEtiqueta().equals(etiq)){
                    vs.get(i).remove(j);
                }
            }
        }
        return vs;
    }
    public boolean existentitat(Integer id,String tipus){
            return cg.getGrafo().exists(null,id,tipus);
    }
    public String getnomEntitat(int id,String tipus){
        return cg.getGrafo().getNombre_ID(id,tipus);
    }
    public Vector<Pair<String,SparseVector>>getListImp(){
        Vector<Pair<String,SparseVector>> vs = new Vector<>();
        Vector<ResImportant> v = lr.getRelImp();
        for (int i = 0; i < v.size() ; i++) {
            ResImportant r = v.get(i);
            vs.add(new Pair<>(r.getQuery().getID()+"$"+r.getQuery().getPath(),r.Resultat())); // id entitat + path
        }
        return vs;
    }

    public Vector<Pair<String,Vector<Vector<Integer>>>>getListClust(){
        Vector<Pair<String,Vector<Vector<Integer>>>> vs = new Vector<>();
        Vector<ResClustering> v = lr.getClust();
        for (int i = 0; i <v.size() ; i++) {
            ResClustering r = v.get(i);
            vs.add(new Pair<>(r.getQuery().getPath(),r.Resultat()));
        }
        return vs;
    }
    public Vector<Integer> getIDs(String nom,String tipus){
        return null;
    }
    private Entidad getEntitat(String nom,Integer id, String tipus){
        return cg.getGrafo().getEntidad(nom,id,tipus);
    }
    private String Entitatequivalent(char c){ // exemple A -> Autor
        switch(c){
            case 'A':
                return "Autor";
            case 'P':
                return "Paper";
            case 'C':
                return "Conferencia";
            case 'T':
                return "Termino";
        }
        return null;
    }
}