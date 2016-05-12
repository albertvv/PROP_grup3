package Presentacio;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class CtrlPresentacio {
    private VistaCerques vcerques = null;
    private VistaRellevancia vrel = null;
//////////////////Constructor i metodes ini
    public CtrlPresentacio(){
        if(vcerques==null) vcerques = new VistaCerques(this);

    }
    public void init() {
        vcerques.ferVisible();
    }
/////////////////Sync vistes
    public void VcerqTOrel(){
       vcerques.desactivar();
       if(vrel==null) vrel = new VistaRellevancia();
        vrel.ferVisible();
    }
    public void VrelTOcerq(){
//        vrel.ferInvisible();
//        vcerques.setEnabled(true);
    }


    //////////AccesControladorDomini

}
