/*
 * NonFiction book inherits from Book
 * Ross van der Heyde
 * started: 30 November 2014
 */
package library;

import util.PopUpMessages;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a non-fiction book.
 *
 * @author Ross
 */
public class NonFiction extends Book implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Fiction.class.getName());

    private int dewey;

    /**
     * Default constructor. creates new <code>NonFiction</code> object
     */
    public NonFiction() {
        super();
    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given ID number. Also initializes title and author.
     *
     * @param i ID number of this <code>Fiction</code> book.
     */
    public NonFiction(int i) {
        super(i);
    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given attributes.
     *
     * @param title         title of <code>Book</code>
     * @param monthBought   month <code>Book</code> was bought
     * @param yearBought    year <code>Book</code> was bought
     * @param price         priced paid for <code>Book</code> was bought
     * @param shop          <code>Shop</code> where <code>Book</code> was bought
     * @param yearPublished year <code>Book</code> was first published
     * @param authors       <code>ArrayList</code> of <code>Author</code>s of this
     * @param deweyNumber   Dewey number of this <code>NonFiction</code> book
     *                      <code>Book</code>
     */
    public NonFiction(String title, int monthBought, int yearBought, double price,
                      Shop shop, int yearPublished, List<Author> authors, int deweyNumber) {
        super(title, monthBought, yearBought, price, shop, yearPublished, authors);
        dewey = deweyNumber;
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
     * @return boolean indicating success of insertion
     */
    @Override
    public boolean addToDatabase() {
        boolean success = super.addToDatabase();

        if (success) {
            try {
                //addNonFiction(idNum INT, dewey INT)
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL addNonFiction(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setInt(2, dewey);

                success = cstmt.executeUpdate() == 1;
                cstmt.close();
                return success;

            } catch (SQLException se) {
                logger.log(Level.WARNING, se.toString(), se);
            }
        } else {
            logger.warning("library.NonFiction.addToDatabase() - super " + title + " could not be added" +
                    "due to error in super.addToDatabase");
            PopUpMessages.errorMessageNormal("library.NonFiction.addToDatabase() - super " + title + " could not be added\n" +
                    "due to error in super.addToDatabase");
        }

        logger.warning("library.NonFiction.addToDatabase() - super " + title + " could not be added");
        return false;

    }

    /**
     * Updates a specific value of this <code>NonFiction</code>in the database.
     * The only field that can be updated is the dewey number
     * <p>
     * //TODO refactor to take ComboBoxType enum instead of string field?
     *
     * @param field    String. value to be updated
     * @param newValue String containing new updated value
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
                cstmt.close();

                if (success) {
                    dewey = Integer.parseInt(newValue);
                    return true;
                } else {
                    logger.warning("library.NonFiction.updateInDatabase() " + id + "could not be added");
                }

            } catch (SQLException ex) {
                logger.log(Level.WARNING, "Could not update fiction book", ex);
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
    public boolean deleteFromDatabase() {
        int confirmDelete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
                + authors + "?");

        if (confirmDelete == JOptionPane.YES_OPTION) {
            //delete
            boolean superDeleted = super.deleteFromDatabase();

            if (superDeleted) {
                try {
                    CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteNonFiction(?)}");

                    cstmt.setInt(1, id);

                    int numberDeleted = cstmt.executeUpdate();
                    cstmt.close();

                    return numberDeleted == 1;
                } catch (SQLException se) {
                    logger.log(Level.WARNING, se.toString(), se);
                    PopUpMessages.errorMessageNormal("From Fiction.deleteFromDatabase:" + se);
                }

                return false;
            } else {
                logger.warning("NonFiction '" + title + "' could not be deleted due to error in super.deleteFromDatabase");
                PopUpMessages.errorMessageNormal("Book was not be deleted.");
                return false;
            }
        } else {
            logger.fine("User decided not to delete");
            return false;
        }
    }

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
     * @param deweyNumber dewey number
     */
    public void setDeweyNumber(int deweyNumber) {
        dewey = deweyNumber;
    }
}
