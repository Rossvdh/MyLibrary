/*
 GUI to search by Dewey number
 Ross van der Heyde
 15 January 2015
 */
package gui;

import library.Driver;
import util.PopUpMessages;

import java.awt.event.KeyEvent;
import java.util.logging.Logger;

/**
 * Provides interface for entering (a range of) Dewey numbers and searching for
 * them.
 *
 * @author ross
 */
public class SearchDeweyGUI extends javax.swing.JFrame {
    private static Logger logger = Logger.getLogger(AddRole.class.getName());
    private javax.swing.JButton butSearch;
    private javax.swing.ButtonGroup groupDewey;
    private javax.swing.JLabel lLower;
    private javax.swing.JLabel lUpper;
    private javax.swing.JRadioButton radBetween;
    private javax.swing.JRadioButton radDum;
    private javax.swing.JRadioButton radExactly;
    private javax.swing.JTextField tfLower;
    private javax.swing.JTextField tfUpper;
    private String query;

    /**
     * Creates new form SearchDeweyGUI.
     *
     * @param d An instance of <code>Driver</code>
     */
    public SearchDeweyGUI(Driver d) {
        initComponents();
        radDum.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
        butSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                butSearchKeyReleased(evt);
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
    }// </editor-fold>

    /**
     * search by dewey number. Between 2 values or exactly
     *
     * @param evt
     */
    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {
        if (radBetween.isSelected()) {
            int lower = Integer.parseInt(tfLower.getText());
            int upper = Integer.parseInt(tfUpper.getText());

            if (lower >= upper) {
                PopUpMessages.errorMessageNormal("Please ensure the lower " +
                        "bound is lower than the upper bound.");
            } else {
                //TODO sproc
                query = "SELECT title, author, deweyNumber FROM NonFiction"
                        + " WHERE deweyNumber BETWEEN " + lower + " AND " + upper;
            }

        } else if (radExactly.isSelected()) {
            //TODO exactly
        } else {
            //neither selected
            PopUpMessages.errorMessageNormal("Please select between or " +
                    "exactly.");
        }
    }

    private void butSearchKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butSearchActionPerformed(null);
        }
    }

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
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchDeweyGUI(null).setVisible(true);
            }
        });
    }
}
