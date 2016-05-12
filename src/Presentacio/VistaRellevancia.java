package Presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaRellevancia {
    JFrame frameRel = new JFrame("vrel");
    private CtrlPresentacio cp;
    private JPanel panel1;
    private JButton enrereButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton cercaButton;

    public VistaRellevancia(CtrlPresentacio ctrlPresentacio) {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        cp = ctrlPresentacio;
        inicialitzarComponents();
    }

    private void inicialitzarComponents() {
        frameRel.add(panel1);
        inicialitzarbotons();
    }

    private void inicialitzarbotons() {
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp.VrelTOcerq();
            }
        });
    }

    public void ferInvisible() {
        frameRel.setVisible(false);
        frameRel.setEnabled(false);
    }
    public void ferVisible() {
        System.out.println("Faig visible vistarellevancia");
        frameRel.pack();
        frameRel.setVisible(true);
        frameRel.setEnabled(true);
    }
}
