package Presentacio;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class CtrlPresentacio {
    private VistaCerques vcerques = null;
    private VistaRellevancia vrel = null;
//////////////////Constructor i metodes ini
    public CtrlPresentacio(){
        if(vcerques==null)vcerques = new VistaCerques();
    }
    public void inicialitzarPresentacio() {
        vcerques.ferVisible();
    }
/////////////////Sync vistes
    public void VcerqTOrel(){
        vcerques.setEnabled(false);
        if(vrel==null) vrel = new VistaRellevancia();
    }
    public void VrelTOcerq(){
        vrel.ferInvisible();
        vcerques.setEnabled(true);
    }
}
