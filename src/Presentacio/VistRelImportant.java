package Presentacio;

import javax.swing.*;

public class VistRelImportant {
    private JButton realitzarCercaDeRelacióButton;
    private JButton consultarAnteriorsRelacionsImportantsButton;
    private JButton enrereButton;
    private CtrlPresentacio cp = new CtrlPresentacio();
    private JPanel panel1;
    private JFrame frameVista = new JFrame("VistRelImportant");
    public VistRelImportant(CtrlPresentacio ctrlPresentacio) {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        cp = ctrlPresentacio;
        inicialitzarComponents();
    }
    private void inicialitzarComponents() {
        frameVista.add(panel1);
        //inicialitzarbotons();
    }
    public void init() {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        frameVista.pack();
        frameVista.setVisible(true);
    }
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        CtrlPresentacio ctr = new CtrlPresentacio();
                        VistRelImportant vr = new VistRelImportant(ctr);
                        vr.init();
                    }});
    }
}
