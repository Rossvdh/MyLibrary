/*
 * Fiction book inherits from Book
 * Ross van der Heyde
 * started: 30 November 2014
 */
package library;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a fiction book that can be added to the Fiction table
 * in the database. It inherits from <code>Book</code>
 *
 * @author Ross
 */
public class Fiction extends Book {
    private static Logger logger = Logger.getLogger(Fiction.class.getName());

    private Genre genre;
    private TypeOfBook type;
    private Series series;
    private int number;

    /**
     * Default constructor. Creates a new <code>Fiction</code> object
     */
    public Fiction() {
        super();
    }

    /**
     * Parameterized constructor. Creates a new <code>Fiction</code> object with
     * the given ID number. Also initializes title and author.
     *
     * @param i ID number of this <code>Fiction</code> book.
     */
    public Fiction(int i) {
        super(i);
    }

    /**
     * Create a <code>Fiction</code> Object from the given <code>Book</code>.
     * This method was created because one can not simply cast a
     * <code>Book</code> to a <code>Fiction</code> object.
     *
     * @param b <code>Book</code> to convert to a <code>Fiction</code>
     */
    public Fiction(Book b) {
        super(b);
    }

    /**
     * Parameterized constructor. Creates a new <code>Fiction</code> object with
     * the given attributes.
     *
     * @param t   title of <code>Fiction</code>
     * @param m   month <code>Fiction</code> was bought
     * @param y   year <code>Fiction</code> was bought
     * @param p   priced paid for <code>Fiction</code> was bought
     * @param plc <code>Shop</code> where <code>Fiction</code> was bought
     * @param pub year <code>Fiction</code> was first published
     * @param a   <code>List</code> of <code>Author</code>s of this
     *            <code>Fiction</code>
     * @param g   genre of this <code>Fiction</code>
     * @param n   number in <code>Series</code>
     * @param s   <code>Series</code> that this book is part of
     * @param ty  TypeOfBook of book
     */
    public Fiction(String t, int m, int y, double p, Shop plc, int pub, List<Author> a,
                   Genre g, TypeOfBook ty, Series s, int n) {
        super(t, m, y, p, plc, pub, a);
        genre = new Genre(g);
        type = new TypeOfBook(ty);
        series = new Series(s);
        number = n;
    }

    /**
     * Copy constructor. Creates a new Fiction object equal to the one given as
     * parameter
     *
     * @param copy <code>Fiction</code> to create a copy of.
     */
    public Fiction(Fiction copy) {
        super(copy);
        this.genre = copy.genre;
        this.type = copy.type;
        this.series = copy.series;
        this.number = copy.number;
    }

    /**
     * Adds this book to the database. First it calls the addToDatabase of the superclass, and if
     * that call is successful, it will attempt to add this Fiction.
     *
     * @return true if successfully inserted, false otherwise
     */
    @Override
    public boolean addToDatabase() {
        boolean bookAdded = super.addToDatabase();

        if (bookAdded) {
            try {
                //addFiction(idNum INT, ser INT, num INT, type INT, gen INT)
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL addFiction(?,?,?,?,?)}");

                cstmt.setInt(1, id);
                cstmt.setInt(2, series.getId());
                cstmt.setInt(3, number);
                cstmt.setInt(4, type.getID());
                cstmt.setInt(5, genre.getId());

                return cstmt.executeUpdate() == 1;
            } catch (SQLException se) {
                logger.log(Level.WARNING, se.toString(), se);
            }
        } else {
            logger.warning("library.Fiction.addToDatabase() - super " + title + " class could not be added");
        }

        logger.warning("library.Fiction.addToDatabase() - Fiction " + title + " could not be added");
        return false;
    }

    /**
     * Updates a specific value of this book in the database. Make a sproc for
     * this
     * <p>
     * //TODO refactor to take ComboBoxType enum instead of string field?
     *
     * @param field    String. field to be updated
     * @param newValue String containing new updated value
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        field = field.toLowerCase();

        String query = "";

        switch (field) {
            case "series": {
                query = "{CALL updateFictionSeries(?,?)}";
                break;
            }
            case "genre": {
                query = "{CALL updateFictionGenre(?,?)}";
                break;
            }
            case "type of book": {
                query = "{CALL updateFictionType(?,?)}";
                break;
            }
            case "noinseries": {
                query = "{CALL updateFictionNoInSeries(?,?)}";
                break;
            }
            default: {
                logger.warning("library.Fiction.updateInDatabase() - invalid field");
                DRIVER.errorMessageNormal("Please select a valid Fiction field.");
                return false;
            }
        }

        try {
            CallableStatement cstmt = DRIVER.getCallStatement(query);
            cstmt.setInt(1, id);
            cstmt.setInt(2, Integer.parseInt(newValue));

            return cstmt.executeUpdate() == 1;
        } catch (SQLException sQLException) {
            logger.log(Level.WARNING, sQLException.toString(), sQLException);
        } catch (NumberFormatException nfe) {
            DRIVER.errorMessageNormal("Please enter a digits only");
            logger.log(Level.WARNING, nfe.toString(), nfe);
        }

        return false;
    }

    /**
     * Deletes this book from the database. sproc DONE
     *
     * @return success boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        //ask use to confirm deletion
        int confirmDeletion = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
                + authors + "?");

        if (confirmDeletion == JOptionPane.YES_OPTION) {
            boolean superDeleted = super.deleteFromDatabase();

            if (superDeleted) {
                try {
                    CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteFiction(?)}");

                    cstmt.setInt(1, id);

                    return cstmt.executeUpdate() == 1;
                } catch (SQLException se) {
                    logger.log(Level.WARNING, se.toString(), se);
                    DRIVER.errorMessageNormal("From Fiction.deleteFromDatabase:" + se);
                }

                return true;
            } else {
                logger.warning("Fiction was not deleted due to error in super.deleteFromDatabase");
                DRIVER.errorMessageNormal("Fiction could not be deleted.");
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Returns a <code>String</code> representation of this <code>Fiction</code>
     * book.
     *
     * @return string representation
     */
    public String toString() {
        return super.toString() + " (fiction)";
    }

    //<editor-fold defaultstate="collapsed" desc="gets and sets">

    /**
     * Returns the <code>Genre</code> of this <code>Fiction</code>
     *
     * @return <code>Genre</code> of this <code>Fiction</code>
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Returns the <code>TypeOfBook</code> of this <code>Fiction</code>.
     *
     * @return <code>TypeOfBook</code> of this <code>Fiction</code>
     */
    public TypeOfBook getType() {
        return type;
    }

    /**
     * Return the <code>Series</code> that this <code>Fiction</code> book is
     * part of.
     *
     * @return this book's <code>Series</code>
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Returns the number in the series that this book is.
     *
     * @return number in series
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the <code>TypeOfBook</code> of this <code>Fiction</code> book.
     *
     * @param type <code>TypeOfBook</code> of this book
     */
    public void setType(TypeOfBook type) {
        this.type = type;
    }

    /**
     * Sets the <code>Genre</code> of this <code>Fiction</code>.
     *
     * @param genre the <code>Genre</code>
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Sets the <code>Series</code> of this book
     *
     * @param series the <code>Series</code>
     */
    public void setSeries(Series series) {
        this.series = series;
    }

    /**
     * Set the number in the series that this book is.
     *
     * @param numberInSeries number in series.
     */
    public void setNumber(int numberInSeries) {
        number = numberInSeries;
    }
//</editor-fold>
}
