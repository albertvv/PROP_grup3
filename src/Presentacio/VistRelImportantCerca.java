package Presentacio;

import javax.swing.*;


public class VistRelImportantCerca {

    private JButton enrereButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button2;

    private JPanel panel;
    private JFrame frameVista = new JFrame("VistaRelImportant");

    public void init() {
        System.out.println
                ("isEventDispatchThread " + SwingUtilities.isEventDispatchThread());
        frameVista.pack();
        frameVista.setVisible(true);
        frameVista.add(panel);
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistRelImportantCerca vr = new VistRelImportantCerca();
                        vr.init();
                    }});
    }
}
