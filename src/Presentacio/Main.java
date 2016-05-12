package Presentacio;

/**
 * Created by albert.val.vila on 12/05/2016.
 */
public class Main {
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        CtrlPresentacio cp = new CtrlPresentacio();
                        cp.init();
                    }});
    }
}
