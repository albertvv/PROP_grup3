package Presentacio;

import prop.grup3.ControladorCerques;

import java.io.IOException;
import java.util.Vector;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class CtrlPresentacio {
    private VistaCerques vcerques = null;
    private VistaRellevancia vrel = null;
    private VistaResRellevancia vrelres = null;
    private ControladorCerques cc;
//////////////////Constructor i metodes ini
    public CtrlPresentacio(){
        try {
            cc = new ControladorCerques();
        } catch (IOException e) {
            e.printStackTrace(); //no s'han pogut carregar les dades
        }
        if(vcerques==null) vcerques = new VistaCerques(this);

    }
    public void init() {
        vcerques.ferVisible();
    }
/////////////////Sync vistes
    public void VcerqTOrel(){
        System.out.println("desactivo vista");
       vcerques.desactivar();
        System.out.println("creovistarellevancia");
       if(vrel==null) vrel = new VistaRellevancia(this);
        System.out.println("faigvisible");
        vrel.ferVisible();
    }
    public void VrelTOcerq(){
        vrel.ferInvisible();
        vcerques.ferVisible();
    }
    public void VrelTOVres(Double r){
        vrel.ferInvisible();
        if(vrelres==null) vrelres = new VistaResRellevancia(this,r);
        System.out.println("faigvisible");
        vrelres.ferVisible();
    }

    //////////AccesControladorDomini
    public Vector<Integer> CheckEntitat(String nom,String tipus) {
        return cc.getIDs(nom, tipus);
    }
    public Double CercaRellevancia(String path, Vector<Integer> vs){
        return cc.CercaRellevancia(path,vs);
    }
}
