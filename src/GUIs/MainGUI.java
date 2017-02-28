/*
 * Library version 3
 main GUI class: input/output

 Ross van der Heyde 
 Started: 10 October 2014
 this started: 28 November 2014
 */
package GUIs;

import library.Driver;

/**
 * The class with the main method that must be run to start the program.
 * This class doesn't provide any functionality. It is just an empty
 * <code>JFrame</code> that houses the <code>JPanel</code>s that provide the
 * actual interface and functionality. This the class with the main method that
 * must be run to start the program.
 *
 * @author Ross
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI.
     */
    public MainGUI() {
        initComponents();
        setExtendedState(MainGUI.MAXIMIZED_BOTH);//maximize window

        //add additional panels
        tabPane.add(new AddPanel(driver));
        tabPane.setTitleAt(0, "Add books"); //set title of panel on tabbed pane

        tabPane.add(new UpdateBookPanel(driver));
        tabPane.setTitleAt(1, "Update books"); //set title of panel on tabbed pane
        
        tabPane.add(new ShopPanel(driver));
        tabPane.setTitleAt(2, "Shops");

        //commented out becasue search need lots of changes.
//        tabPane.add(new SearchPanel(driver));
//        tabPane.setTitleAt(2, "Search");
        //commented out because loans doesnt work
        /*tabPane.add(new LoansPanel(driver));
        tabPane.setTitleAt(3, "Loans");*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupAdd = new javax.swing.ButtonGroup();
        tabPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyLibrary | Keep track of your personal library.");

        tabPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupAdd;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
    Driver driver = new Driver();
}
