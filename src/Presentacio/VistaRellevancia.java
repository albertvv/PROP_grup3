package Presentacio;

import javax.swing.*;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaRellevancia extends JDialog{
    JFrame frameRel = new JFrame("vrel");
    private JPanel panel1;
    private JButton enrereButton;
    private JTextField textField1;
    private JTextField textField2;

    public void ferInvisible() {
    }
    public void ferVisible() {
        frameRel.pack();
        frameRel.setVisible(true);
    }
}
