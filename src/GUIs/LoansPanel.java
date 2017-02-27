/*
 Panel with functions for loaning books.
 Ross van der Heyde
 */
package GUIs;

import GUIs.AddBorrower;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import library.Book;
import library.Borrower;
import library.Driver;
import library.Fiction;
import library.NonFiction;

/**
 *
 * @author ross
 */
public class LoansPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoansPanel
     */
    public LoansPanel(Driver d) {
        initComponents();
        radDum.setVisible(false);
        radDum2.setVisible(false);
        driver = d;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoansGroup = new javax.swing.ButtonGroup();
        jRadioButton4 = new javax.swing.JRadioButton();
        groupFNF = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfBookID = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        tfBorrowerID = new javax.swing.JTextField();
        radBorrow = new javax.swing.JRadioButton();
        radReturn = new javax.swing.JRadioButton();
        radDum = new javax.swing.JRadioButton();
        butCheck = new javax.swing.JButton();
        butAdd = new javax.swing.JButton();
        butClear = new javax.swing.JButton();
        butViewLoans = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        butViewBorrowers = new javax.swing.JButton();
        radFiction = new javax.swing.JRadioButton();
        radNonFiction = new javax.swing.JRadioButton();
        radDum2 = new javax.swing.JRadioButton();
        butUpdate = new javax.swing.JButton();
        butDelete = new javax.swing.JButton();

        jRadioButton4.setText("jRadioButton4");

        jLabel1.setText("Borrower ID:");

        jLabel2.setText("Book ID:");

        jLabel3.setText("Date:");

        tfDate.setToolTipText("Date in the format DD/MM/YYY");

        LoansGroup.add(radBorrow);
        radBorrow.setText("Borrowing");

        LoansGroup.add(radReturn);
        radReturn.setText("Returning");

        LoansGroup.add(radDum);
        radDum.setText("dum");

        butCheck.setText("Check in/out");
        butCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCheckActionPerformed(evt);
            }
        });

        butAdd.setText("Add new borrower");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });

        butClear.setText("Clear");
        butClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });

        butViewLoans.setText("View all loans");
        butViewLoans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewLoansActionPerformed(evt);
            }
        });

        butViewBorrowers.setText("View all borrowers");
        butViewBorrowers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewBorrowersActionPerformed(evt);
            }
        });

        groupFNF.add(radFiction);
        radFiction.setText("Fiction");

        groupFNF.add(radNonFiction);
        radNonFiction.setText("Non-fiction");

        groupFNF.add(radDum2);
        radDum2.setText("jRadioButton3");

        butUpdate.setText("Update borrower");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        butDelete.setText("Delete borrower");
        butDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radBorrow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radReturn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDate)
                        .addGap(214, 214, 214)
                        .addComponent(butCheck)
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBorrowerID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radFiction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radNonFiction))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radDum2)
                                    .addComponent(radDum))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butDelete)
                                .addGap(1, 1, 1)))
                        .addComponent(butViewLoans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butViewBorrowers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butClear)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBorrowerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radFiction)
                    .addComponent(radNonFiction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radBorrow)
                    .addComponent(radReturn)
                    .addComponent(jLabel3)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(radDum2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radDum)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butAdd)
                            .addComponent(butClear)
                            .addComponent(butViewLoans)
                            .addComponent(butViewBorrowers)
                            .addComponent(butUpdate)
                            .addComponent(butDelete))
                        .addGap(22, 22, 22))))
        );
    }// </editor-fold>//GEN-END:initComponents

    //return or borrow a book
    private void butCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCheckActionPerformed

        Borrower bor = createBorrower();
        String date = tfDate.getText();

        if (driver.dateFormatValid(date)) {
            //valid date format, perform check out/in
            if (radBorrow.isSelected()) {
                //check out

                Book book = createBook();//create book

                if (!book.isOnLoan()) {
                    //book is not on loan, can be loaned out

                    //perform loan, inform user of success
                    if (bor.borrow(book, date)) {
                        driver.infoMessageNormal("\"" + book.getTitle() + "\" loaned successfully to " + bor.getName());

                    } else {
                        driver.errorMessageNormal("Book could not be loaned");
                    }

                } else {
                    //is on loan
                    driver.errorMessageNormal("\"" + book.getTitle() + "\" is already on loan.");

                }

            } else if (radReturn.isSelected()) {
                //check in / returning

                Book book = createBook();

                if (book.isOnLoan()) {
                    //book is on loan, and can be returned

                    if (bor.returnBook(book, date)) {
                        driver.infoMessageNormal("\"" + book.getTitle() + "\" has been returned.");

                    } else {
                        driver.infoMessageNormal("The book could not be returned.");
                    }

                } else {
                    //not on loan
                    driver.infoMessageNormal("\"" + book.getTitle() + "\" is not on loan.");
                }

            } else {
                driver.errorMessageNormal("Please select whether the book is being checked in or being returned.");
            }

        } else {
            //invalid format
            driver.errorMessageNormal("Please ensure the date is in the format DD/MM/YYY");
        }


    }//GEN-LAST:event_butCheckActionPerformed

    //create a fiction or NF book depending on what is selected
    private Book createBook() {
        Book book = null;

        try {

            //determine if fiction or non-fiction
            if (radFiction.isSelected()) {
                //fiction book
                book = new Fiction(Integer.parseInt(tfBookID.getText()));

            } else if (radNonFiction.isSelected()) {
                //non-fiction book
                book = new NonFiction(Integer.parseInt(tfBookID.getText()));

            } else {
                driver.errorMessageNormal("Please selecte fiction or non-fiction.");
            }
        } catch (NumberFormatException nfe) {
            driver.errorMessageNormal("Please enter numbers only the Borrower ID and Book ID fields.");
        }
        return book;
    }

    //creates a new borrower
    private Borrower createBorrower() {
        Borrower bor = null;
        try {
            bor = new Borrower(Integer.parseInt(tfBorrowerID.getText()), driver);
        } catch (NumberFormatException nfe) {
            driver.errorMessageNormal("Please enter numbers only the Borrower ID and Book ID fields.");
        }
        return bor;
    }

    //view all current loans. Borrower name, id, title, bookID, date borrowed.
    private void butViewLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewLoansActionPerformed
        //ResultSet rs = driver.query("select borrowerID, fullName, bookID, title, date from BBLink L, "
        //        + "Borrowers B, AllBooks A where A.id=bookID and B.id = borrowerID");

        CallableStatement cstmt = driver.getCallStatement("{CALL viewAllLoans()}");
        ResultSet rs = null;
        try {
            rs = cstmt.executeQuery();

            JTable myTable = new JTable(driver.buildTableModel(rs));
            rs.close();
            cstmt.close();

            scrollPane.setViewportView(myTable);
        } catch (SQLException se) {
            driver.errorMessageNormal("From LoansPanel.butViewLoansAP: " + se);
            se.printStackTrace();
        }

    }//GEN-LAST:event_butViewLoansActionPerformed

    //add new borrower
    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        AddBorrower ab = new AddBorrower();
        ab.setVisiblePanel(0);
        ab.setVisible(true);
    }//GEN-LAST:event_butAddActionPerformed

    //clear all textfields, tables, etc
    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butClearActionPerformed
        radDum.setSelected(true);
        radDum2.setSelected(true);
        tfBookID.setText("");
        tfBorrowerID.setText("");
        tfDate.setText("");
        scrollPane.setViewportView(null);
    }//GEN-LAST:event_butClearActionPerformed

    //display all details of all borrowers
    private void butViewBorrowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewBorrowersActionPerformed
        CallableStatement cstmt = driver.getCallStatement("{CALL viewAllBorrowers()}");

        try {
            ResultSet rs = cstmt.executeQuery();

            JTable myTable = new JTable(driver.buildTableModel(rs));
            rs.close();
            cstmt.close();

            scrollPane.setViewportView(myTable);
        } catch (SQLException se) {
            driver.errorMessageNormal("From LoansPanel.butViewBorrowersAP: " + se);
            se.printStackTrace();
        }

    }//GEN-LAST:event_butViewBorrowersActionPerformed

    //open GUI to update a borrower
    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        AddBorrower ub = new AddBorrower();
        ub.setVisiblePanel(1);
        ub.setVisible(true);
    }//GEN-LAST:event_butUpdateActionPerformed

    //open GUI to delete borrower
    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        AddBorrower db = new AddBorrower();
        db.setVisiblePanel(2);
        db.setVisible(true);
    }//GEN-LAST:event_butDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup LoansGroup;
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butCheck;
    private javax.swing.JButton butClear;
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butUpdate;
    private javax.swing.JButton butViewBorrowers;
    private javax.swing.JButton butViewLoans;
    private javax.swing.ButtonGroup groupFNF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton radBorrow;
    private javax.swing.JRadioButton radDum;
    private javax.swing.JRadioButton radDum2;
    private javax.swing.JRadioButton radFiction;
    private javax.swing.JRadioButton radNonFiction;
    private javax.swing.JRadioButton radReturn;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField tfBookID;
    private javax.swing.JTextField tfBorrowerID;
    private javax.swing.JTextField tfDate;
    // End of variables declaration//GEN-END:variables
    private Driver driver = null;
}
