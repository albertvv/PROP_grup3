package Presentacio;

import javax.swing.*;
import java.awt.event.*;
/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaCerques  {
    private CtrlPresentacio cp;
    private JFrame frameVista = new JFrame("Vcerques");
    private JPanel panel1;
    private JButton relbutton;
    private JButton impbutton;
    private JButton clustbutton;

    public VistaCerques(CtrlPresentacio ctrlPresentacio) {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        cp = ctrlPresentacio;
        inicialitzarComponents();
    }

    private void inicialitzarComponents() {
        frameVista.add(panel1);
        inicialitzarbotons();
    }

    private void inicialitzarbotons() {
        relbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonObrirRel(e);
            }
        });
    }

    public void ferVisible() {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        frameVista.pack();
        frameVista.setVisible(true);
        frameVista.setEnabled(true);
    }
    public void actionPerformed_buttonObrirRel (ActionEvent event) {
        System.out.println("Antes de crear la vista secundaria");
        cp.VcerqTOrel();
        System.out.println("Despues de crear la vista secundaria");
    }

    public void desactivar() {
        frameVista.setEnabled(true);
        frameVista.setVisible(false);
    }
}
