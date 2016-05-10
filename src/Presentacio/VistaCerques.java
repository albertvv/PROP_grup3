package Presentacio;

import javax.swing.*;
import java.awt.event.*;
/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaCerques extends JDialog {
    private CtrlPresentacio cp;
    private JFrame frameVista = new JFrame("Vcerques");
    private JPanel panel1;
    private JButton relbutton;
    private JButton impbutton;
    private JButton clustbutton;
    public VistaCerques(){
        setContentPane(panel1);
        setModal(true);
        relbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void onrelbutton() {

    }

    public static void main(String[] args) {
        VistaCerques dialog = new VistaCerques();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void ferVisible() {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        frameVista.pack();
        frameVista.setVisible(true);
    }
    public void actionPerformed_buttonAbrirJFrame (ActionEvent event) {
        System.out.println("Antes de crear la vista secundaria");
        cp.VcerqTOrel();
        System.out.println("Despues de crear la vista secundaria");
    }
}
