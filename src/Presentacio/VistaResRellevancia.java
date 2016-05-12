package Presentacio;

import javax.swing.*;

/**
 * Created by albert.val.vila on 12/05/2016.
 */
public class VistaResRellevancia {
    private JFrame frameRes = new JFrame("vrel");
    private JPanel panel1;
    private JTextField textField1;
    private CtrlPresentacio cp;

    public VistaResRellevancia(CtrlPresentacio ctrlPresentacio,Double r) {
        System.out.println("Instancio Vista Resultat Rellevancia");
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        cp = ctrlPresentacio;
        inicialitzarComponents();
        textField1.setText(r.toString());
    }

    private void inicialitzarComponents() {
        frameRes.add(panel1);
    }
    public void ferVisible() {
        System.out.println("Faig visible vistarellevancia");
        frameRes.pack();
        frameRes.setVisible(true);
        frameRes.setEnabled(true);
    }
}
