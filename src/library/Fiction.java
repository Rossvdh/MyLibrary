/*
 * Fiction book inherits from Book
 * Ross van der Heyde
 * started: 30 November 2014
 */
package library;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class represents a fiction book that can be added to the Fiction table
 * in the database. It inherits from <code>Book</code>
 *
 * @author Ross
 */
public class Fiction extends Book {

    //class variables
    private Genre genre;
    private TypeOfBook type;
    private Series series;
    private int number;

    /**
     * Default constructor. Creates a new <code>Fiction</code> object
     */
    public Fiction() {  //default
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
     * @param t title of <code>Fiction</code>
     * @param m month <code>Fiction</code> was bought
     * @param y year <code>Fiction</code> was bought
     * @param p priced paid for <code>Fiction</code> was bought
     * @param plc <code>Shop</code> where <code>Fiction</code> was bought
     * @param pub year <code>Fiction</code> was first published
     * @param a <code>ArrayList</code> of <code>Author</code>s of this
     * <code>Fiction</code>
     * @param g genre of this <code>Fiction</code>
     * @param n number in <code>Series</code>
     * @param s <code>Series</code> that this book is part of
     * @param ty TypeOfBook of book
     */
    public Fiction(String t, int m, int y, double p, Shop plc, int pub, ArrayList<Author> a,
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
    public Fiction(Fiction copy) {  //copy constructor
        super(copy);
        this.genre = copy.genre;
        this.type = copy.type;
        this.series = copy.series;
        this.number = copy.number;
    }

    /**
     * Adds this book to the database. sproc DONE
     *
     * @return Boolean indicating successfulness of insertion
     */
    @Override
    public boolean addToDatabase() {
        /*
        call super.addToDatabase
        (new id is set in super)
        if new series:
            add new series
            get max series ID
        add this book
         */

        boolean success = super.addToDatabase();

        //adding series should be done in GUI/Series class
        //add this book if super could be added
        if (success) {
            try {
                //addFiction(idNum INT, ser INT, num INT, type INT, gen INT)
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL addFiction(?,?,?,?,?)}");

                cstmt.setInt(1, id);
                cstmt.setInt(2, series.getId());
                cstmt.setInt(3, number);
                cstmt.setInt(4, type.getID());
                cstmt.setInt(5, genre.getId());

                success = cstmt.executeUpdate() == 1;

                return success;

            } catch (SQLException se) {
                se.printStackTrace();
            }
        } else {
            System.out.println("library.Fiction.addToDatabase() - super " + title + " class could not be added");
        }

        System.out.println("library.Fiction.addToDatabase() - Fiction " + title + " could not be added");
        return false;
    }

    /**
     * Updates a specific value of this book in the database. Make a sproc for
     * this
     *
     * @param field String. field to be updated
     * @param newValue String containing new updated value
     *
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {

        field = field.toLowerCase();

        //get list with fields in Fiction
//        , "noinseries", "typeofbook", 
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
                System.out.println("library.Fiction.updateInDatabase() - invalid field");
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
            System.out.println("library.Fiction.updateInDatabase() SQLEx - "
                    + sQLException);
            sQLException.printStackTrace();
        } catch (NumberFormatException nfe) {
            DRIVER.errorMessageNormal("Please enter a digits only");
            System.out.println("library.Fiction.updateInDatabase() NFE - "
                    + nfe);
            nfe.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes this book from the database. sproc DONE
     *
     * @return success boolean indicating successful deletion
     */
    @Override
    /*public boolean deleteFromDatabase() {
    //ask use to confirm deletion
    int c = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
    + authors + "?");
    
    if (c == 0) {
    //delete
    boolean del = super.deleteFromDatabase();
    
    if (del) {
    try {
    CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteFiction(?)}");
    
    cstmt.setInt(1, id);
    
    return cstmt.executeUpdate() == 1;
    } catch (SQLException se) {
    DRIVER.errorMessageNormal("From Fiction.deleteFromDatabase:" + se);
    se.printStackTrace();
    }
    
    return true;
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
     * Returns a <code>String</code> representationof this <code>Fiction</code>
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
     * Return the <code>Series</code> taht this <code>Fiction</code> book is
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
     * @param t <code>TypeOfBook</code> of this book
     */
    public void setType(TypeOfBook t) {
        type = t;
    }

    /**
     * Sets the <code>Genre</code> of this <code>Fiction</code>.
     *
     * @param g the <code>Genre</code>
     */
    public void setGenre(Genre g) {
        genre = g;
    }

    /**
     * Sets the <code>Series</code> of this book
     *
     * @param s the <code>Series</code>
     */
    public void setSeries(Series s) {
        series = s;
    }

    /**
     * Set the number in the series that this book is.
     *
     * @param sn number in series.
     */
    public void setNumber(int sn) {
        number = sn;
    }
//</editor-fold>
}
