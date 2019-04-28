/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import library.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides interface for searching the database for books and displaying the
 * results.
 *
 * @author ross
 */
public class SearchPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchPanel.
     *
     * @param d An instance of <code>Driver</code>
     */
    public SearchPanel(Driver d) {
        initComponents();
        driver = d;
        comboSearchByItemStateChanged(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        groupSearch = new javax.swing.ButtonGroup();
        lSearchBy = new javax.swing.JLabel();
        comboSearchBy = new javax.swing.JComboBox();
        lKeyword = new javax.swing.JLabel();
        tfKeyword = new javax.swing.JTextField();
        butSearchText = new javax.swing.JButton();
        comboCrit = new javax.swing.JComboBox();
        searchPane = new javax.swing.JScrollPane();
        butClear = new javax.swing.JButton();
        butViewAll = new javax.swing.JButton();
        butDewey = new javax.swing.JButton();
        comboSearchItem = new javax.swing.JComboBox();
        radFiction = new javax.swing.JRadioButton();
        radNonFiction = new javax.swing.JRadioButton();
        radDum = new javax.swing.JRadioButton();
        radAllBooks = new javax.swing.JRadioButton();

        jScrollPane1.setViewportView(jTree1);

        setPreferredSize(new java.awt.Dimension(1037, 604));

        lSearchBy.setText("Search by:");

        comboSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Title", "Price", "Place bought", "Month bought", "Year bought", "Month and year bought", "First published" }));
        comboSearchBy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSearchByItemStateChanged(evt);
            }
        });

        lKeyword.setText("Keyword(s):");

        butSearchText.setText("Search");
        butSearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchTextActionPerformed(evt);
            }
        });
        butSearchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                butSearchTextKeyReleased(evt);
            }
        });

        comboCrit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Less than/before", "equal to/in", "Greater than/after" }));

        butClear.setText("Clear");
        butClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });
        butClear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                butClearKeyReleased(evt);
            }
        });

        butViewAll.setText("View all");
        butViewAll.setToolTipText("Select fiction or non-fiction above");
        butViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewAllActionPerformed(evt);
            }
        });
        butViewAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                butViewAllKeyReleased(evt);
            }
        });

        butDewey.setText("Search by Dewey number");
        butDewey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeweyActionPerformed(evt);
            }
        });
        butDewey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                butDeweyKeyReleased(evt);
            }
        });

        groupSearch.add(radFiction);
        radFiction.setText("Fiction");
        radFiction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radFictionItemStateChanged(evt);
            }
        });

        groupSearch.add(radNonFiction);
        radNonFiction.setText("Non-fiction");
        radNonFiction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radNonFictionItemStateChanged(evt);
            }
        });

        groupSearch.add(radDum);
        radDum.setText("dum");

        groupSearch.add(radAllBooks);
        radAllBooks.setText("All books");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCrit, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lKeyword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfKeyword, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(comboSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(butSearchText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(radDum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butDewey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butViewAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butClear))
                    .addComponent(searchPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lSearchBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radFiction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radNonFiction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radAllBooks)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSearchBy)
                    .addComponent(radFiction)
                    .addComponent(radNonFiction)
                    .addComponent(radAllBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCrit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lKeyword)
                    .addComponent(tfKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSearchText))
                .addGap(18, 18, 18)
                .addComponent(searchPane, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butViewAll)
                    .addComponent(butClear)
                    .addComponent(butDewey)
                    .addComponent(radDum))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //search by text
    private void butSearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchTextActionPerformed
        CallableStatement cstmt = null;
        ResultSet rs = null;

        //determine what field to search by and create query
        switch (comboSearchBy.getSelectedIndex()) {
            case 0: {
                //search by ID
                cstmt = driver.getCallStatement("{CALL searchID(?)}");

                try {
                    cstmt.setInt(1, Integer.parseInt(tfKeyword.getText()));
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 1: {
                //search by title
                cstmt = driver.getCallStatement("{CALL searchTitle(?)}");

                //get title to search for
                String title = tfKeyword.getText();

                try {
                    //set parameter
                    cstmt.setString(1, title);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 2: {
                //author
                cstmt = driver.getCallStatement("{CALL searchAuthor(?)}");

                //get author to search for
                String author = tfKeyword.getText();

                try {
                    //set parameter
                    cstmt.setString(1, author);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 3: {
                //shop. NOT WORKING FOR NONFICTION
                cstmt = driver.getCallStatement("{CALL searchBooksPlaceBought(?)}");

                //get shop ID
                Shop shop = new Shop(comboSearchItem.getSelectedItem().toString());
                int shopID = shop.getID();

                try {
                    cstmt.setInt(1, shopID);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 4: {
                //series
                cstmt = driver.getCallStatement("{CALL searchSeries(?)}");

                //get title to search for
                int series = Integer.parseInt(tfKeyword.getText());

                try {
                    //set parameter
                    cstmt.setInt(1, series);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 5: {
                //genre. Fiction only
                cstmt = driver.getCallStatement("{CALL searchGenre(?)}");

                //get genre ID to search for
                Genre gen = new Genre(comboSearchItem.getSelectedItem().toString());
                int genreID = gen.getId();

                try {
                    cstmt.setInt(1, genreID);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case 6: {
                //type. Fiction only
                cstmt = driver.getCallStatement("{CALL searchType(?)}");

                //get type ID to search for
                TypeOfBook type = new TypeOfBook(comboSearchItem.getSelectedItem().toString());
                int typeID = type.getID();

                try {
                    cstmt.setInt(1, typeID);
                } catch (SQLException ex) {
                    driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            default: {
                System.out.println("Default");

                /*String searchBy = comboSearchBy.getSelectedItem().toString();

                // author SPROC DONE, title SPROC DONE, series SPROC DONE
                //REMEMBER SERIES IS NOW AN INT. WILL HAVE TO CHANGE ADDING PROCESS ALSO
                q = "SELECT * FROM AllBooks WHERE " + searchBy.toLowerCase()
                        + " LIKE '%" + tfKeyword.getText() + "%'";*/
            }
        }

        try {
            //print query to check that it is correct
            //System.out.println("butSearchTextActionPerformed query: " + q);

            rs = cstmt.executeQuery();

            displayTable(rs);

            //clean
            rs.close();
            cstmt.close();
        } catch (SQLException ex) {
            driver.errorMessageNormal("From searchPanel.butSearchTextAP: " + ex);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_butSearchTextActionPerformed

    /**
     * Clears all textFields and textAreas
     *
     * @param evt The button clicked
     */
    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butClearActionPerformed
        tfKeyword.setText("");
        searchPane.setViewportView(null);
        comboCrit.setSelectedIndex(0);
        comboSearchBy.setSelectedIndex(0);
        radDum.setSelected(true);
    }//GEN-LAST:event_butClearActionPerformed

    /**
     * View all Fiction or NonFiction books in the database
     *
     * @param evt
     */
    private void butViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewAllActionPerformed
        String query = "";

        if (radFiction.isSelected()) {
            //fiction. SPROC DONE
            query = "{CALL viewFiction()}";

        } else if (radNonFiction.isSelected()) {
            //non-fiction. SPROC DONE
            query = "{CALL viewNonFiction()}";

        } else {
            driver.infoMessageNormal("Please select fiction or non-fiction");
            return;
        }

        ResultSet rs = null;

        //get callable statement
        try {
            CallableStatement cstmt = driver.getCallStatement(query);

            //execute query
            rs = cstmt.executeQuery();

            displayTable(rs);

            //clean
            rs.close();
            cstmt.close();
        } catch (SQLException se) {
            driver.errorMessageNormal("From SearchPanel.butViewAllAP: " + se);
            se.printStackTrace();
        }

    }//GEN-LAST:event_butViewAllActionPerformed

    /**
     * Creates a new searchDeweyGUI so you can search by dewey number.
     *
     * @param evt
     */
    private void butDeweyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeweyActionPerformed
        SearchDeweyGUI sdg = new SearchDeweyGUI(driver);
        sdg.setVisible(true);

        ResultSet rs = driver.query(sdg.getDeweyQuery());

        displayTable(rs);
        try {
            rs.close();
        } catch (SQLException se) {
            driver.errorMessageNormal("from searchPanel.butSearchNumberAP: " + se);
            se.printStackTrace();
        }
    }//GEN-LAST:event_butDeweyActionPerformed

    /**
     * if shop, genre or type selected, blank tfKeyword and set comboSGT model
     * to selected
     *
     * @param evt
     */
    private void comboSearchByItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSearchByItemStateChanged
        String selected = comboSearchBy.getSelectedItem().toString();
        selected = selected.toLowerCase();

        switch (selected) {
            case "place bought": {
                comboSearchItem.setModel(driver.getComboBoxModel(ComboBoxType.SHOP));
                searchByComboBox();
                break;
            }
            case "genre": {
                comboSearchItem.setModel(driver.getComboBoxModel(ComboBoxType.GENRE));
                searchByComboBox();
                break;
            }
            case "type of book": {
                comboSearchItem.setModel(driver.getComboBoxModel(ComboBoxType.TYPE));
                searchByComboBox();
                break;
            }
            case "author": {
                comboSearchItem.setModel(driver.getComboBoxModel(ComboBoxType.AUTHOR));
                AutoCompletion.enable(comboSearchItem);
                searchByComboBox();

                break;
            }
            case "series": {
                comboSearchItem.setModel(driver.getComboBoxModel(ComboBoxType.SERIES));
                AutoCompletion.enable(comboSearchItem);
                searchByComboBox();

                break;
            }
            case "price":
            case "month bought":
            case "year bought":
            case "month and year bought":
            case "first published": {
                comboCrit.setEnabled(true);

                tfKeyword.setEditable(true);
                tfKeyword.setBackground(Color.white);

                comboSearchItem.setEnabled(false);
                break;
            }
            case "id":
            case "title": {
                tfKeyword.setEditable(true);
                tfKeyword.setBackground(Color.white);

                comboSearchItem.setEnabled(false);
                comboCrit.setEnabled(false);

                break;
            }
            default: {
                System.out.println("GUIs.SearchPanel.comboSearchByItemStateChanged() - Something went wrong.");
                break;
            }
        }

    }//GEN-LAST:event_comboSearchByItemStateChanged

    /**
     * Change options in comboBoxdepending on whether fiction or non fiction is
     * selected
     *
     * @param evt
     */
    private void radFictionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radFictionItemStateChanged
        String[] ar;

        if (radFiction.isSelected()) {
            //fiction
            String[] temp = {"ID", "Title", "Price", "Place bought", "Month bought", "Year bought",
                "Month and year bought", "First published",
                "Series", "Type Of Book", "Genre"};
            ar = temp;

        } else if (radNonFiction.isSelected()) {
            //nonFiction
            String[] temp = {"ID", "Title", "Price", "Place bought", "Month bought", "Year bought",
                "Month and year bought", "First published",
                "Dewey number"};
            ar = temp;

        } else {
            //allBooks or dum selected
            String[] temp = {"ID", "Title", "Price", "Place bought", "Month bought", "Year bought",
                "Month and year bought", "First published"};
            ar = temp;
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel(ar);

        comboSearchBy.setModel(model);

        tfKeyword.setEditable(true);
        tfKeyword.setBackground(Color.white);
        comboSearchItem.setEnabled(false);
    }//GEN-LAST:event_radFictionItemStateChanged

    private void radNonFictionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radNonFictionItemStateChanged
        radFictionItemStateChanged(evt);
    }//GEN-LAST:event_radNonFictionItemStateChanged

    private void butSearchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_butSearchTextKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butSearchTextActionPerformed(null);
        }
    }//GEN-LAST:event_butSearchTextKeyReleased

    private void butDeweyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_butDeweyKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butDeweyActionPerformed(null);
        }
    }//GEN-LAST:event_butDeweyKeyReleased

    private void butViewAllKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_butViewAllKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butViewAllActionPerformed(null);
        }
    }//GEN-LAST:event_butViewAllKeyReleased

    private void butClearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_butClearKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butClearActionPerformed(null);
        }
    }//GEN-LAST:event_butClearKeyReleased

    //if search by shop, genre or type is selected,
    //set tfKeyword uneditable and set comboSGT enabled
    private void searchByComboBox() {
        tfKeyword.setEditable(false);
        tfKeyword.setBackground(new Color(214, 217, 223));

        comboSearchItem.setEnabled(true);
        comboCrit.setEnabled(false);

        comboCrit.setEnabled(false);
    }

    /**
     * Display the authors of the Book in the given row in a Popup JPanel
     */
    private void showAuthors(int row, JTable table) {
        //get ID of the Book in the row
        int id = Integer.parseInt(table.getValueAt(row, 0).toString());

        //get list of authors and roles
        List<String> authors = driver.getAuthors(id);

        //create pop up panel
        JPanel popUpContent = new JPanel(); //panel with content of PopUP

        GridLayout layout = new GridLayout(authors.size(), 1);
        popUpContent.setLayout(layout);

        Border border = new BasicBorders.MenuBarBorder(Color.BLACK, Color.WHITE);

        popUpContent.setBorder(border);

        //add authors to panel
        for (String a : authors) {
            JLabel lab = new JLabel(a);

            popUpContent.add(lab);
        }

        //get mouse co-ords
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        int xCoord = mousePoint.x;
        int yCoord = mousePoint.y;

        PopupFactory factory = PopupFactory.getSharedInstance();
        popup = factory.getPopup(this, popUpContent, xCoord, yCoord);
        popup.show();
    }

    /**
     * Display the contents of the given ResultSet in a JTable
     *
     * @param rs ResultSet to display
     */
    private void displayTable(ResultSet rs) {
        //perform query, use resultSet to create table
        DefaultTableModel model = driver.buildTableModel(rs);

        //add column for author
        int numRows = model.getRowCount();

        List<String> clickAuthor = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            clickAuthor.add("click for Authors");
        }

        model.addColumn("Author", clickAuthor.toArray());

        //set table model
        final JTable myTable = new JTable(model);
        myTable.setEnabled(false);

        //Listen for wheel scroll
        myTable.addMouseWheelListener((MouseWheelEvent mwe) -> {
            //hide popup if not null
            if (popup != null) {
                popup.hide();
            }

            //dispatch event to parent to retain default scrolling behaviour
            myTable.getParent().dispatchEvent(mwe);
        });

//        Add mouseListener to Table to listner for click
        myTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //hide popup that might be visible
                if (popup != null) {
                    popup.hide();
                }

                //get row and column of cell clicked
                int row = myTable.rowAtPoint(evt.getPoint());
                int col = myTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println(row + ", " + col);

                    //if column clicked is author, display authors
                    String colName = myTable.getColumnName(col);
                    if (colName.equals("Author")) {

                        showAuthors(row, myTable);
                    }

                }
            }
        });

        //add table to scrollPane
        searchPane.setViewportView(myTable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butClear;
    private javax.swing.JButton butDewey;
    private javax.swing.JButton butSearchText;
    private javax.swing.JButton butViewAll;
    private javax.swing.JComboBox comboCrit;
    private javax.swing.JComboBox comboSearchBy;
    private javax.swing.JComboBox comboSearchItem;
    private javax.swing.ButtonGroup groupSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lKeyword;
    private javax.swing.JLabel lSearchBy;
    private javax.swing.JRadioButton radAllBooks;
    private javax.swing.JRadioButton radDum;
    private javax.swing.JRadioButton radFiction;
    private javax.swing.JRadioButton radNonFiction;
    private javax.swing.JScrollPane searchPane;
    private javax.swing.JTextField tfKeyword;
    // End of variables declaration//GEN-END:variables
    private Driver driver = null;
    Popup popup = null;
}
