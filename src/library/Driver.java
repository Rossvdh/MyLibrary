/*
 * Library version 3
 Driver class: validation methods, queries

 Ross van der Heyde 
 Started: 10 October 2014
 this started: 28 November 2014
 */
package library;

import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Ross
 */
public class Driver {

    //<editor-fold defaultstate="collapsed" desc="error/info Message methods">
// Critical error message (Pop-up window) - program must close
    public void errorMessageCritical(String boodskap) {
        Object[] options = {"OK"};
        int s = JOptionPane.showOptionDialog(null, boodskap, "C R I T I C A L   E R R O R ! ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
        //System.exit(0);
    }

    // Normal error message (Pop-up window)
    public void errorMessageNormal(String boodskap) {
        Object[] options = {"OK"};
        int s = JOptionPane.showOptionDialog(null, boodskap, " E R R O R  ! ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    // Normal information message (Pop-up window)
    public void infoMessageNormal(String boodskap) {
        Object[] options = {"OK"};
        int s = JOptionPane.showOptionDialog(null, boodskap, " I N F O R M A T I O N   M E S S A G E ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

//</editor-fold>
    /**
     * Connect to database, create Statement
     *
     * @return Statement with database connection
     */
    //<editor-fold defaultstate="collapsed" desc="comment">
    public PreparedStatement getPrepStatement(String query) {
        PreparedStatement stmt = null;

        //using mysql
        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            //give dataBase url, username and password;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "ross", "scientiaSITpotentia");

            //STEP 3: create statement
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(query);
            stmt.closeOnCompletion();//closes stmt when all ResultSets are closed

        } catch (ClassNotFoundException ce) {
            errorMessageCritical("From driver.getStatement ce: " + ce);
        } catch (SQLException se) {
            errorMessageCritical("From driver.getStatement se: " + se);
        }

        return stmt;
    }
//</editor-fold>

    /**
     * Returns a CallableStatement with ? that need to be filled
     *
     * @param query the "call string" e.g. "{CALL paramTest(?)}"
     * @return A CAllableStatement
     */
    public CallableStatement getCallStatement(String query) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "Ross", "scientiaSITpotentia");

            //Create callableStatement
            System.out.println("Creating statement...");
            stmt = conn.prepareCall(query);

            stmt.closeOnCompletion();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return stmt;
    }

    /**
     * Returns comboBoxModel of given comboBox. The codes are as follows:
     * <table>
     * <caption>Codes for comboBox models</caption>
     * <tr>
     * <th>code</th>
     * <th>comboBox</th>
     * </tr>
     * <tr>
     * <td>0</td>
     * <td>shop</td>
     * </tr>
     * <tr>
     * <td>1</td>
     * <td>genre</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>type</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td>dewey level 1</td>
     * </tr>
     * <tr>
     * <td>4</td>
     * <td>roles</td>
     * </tr>
     * <tr>
     * <td>5</td>
     * <td>series</td>
     * </tr>
     * <tr>
     * <td>6</td>
     * <td>authors</td>
     * </tr>
     * </table>
     *
     * @param x int indicating which model to get
     * @return comboBoxModel containing required names
     */
    public DefaultComboBoxModel getComboBoxModel(int x) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        try {
            String query = "";

            //create query depending on parameter
            switch (x) {
                case 0: {//place
                    query = "{CALL getShops()}";
                    break;
                }
                case 1: {//genre
                    query = "{CALL getGenres()}";
                    break;
                }
                case 2: {//type
                    query = "{CALL getTypes()}";
                    break;
                }
                case 3: {//dewey level 1
                    query = "{CALL getAllTopicOne()}";
                    break;
                }
                case 4: {//Roles
                    query = "{CALL getRoles()}";
                    break;
                }
                case 5: {
                    //series
                    query = "{CALL getSeries()}";
                    break;
                }
                case 6: {
                    //authors
                    query = "{CALL getAllAuthors()}";
                    break;
                }
                default: {
                    errorMessageNormal("Invalid getComboBoxModel parameter");
                }
            }

            //create statement
            PreparedStatement stmt = getCallStatement(query);

            //execute query
            ResultSet rs = stmt.executeQuery(query);

            //place names from RS into model
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }

            rs.close();//close statement

        } catch (SQLException se) {
            errorMessageNormal("From driver.getCombBoxModel: " + se);
        }
        return model;
    }

    /**
     * Receives a query executes it and return ResultSet
     *
     * @param q String containing query to be executed
     * @return ResultSet
     */
    public ResultSet query(String q) {
        ResultSet rs = null;
        try {
            Statement stmt = getCallStatement(q);
            System.out.println("query: " + q);

            rs = stmt.executeQuery(q);

        } catch (SQLException e) {
            errorMessageCritical("From driver.query: " + e);
        }
        return rs;
    }

    /**
     * Receives query (DELETE, INSERT, or UPDATE), executes, and returns boolean
     *
     * @param q DELETE, INSERT, or UPDATE query
     * @return boolean indicating success
     */
    public boolean modifyQuery(String q) {
        int num = 0;
        try {
            Statement stmt = getCallStatement(q);
            System.out.println("Query: " + q);

            num = stmt.executeUpdate(q);

            stmt.close();

        } catch (SQLException e) {
            errorMessageCritical("From driver.modifyQuery: " + e);
        }

        return num == 1;
    }

    /**
     * Get genre's ID given genre name
     *
     * @param g String with genre name
     * @return int with genre's ID
     */
    /* public int getGenreID(String g) {
    }*/
    /**
     * Get Shop's ID based on name
     *
     * @param n String with shop name
     * @return int with shop's ID
     */
    /*public int getShopID(String n) {
    
    }*/
    /**
     * Get TypeOfBook ID, given type
     *
     * @param t String containing type of book
     * @return int with type ID
     */
    /*public int getTypeID(String t) {
    
    }*/
    /**
     * Place contents of resultSet into DefaultTableModel
     *
     * @param rs <code>ResultSet</code> from which to build the model.
     * @return defaultTableModel containing contents of rs
     */
    public DefaultTableModel buildTableModel(ResultSet rs) {

        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            rs.close();
            return new DefaultTableModel(data, columnNames);
        } catch (SQLException se) {
            System.out.println(se);
        }
        return new DefaultTableModel();
    }

    /**
     * Appends a line of text with the given colour to the textPane
     *
     * @param tp TextPane which must be appended to.
     * @param msg Text to display.
     * @param c Colour of text.
     */
    public void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

    /**
     * Returns a comboBox model for the level 2 Dewey comboBox
     *
     * @param dew1 Dewey number level 1 selected (000, 100, 200 ...)
     * @param first Selected level 1 topic, to be first element in dewey2
     * comboBox
     * @return DefaultComboBoxMOdel containing tens (010, 020, 030....)
     */
    public DefaultComboBoxModel<String> getDewey2Model(int dew1, String first) {
        //declare comboBoxModel for comboDew2s
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try {
            model.addElement(first);//add 000 level topic to model

            //query for level2 topics
            CallableStatement stmt = getCallStatement("{CALL getDeweyTwoRange(?,?)}");

            stmt.setInt(1, dew1);
            stmt.setInt(2, dew1 + 99);

            ResultSet rs = stmt.executeQuery();

            //add level 2 topics to model
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
            rs.close();

        } catch (SQLException se) {
            errorMessageNormal("From driver.getDewey2Model: " + se);
        }

        return model;
    }

    /**
     * Returns comboBoxModel for Dewey level 3 comboBox model, given level 2
     * selected
     *
     * @param dew2 Dewey number level 2 selected
     * @param first Selected level 2 topic, to be first element in dewey3
     * comboBox
     * @return DefaultComboBoxModel containing units (001, 002, 003..)
     */
    public DefaultComboBoxModel getDewey3Model(int dew2, Object first) {

        //declare comboBoxModel for comboDew2
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(first);//add 000 level topic to model

        try {
            //query for level3 topics
            CallableStatement stmt = getCallStatement("{CALL getDeweyThreeRange(?,?)}");

            stmt.setInt(1, dew2);
            stmt.setInt(2, dew2 + 9);

            ResultSet rs = stmt.executeQuery();

            //add level 3 topics to model, 
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
            rs.close();
        } catch (SQLException se) {
            errorMessageNormal("From driver.getDewey3Model: " + se);
        }

        //set dew3's model
        return model;
    }

    /**
     * Checks that the date entered is in the correct format (DD/MM/YYYY)
     *
     * @param date String containing date
     *
     * @return boolean
     */
    public boolean dateFormatValid(String date) {
        boolean days = false;
        boolean month = false;
        boolean year = true;
        boolean slash = false;

        try {
            //perform parseInt to check numbers only
            int daysValue = Integer.parseInt(date.substring(0, 2));
            int monthValue = Integer.parseInt(date.substring(3, 5));
            int yearValue = Integer.parseInt(date.substring(6, 10));

            //checl correct month interval
            if (monthValue > 0 && monthValue < 13) {
                month = true;

                //check day depending on month
                switch (monthValue) {
                    case 2: {
                        //february

                        if (yearValue % 4 == 0) {
                            //leap year
                            days = daysValue > 0 && daysValue < 30;

                        } else {
                            //normal year
                            days = daysValue > 0 && daysValue < 29;
                        }

                        break;
                    }
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        //31 days

                        days = daysValue > 0 && daysValue < 32;

                        break;
                    }
                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        //30 days
                        days = daysValue > 0 && daysValue < 31;
                        break;
                    }
                }
            }

            //check for / in correct places
            slash = date.charAt(2) == '/' && date.charAt(5) == '/';

        } catch (NumberFormatException nfe) {
            return false;
        }

        return days && month && year && slash;
    }

    /**
     * Returns an ArrayList of author names and roles for the given book ID
     *
     * @param bookID ID of the Book whose authors to get
     * @return ArrayList of author names and roles e.g. "Author Name (role)"
     */
    public ArrayList<String> getAuthors(int bookID) {
        ArrayList<String> authors = new ArrayList();

        try {
            CallableStatement cstmt = getCallStatement("{CALL getBookAuthors(?)}");

            cstmt.setInt(1, bookID);

            ResultSet rs = cstmt.executeQuery();
            //id, title, author, role

            //add authors and roles to arrayList
            while (rs.next()) {
                String entry = rs.getString("name") + " (" + rs.getString("role") + ")";

                authors.add(entry);
            }

        } catch (Exception e) {
            errorMessageNormal("From driver.getAuthors: " + e);
        }

        return authors;
    }
}
