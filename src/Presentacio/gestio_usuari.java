/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author bernat
 */
public class gestio_usuari extends javax.swing.JFrame {
    private ctr_usuari_presentacio ctr_pres;
    /**
     * Creates new form gestio_usuari
     */
    public gestio_usuari(ctr_usuari_presentacio ctr) {
        initComponents();
        ctr_pres = ctr;
        if(!ctr_pres.privilegiat()) privilegiat.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Bernat Diaz
    private void initComponents() {
        modificar = new JButton();
        borrar = new JButton();
        privilegiat = new JButton();
        relacions = new JButton();
        sortir = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- modificar ----
        modificar.setText("modificar l'usuari");
        modificar.addActionListener(e -> modificarActionPerformed(e));

        //---- borrar ----
        borrar.setText("esborrar l'usuari");
        borrar.addActionListener(e -> borrarActionPerformed(e));

        //---- privilegiat ----
        privilegiat.setText("gesti\u00f3 privilegiat");
        privilegiat.addActionListener(e -> privilegiatActionPerformed(e));

        //---- relacions ----
        relacions.setText("gestio de relacions");
        relacions.addActionListener(e -> relacionsActionPerformed(e));

        //---- sortir ----
        sortir.setText("Sortir");
        sortir.addActionListener(e -> sortirActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(modificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(privilegiat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(relacions, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(148, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sortir))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(sortir)
                    .addGap(27, 27, 27)
                    .addComponent(relacions)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(modificar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(borrar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(privilegiat)
                    .addContainerGap(135, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        setVisible(false);
        ctr_pres.modificar_usuari_estandard();
    }//GEN-LAST:event_modificarActionPerformed

    private void relacionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionsActionPerformed
        setVisible(false);
        ctr_pres.gestio_relacions();
    }//GEN-LAST:event_relacionsActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
       ctr_pres.borrar_usuari_estandard();
       setVisible(false);
       ctr_pres.inici();
    }//GEN-LAST:event_borrarActionPerformed

    private void privilegiatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privilegiatActionPerformed
        setVisible(false);
        ctr_pres.gestio_privilegiat();
    }//GEN-LAST:event_privilegiatActionPerformed

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        setVisible(false);
        ctr_pres.inici();
    }//GEN-LAST:event_sortirActionPerformed

    /**
     * @param args the command line arguments
     */
    public void vista() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestio_usuari(ctr_pres).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bernat Diaz
    private JButton modificar;
    private JButton borrar;
    private JButton privilegiat;
    private JButton relacions;
    private JButton sortir;
    // End of variables declaration//GEN-END:variables
}
