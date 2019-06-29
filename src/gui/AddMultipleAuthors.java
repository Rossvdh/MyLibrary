/*GUI for adding multiple authors for one book
Ross van der Heyde
18 Feb 2017
 */
package gui;

import library.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This Gui provides for adding multiples authors and their roles when adding
 * a new book to the database
 * @author Ross
 */
public class AddMultipleAuthors extends javax.swing.JFrame {
    private static Logger logger = Logger.getLogger(AddMultipleAuthors.class.getName());

    // Variables declaration - do not modify
    private javax.swing.JButton butAddAuthors;
    private javax.swing.JButton butAddRoles;
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butClear;
    private javax.swing.JButton butInsert;
    private javax.swing.JButton butNewAuthors;
    private javax.swing.JComboBox<String> comboAuthor;
    private javax.swing.JComboBox<String> comboRoles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labRole;
    private javax.swing.JTextArea textArea;
    // End of variables declaration
    
    private List<Author> bookAuthors = new ArrayList<>();
    private static final Driver DRIVER = new Driver();
    
    /**
     * Creates new form AddMultipleAuthors
     */
    public AddMultipleAuthors() {
        initComponents();

        iniRolesComboBox();
        comboRoles.setSelectedItem("Author");

        comboAuthor.setModel(DRIVER.getComboBoxModel(ComboBoxType.AUTHOR));
        AutoCompletion.enable(comboAuthor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        butCancel = new javax.swing.JButton();
        labName = new javax.swing.JLabel();
        butNewAuthors = new javax.swing.JButton();
        butAddRoles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        labRole = new javax.swing.JLabel();
        butInsert = new javax.swing.JButton();
        comboRoles = new javax.swing.JComboBox<>();
        butClear = new javax.swing.JButton();
        butAddAuthors = new javax.swing.JButton();
        comboAuthor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add multiple authors for the book");

        butCancel.setText("Cancel");
        butCancel.addActionListener(evt -> butCancelActionPerformed(evt));

        labName.setText("Author/contributor name:");

        butNewAuthors.setText("Create new author");
        butNewAuthors.addActionListener(evt -> createNewAuthor(evt));

        butAddRoles.setText("Create new roles");
        butAddRoles.addActionListener(evt -> butAddRolesActionPerformed(evt));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        labRole.setText("Role:");

        butInsert.setText("Insert");
        butInsert.addActionListener(evt -> butInsertActionPerformed(evt));

        butClear.setText("Clear");
        butClear.addActionListener(evt -> butClearActionPerformed(evt));

        butAddAuthors.setText("Add authors");
        butAddAuthors.addActionListener(evt -> butAddAuthorsActionPerformed(evt));

        comboAuthor.setEditable(true);
        comboAuthor.setToolTipText("Select the author's name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labName)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(comboAuthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(comboRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(butInsert))
                                                        .addComponent(labRole)))
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(butNewAuthors)
                                                .addGap(23, 23, 23)
                                                .addComponent(butAddRoles)
                                                .addGap(52, 52, 52)
                                                .addComponent(butAddAuthors)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                                .addComponent(butClear)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(butCancel)))
                                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labName)
                                        .addComponent(labRole))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(butInsert)
                                        .addComponent(comboRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(butCancel)
                                        .addComponent(butNewAuthors)
                                        .addComponent(butAddRoles)
                                        .addComponent(butClear)
                                        .addComponent(butAddAuthors))
                                .addGap(19, 19, 19))
        );

        pack();
    }

    /**
     * Shows the add new author window
     *
     * @param evt the button click event
     */
    private void createNewAuthor(ActionEvent evt) {
        AddNewAuthors addNewAuthors = new AddNewAuthors();
        addNewAuthors.setVisible(true);
        addNewAuthors.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                //refresh combo authors
                comboAuthor.setModel(DRIVER.getComboBoxModel(ComboBoxType.AUTHOR));
            }
        });

    }

    /**
     * Disposes of this window
     * @param evt the button click event
     */
    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * Displays the AddRole GUI so a new role can be added
     * @param evt button click event
     */
    private void butAddRolesActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);

        AddRole addR = new AddRole();

        addR.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                windowClosedEvt(evt);
            }
        });

        addR.setVisible(true);
    }

    /**
     * Runs when the insert button is clicked. Displays the author in the
     * authors text area and adds the author to the list of authors field
     * @param evt
     */
    private void butInsertActionPerformed(java.awt.event.ActionEvent evt) {
        Role role = new Role(comboRoles.getSelectedItem().toString());

        String authorName = comboAuthor.getSelectedItem().toString();
        Author author = new Author(authorName, role);
        bookAuthors.add(author);

        textArea.append(author.getName() + ", " + author.getRole().getRoleName() + "\n");

        comboAuthor.setSelectedIndex(-1);
        comboRoles.setSelectedItem("Author");
    }

    /**
     * Runs when the clear button is clicked. Removes text from text fields and text areas,
     * and select nothing in comboBoxes.
     * @param evt button click event
     */
    //
    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {
        comboAuthor.setSelectedIndex(-1);
        comboRoles.setSelectedItem("Author");
        textArea.setText("");
    }

    /**
     * Runs when the add authors button is clicked. Disposes of this window,
     * passing control and list of authors back to MainGUI
     * @param evt button click event
     */
    private void butAddAuthorsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void windowClosedEvt(java.awt.event.WindowEvent evt) {
        this.setVisible(true);
    }

    /**
     * Returns an <code>ArrayList</code> of the <code>Author</code>s entered by
     * the user.
     *
     * @return list of <code>Authors</code> of the book about to be added.
     */
    public List<Author> getAuthors() {
        return bookAuthors;
    }

    /**
     * Initializes the model of the Roles comboBox to all the <code>Roles</code>
     * in the database, sorted alphabetically.
     */
    private void iniRolesComboBox() {
        DefaultComboBoxModel<String> model =
                DRIVER.getComboBoxModel(ComboBoxType.ROLE);

        comboRoles.setModel(model);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, ex.toString(), ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMultipleAuthors().setVisible(true);
            }
        });
    }
}