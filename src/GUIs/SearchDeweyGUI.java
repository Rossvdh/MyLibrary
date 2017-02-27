/*
 GUI to search by Dewey number
 Ross van der Heyde
 15 January 2015
 */
package GUIs;

import library.Driver;

/**
 *
 * @author ross
 */
public class SearchDeweyGUI extends javax.swing.JFrame {

    /**
     * Creates new form SearchDeweyGUI
     */
    public SearchDeweyGUI(Driver d) {
        initComponents();
        driver = d;
        radDum.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupDewey = new javax.swing.ButtonGroup();
        radBetween = new javax.swing.JRadioButton();
        radExactly = new javax.swing.JRadioButton();
        lLower = new javax.swing.JLabel();
        lUpper = new javax.swing.JLabel();
        tfLower = new javax.swing.JTextField();
        tfUpper = new javax.swing.JTextField();
        butSearch = new javax.swing.JButton();
        radDum = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search by Dewey number | MyLibrary");

        groupDewey.add(radBetween);
        radBetween.setText("Between");

        groupDewey.add(radExactly);
        radExactly.setText("Exactly");

        lLower.setText("Lower bound:");

        lUpper.setText("Upper bound:");

        butSearch.setText("Search");
        butSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchActionPerformed(evt);
            }
        });

        groupDewey.add(radDum);
        radDum.setText("Dum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radBetween)
                            .addComponent(radExactly)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lLower)
                                    .addComponent(lUpper))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfUpper, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(tfLower))))
                        .addGap(0, 213, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(radDum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radBetween)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLower)
                    .addComponent(tfLower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUpper)
                    .addComponent(tfUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(radExactly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butSearch)
                    .addComponent(radDum))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //search by dewey number. Between 2 values or exactly
    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        if (radBetween.isSelected()) {
            //between values
            int lower = Integer.parseInt(tfLower.getText());
            int upper = Integer.parseInt(tfUpper.getText());

            if (lower >= upper) {
                driver.errorMessageNormal("Please ensure the lower bound is lower than the uper bound.");
            } else {
                //valid interval
                query = "SELECT title, author, deweyNumber FROM NonFiction"
                        + " WHERE deweyNumber BETWEEN " + lower + " AND " + upper;
            }

        } else if (radExactly.isSelected()) {
            //exactly
        } else {
            //niether selected
            driver.errorMessageNormal("Please select between or exaclty.");
        }
    }//GEN-LAST:event_butSearchActionPerformed

    public String getDeweyQuery() {
        return query;
    }

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
            java.util.logging.Logger.getLogger(SearchDeweyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchDeweyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchDeweyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchDeweyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchDeweyGUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSearch;
    private javax.swing.ButtonGroup groupDewey;
    private javax.swing.JLabel lLower;
    private javax.swing.JLabel lUpper;
    private javax.swing.JRadioButton radBetween;
    private javax.swing.JRadioButton radDum;
    private javax.swing.JRadioButton radExactly;
    private javax.swing.JTextField tfLower;
    private javax.swing.JTextField tfUpper;
    // End of variables declaration//GEN-END:variables
    private Driver driver;
    private String query;
}
