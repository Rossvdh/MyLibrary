/*
 Panel for shops (update, add, delete, search)
 to be added to tabbedPane on MainGUI
 Ross van der Heyde 
 Started: 12 December 2014
 */
package library;

import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Ross
 */
public class ShopPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShopPanel
     */
    public ShopPanel(Driver d) {
        initComponents();
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

        shopSep1 = new javax.swing.JSeparator();
        lUpdateShop = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfShopUpdate = new javax.swing.JTextField();
        butUpdate = new javax.swing.JButton();
        lShopDelete = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfShopDelete = new javax.swing.JTextField();
        butShopDelete = new javax.swing.JButton();
        shopMessPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shopMessages = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        lSearch = new javax.swing.JLabel();
        lSearchBy = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox();
        lCriteria = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        butSearch = new javax.swing.JButton();
        lUpdateThis = new javax.swing.JLabel();
        comboUpdate = new javax.swing.JComboBox();
        scrollPane = new javax.swing.JScrollPane();
        shopTable = new javax.swing.JTable();
        butClear = new javax.swing.JButton();
        tfNewValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        butViewAll = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(1037, 604));

        lUpdateShop.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lUpdateShop.setText("<html><b><u>Update shop</u></b>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Shop ID:");

        butUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        butUpdate.setText("Update");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        lShopDelete.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lShopDelete.setText("<html><b><u>Delete a shop</u></b>");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Shop ID:");

        butShopDelete.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        butShopDelete.setText("Delete");
        butShopDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butShopDeleteActionPerformed(evt);
            }
        });

        shopMessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Messages", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));

        jScrollPane1.setViewportView(shopMessages);

        javax.swing.GroupLayout shopMessPanelLayout = new javax.swing.GroupLayout(shopMessPanel);
        shopMessPanel.setLayout(shopMessPanelLayout);
        shopMessPanelLayout.setHorizontalGroup(
            shopMessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopMessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );
        shopMessPanelLayout.setVerticalGroup(
            shopMessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopMessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        lSearch.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lSearch.setText("<html><b><u>Search shops</u></b>");

        lSearchBy.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lSearchBy.setText("Search by:");

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Area" }));

        lCriteria.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lCriteria.setText("Criteria:");

        butSearch.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        butSearch.setText("Search");
        butSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchActionPerformed(evt);
            }
        });

        lUpdateThis.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lUpdateThis.setText("Update:");

        comboUpdate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ShopName", "Area", "Email", "Phone" }));

        shopTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(shopTable);

        butClear.setText("Clear all");
        butClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 13)); // NOI18N
        jLabel1.setText("New value:");

        butViewAll.setText("View all shops");
        butViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfShopDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addGap(455, 455, 455)
                                .addComponent(butShopDelete)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lUpdateThis)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNewValue)
                                    .addComponent(comboUpdate, 0, 117, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                                        .addComponent(butUpdate)
                                        .addGap(45, 45, 45))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfShopUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(shopSep1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lCriteria)
                                            .addComponent(lSearchBy))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfSearch)
                                            .addComponent(comboSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(322, 322, 322)
                                        .addComponent(butSearch))
                                    .addComponent(lSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lUpdateShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lShopDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0)
                        .addComponent(shopMessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butViewAll)
                        .addGap(29, 29, 29)
                        .addComponent(butClear)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(shopMessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lShopDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfShopDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butShopDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shopSep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lUpdateShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lUpdateThis)
                            .addComponent(comboUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfShopUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butUpdate)
                            .addComponent(tfNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lSearchBy)
                            .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lCriteria)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butSearch))))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butClear)
                    .addComponent(butViewAll))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    //sproc DONE
    private void butShopDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butShopDeleteActionPerformed
        try {
            //delete a shop from the dataBase
            Shop shop = new Shop(Integer.parseInt(tfShopDelete.getText()));

            //delete shop from database
            if (shop.deleteFromDatabase()) {
                driver.appendToPane(shopMessages, "Shop successfully deleted\n", Color.green);
            } else {
                driver.appendToPane(shopMessages, "Shop was not deleted.\n", Color.red);
            }

        } catch (NumberFormatException nfe) {
            driver.appendToPane(shopMessages, "Please enter only numbers into the shop ID field.\n", Color.orange);
        }
    }//GEN-LAST:event_butShopDeleteActionPerformed

    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        String[] searchTerms = {"ID", "Name", "Area"};

        String q = "{CALL searchShop" + searchTerms[comboSearch.getSelectedIndex()] + "(?)}";

        CallableStatement cstmt = driver.getCallStatement(q);
        ResultSet rs = null;

        try {
            cstmt.setString(1, tfSearch.getText());

            rs = cstmt.executeQuery();
        } catch (SQLException se) {
            driver.errorMessageNormal("From ShopPanel.butSearchAP: " + se);
            se.printStackTrace();
        }

        JTable myTable = new JTable(driver.buildTableModel(rs));

        scrollPane.setViewportView(myTable);
    }//GEN-LAST:event_butSearchActionPerformed

    //update a shop
    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        //Create new shop using ID
        Shop shop = new Shop(Integer.parseInt(tfShopUpdate.getText()));

        //search for shop
        if (shop.updateInDatabase(comboUpdate.getSelectedItem().toString(), tfNewValue.getText())) {
            //inform user of success
            driver.appendToPane(shopMessages, "Shop updated successfully.\n", Color.green);
        } else {
            //inform of failure
            driver.appendToPane(shopMessages, "Shop could not be updated.\n", Color.red);
        }
    }//GEN-LAST:event_butUpdateActionPerformed

    //clear text from all textFileds and text Panes
    private void butClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butClearActionPerformed
        shopMessages.setText("");
        tfSearch.setText("");
        tfShopDelete.setText("");
        tfShopUpdate.setText("");
        tfNewValue.setText("");

        comboSearch.setSelectedIndex(0);
        comboUpdate.setSelectedIndex(0);

        scrollPane.setViewportView(null);
    }//GEN-LAST:event_butClearActionPerformed

    /**
     * View all the shops in the database
     *
     * @param evt
     */
    private void butViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butViewAllActionPerformed
        CallableStatement cstmt = driver.getCallStatement("{CALL viewAllShops()}");

        ResultSet rs = null;

        try {
            rs = cstmt.executeQuery();
        } catch (SQLException se) {
            driver.errorMessageNormal("From ShopPanel.butViewAllAP: " + se);
            se.printStackTrace();
        }

        JTable myTable = new JTable(driver.buildTableModel(rs));

        scrollPane.setViewportView(myTable);
    }//GEN-LAST:event_butViewAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butClear;
    private javax.swing.JButton butSearch;
    private javax.swing.JButton butShopDelete;
    private javax.swing.JButton butUpdate;
    private javax.swing.JButton butViewAll;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JComboBox comboUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lCriteria;
    private javax.swing.JLabel lSearch;
    private javax.swing.JLabel lSearchBy;
    private javax.swing.JLabel lShopDelete;
    private javax.swing.JLabel lUpdateShop;
    private javax.swing.JLabel lUpdateThis;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel shopMessPanel;
    private javax.swing.JTextPane shopMessages;
    private javax.swing.JSeparator shopSep1;
    private javax.swing.JTable shopTable;
    private javax.swing.JTextField tfNewValue;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfShopDelete;
    private javax.swing.JTextField tfShopUpdate;
    // End of variables declaration//GEN-END:variables
    private Driver driver = null;
}
