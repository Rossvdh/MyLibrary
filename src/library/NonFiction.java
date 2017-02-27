/*
 * NonFiction book inherits from Book
 * Ross van der Heyde
 * started: 30 November 2014
 */
package library;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ross
 */
public class NonFiction extends Book implements DatabaseEntry {

    //class variables
    private int dewey;

    /**
     * Default constructor. creates new <code>NonFiction</code> object
     *
     */
    public NonFiction() {    //default
        super();
    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given ID number
     *
     * @param i
     */
    public NonFiction(int i) {    //ID only
        super(i);
        //getAuthorFromDatabase();
        //getTitleFromDatabase();
    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given attributes.
     *
     * @param t title of <code>Book</code>
     * @param m month <code>Book</code> was bought
     * @param y year <code>Book</code> was bought
     * @param p priced paid for <code>Book</code> was bought
     * @param plc <code>Shop</code> where <code>Book</code> was bought
     * @param pub year <code>Book</code> was first published
     * @param a <code>ArrayList</code> of <code>Author</code>s of this
     * @param d Dewey number of this <code>NonFiction</code> book
     * <code>Book</code>
     */
    public NonFiction(String t, int m, int y, double p, Shop plc, int pub, ArrayList<Author> a, int d) {
        super(t, m, y, p, plc, pub, a);
        dewey = d;
    }

    /**
     * Copy constructor. Creates a new <code>NonFiction</code> object that is a
     * copy of the given <code>NonFiction</code>
     *
     * @param copy <code>NonFiction</code> to create a copy of
     */
    public NonFiction(NonFiction copy) {
        super(copy);
        this.dewey = copy.dewey;
    }

    /**
     * Create a <code>NonFiction</code> Object from the given <code>Book</code>.
     * This method was created because one can not simply cast a
     * <code>Book</code> to a <code>NonFiction</code> object.
     *
     * @param b <code>Book</code> to convert to a <code>NonFiction</code>
     */
    public NonFiction(Book b) {
        super(b);

    }

    /**
     * Adds this book to the database.
     *
     * @return boolean indicating successfulness of insertion
     */
    @Override
    public boolean addToDatabase() {
        /*
        add superclass
        (new ID is set in super)
        add this NF book
         */

        boolean success = super.addToDatabase();

        if (success) {
            try {
                //addNonFiction(idNum INT, dewey INT)
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL addNonFiction(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setInt(2, dewey);

                success = cstmt.executeUpdate() == 1;

                return success;

            } catch (SQLException se) {
                se.printStackTrace();
            }
        } else {
            System.out.println("library.NonFiction.addToDatabase() - super " + title + " could not be addded");
        }

        System.out.println("library.NonFiction.addToDatabase() - NonFiction " + title + " could not be added.");
        return false;

    }

    /**
     * Updates a specific value of this book in the database
     *
     * @param field String. value to be updated
     * @param newValue String containing new updated value
     *
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equalsIgnoreCase("deweyNumber")) {
            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateNonFictionDewey(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setInt(2, Integer.parseInt(newValue));

                boolean success = cstmt.executeUpdate() == 1;

                //update this object
                if (success) {
                    dewey = Integer.parseInt(newValue);
                    return true;
                } else {
                    System.out.println("library.NonFiction.updateInDatabase() " + id + "could not be added");
                }

            } catch (SQLException ex) {
                System.out.println("library.NonFiction.updateInDatabase() - " + ex);
                ex.printStackTrace();
            }

        } else {
            return super.updateInDatabase(field, newValue);
        }
        return false;
    }

    /**
     * Deletes this book from the database. sproc DONE
     *
     * @return success boolean indicating successful deletion
     */
    /*public boolean deleteFromDatabase() {
    //ask use to confirm deletion
    int c = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
    + authors + "?");
    
    if (c == 0) {
    //delete
    boolean del = super.deleteFromDatabase();
    
    if (del) {
    try {
    CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteNonFiction(?)}");
    
    cstmt.setInt(1, id);
    
    return cstmt.executeUpdate() == 1;
    } catch (SQLException se) {
    DRIVER.errorMessageNormal("From Fiction.deleteFromDatabase:" + se);
    se.printStackTrace();
    }
    
    return false;
    } else {
    DRIVER.errorMessageNormal("Book could not be deleted.");
    return false;
    }
    
    } else {
    //don't delete
    return false;
    }
    }*/
    /**
     * Get the dewey number of this <code>NonFiction</code>
     *
     * @return dewey number
     */
    public int getDeweyNumber() {
        return dewey;
    }

    /**
     * Sets the dewey number of this <code>NonFiction</code>
     *
     * @param d dewey number
     */
    public void setDeweyNumber(int d) {
        dewey = d;
    }
}
