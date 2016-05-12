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


    //////////AccesControladorDomini

}
