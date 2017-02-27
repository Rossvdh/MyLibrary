/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.sql.CallableStatement;
import java.sql.SQLException;
import library.Driver;

/**
 *
 * @author Ross
 */
public class TypeGUI extends javax.swing.JFrame {

    /**
     * Creates new form TypeGUI
     */
    public TypeGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        butAdd = new javax.swing.JButton();
        butCancel = new javax.swing.JButton();
        lType = new javax.swing.JLabel();
        tfType = new javax.swing.JTextField();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a type of book | MyLibrary");

        butAdd.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        butAdd.setText("Add");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });

        butCancel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        butCancel.setText("Cancel");
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });

        lType.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lType.setText("Type of book:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lType)
                .addGap(18, 18, 18)
                .addComponent(tfType, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butAdd)
                .addGap(18, 18, 18)
                .addComponent(butCancel)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lType)
                    .addComponent(tfType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAdd)
                    .addComponent(butCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds a new type of book to the database
     * @param evt 
     */
    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        Driver driver = new Driver();

        CallableStatement cstmt = driver.getCallStatement("{CALL addType(?)}");
        int num = 0;

        try {
            cstmt.setString(1, tfType.getText());
            num = cstmt.executeUpdate();

        } catch (SQLException se) {
            driver.errorMessageNormal("From TypeGUI.butAddAP: " + se);
            se.printStackTrace();
        }

        if (num == 1) {
            driver.infoMessageNormal("Type successfully added.");
            this.dispose();
        } else {
            driver.infoMessageNormal("Type could not be added added.");
        }

    }//GEN-LAST:event_butAddActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_butCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TypeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TypeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butCancel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lType;
    private javax.swing.JTextField tfType;
    // End of variables declaration//GEN-END:variables
}
