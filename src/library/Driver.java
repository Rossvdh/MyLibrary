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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * This class contains various methods for getting data from the database
 * and other miscilaeneous stuff.
 *
 * @author Ross
 */
public class Driver {
    private static Logger logger = Logger.getLogger(Borrower.class.getName());

    /**
     * Displays a critical error in a pop message.
     *
     * @param errorMessage text to display
     */
    public void errorMessageCritical(String errorMessage) {
        Object[] options = {"OK"};
        logger.severe(errorMessage);
        int s = JOptionPane.showOptionDialog(null, errorMessage, "CRITICAL ERROR!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    /**
     * Displays an error message in a pop up window
     *
     * @param errorMessage text to display
     */
    public void errorMessageNormal(String errorMessage) {
        Object[] options = {"OK"};
        logger.warning(errorMessage);
        int s = JOptionPane.showOptionDialog(null, errorMessage, "ERROR!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    /**
     * Displays a pop up window with a message
     *
     * @param message text to display
     */
    public void infoMessageNormal(String message) {
        Object[] options = {"OK"};
        logger.info(message);
        int s = JOptionPane.showOptionDialog(null, message, "INFORMATION MESSAGE",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

    /**
     * Connect to database, and creates a <code>PreparedStatement</code>
     *
     * @param query the SQl query or stored procedure call
     * @return PreparedStatement
     */
    public PreparedStatement getPrepStatement(String query) {
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            logger.info("Connecting to database...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "ross", "scientiaSITpotentia");

            //STEP 3: create statement
            logger.info("Creating statement...");
            stmt = conn.prepareStatement(query);
            stmt.closeOnCompletion();//closes stmt when all ResultSets are closed
            return stmt;
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }

    /**
     * Returns a <code>CallableStatement</code> with ? that need to be filled
     *
     * @param query the "call string" e.g. "{CALL paramTest(?)}"
     * @return A CallableStatement
     */
    public CallableStatement getCallStatement(String query) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            logger.info("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "Ross", "scientiaSITpotentia");

            //Create callableStatement
            logger.info("Creating statement...");
            stmt = conn.prepareCall(query);
            stmt.closeOnCompletion();

            return stmt;
        } catch (Exception ce) {
            logger.log(Level.WARNING, ce.toString(), ce);
            ce.printStackTrace();
        }
        return null;
    }

    /**
     * Loads the data from the database needed for the given comboBox type,
     * creates the  <code>DefaultComboBoxModel</code> and then returns it.
     *
     * @param type enaum specifying the type
     * @return comboBoxModel containing required data
     */
    public DefaultComboBoxModel getComboBoxModel(ComboBoxType type) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try {
            String query = "";

            //create query depending on parameter
            switch (type) {
                case SHOP: {
                    query = "{CALL getShops()}";
                    break;
                }
                case GENRE: {
                    query = "{CALL getGenres()}";
                    break;
                }
                case TYPE: {
                    query = "{CALL getTypes()}";
                    break;
                }
                case DEWEY_LEVEL_1: {
                    query = "{CALL getAllTopicOne()}";
                    break;
                }
                case ROLE: {
                    query = "{CALL getRoles()}";
                    break;
                }
                case SERIES: {
                    query = "{CALL getSeries()}";
                    break;
                }
                case AUTHOR: {
                    query = "{CALL getAllAuthors()}";
                    break;
                }
                default: {
                    errorMessageNormal("Invalid getComboBoxModel parameter");
                }
            }

            PreparedStatement stmt = getCallStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            //place names from RS into model
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }

            rs.close();
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
        return model;
    }

    /**
     * Receives a query, executes it and returns the <code>ResultSet</code>
     *
     * @param q String containing query to be executed
     * @return ResultSet
     */
    public ResultSet query(String q) {
        ResultSet rs = null;
        try {
            Statement stmt = getCallStatement(q);
            logger.info("query: " + q);

            rs = stmt.executeQuery(q);
        } catch (SQLException e) {
            logger.warning("From driver.query: " + e);
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
        int numberAffected = 0;
        try {
            Statement stmt = getCallStatement(q);
            logger.info("Query: " + q);

            numberAffected = stmt.executeUpdate(q);

            stmt.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString(), e);
        }

        return numberAffected >= 1;
    }

    /**
     * Place contents of the given <code>resultSet</code> into a <code>DefaultTableModel</code>
     *
     * @param rs <code>ResultSet</code> from which to build the model.
     * @return defaultTableModel containing contents of rs
     */
    public DefaultTableModel buildTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                columnNames.add(metaData.getColumnName(columnIndex));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            rs.close();
            return new DefaultTableModel(data, columnNames);
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
        return null;
    }

    /**
     * Appends a line of text with the given colour to the textPane
     * Move to GUIUtils class?
     *
     * @param tp  TextPane which must be appended to.
     * @param msg Text to display.
     * @param c   Colour of text.
     */
    public void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        attributeSet = sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Lucida Console");
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(attributeSet, false);
        tp.replaceSelection(msg);
    }

    /**
     * Returns a comboBox model for the level 2 Dewey comboBox
     *
     * @param dew1        Dewey number level 1 selected (000, 100, 200 ...)
     * @param level1Topic Selected level 1 topic, to be first element in dewey2
     *                    comboBox
     * @return DefaultComboBoxModel containing tens (010, 020, 030....)
     */
    public DefaultComboBoxModel<String> getDewey2Model(int dew1, String level1Topic) {
        //declare comboBoxModel for comboDew2s
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        try {
            model.addElement(level1Topic);//add 000 level topic to model

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
            logger.warning("From driver.getDewey2Model: " + se);
        }

        return model;
    }

    /**
     * Returns comboBoxModel for Dewey level 3 comboBox model, given level 2
     * selected
     *
     * @param dew2        Dewey number level 2 selected
     * @param level2Topic Selected level 2 topic, to be first element in dewey3
     *                    comboBox
     * @return DefaultComboBoxModel containing units (001, 002, 003..)
     */
    public DefaultComboBoxModel getDewey3Model(int dew2, Object level2Topic) {

        //declare comboBoxModel for comboDew2
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(level2Topic);//add 000 level topic to model

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
     * @return boolean
     */
    public boolean dateFormatValid(String date) {

        String isoDate = date.replace('/', '-');
        try {
            LocalDate testDate = LocalDate.parse(isoDate);
            return true;
        } catch (DateTimeParseException dtpe) {
            logger.info("Could not parse date '" + date + "'");
        }
        return false;
    }

    /**
     * Returns a <code>List</code> of author names and roles for the given book ID
     *
     * @param bookID ID of the Book whose authors to get
     * @return list of author names and roles e.g. "Author Name (role)"
     */
    public List<String> getAuthors(int bookID) {
        ArrayList<String> authors = new ArrayList<>();

        try {
            CallableStatement cstmt = getCallStatement("{CALL getBookAuthors(?)}");

            cstmt.setInt(1, bookID);

            try (ResultSet rs = cstmt.executeQuery()) {
                //id, title, author, role

                //add authors and roles to arrayList
                while (rs.next()) {
                    String entry = rs.getString("name") + " (" + rs.getString("role") + ")";

                    authors.add(entry);
                }
            }

        } catch (Exception e) {
            errorMessageNormal("From driver.getAuthors: " + e);
        }

        return authors;
    }
}
