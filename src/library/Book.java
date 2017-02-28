/*
 * Library 3. Book class. variables for both fiction and non-fiction books,
 * add, update, and delete methods.
 * Ross van der Heyde
 * started: 30 November 2014

 Changes on 25 July 2015: No longer abstract class, methods implemented
 */
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Class representing a Book
 *
 * @author Ross
 */
public class Book implements DatabaseEntry {

    //class variables
    protected int id;
    protected String title;
    protected int month;
    protected int year;
    protected double price;
    protected Shop shop;
    protected ArrayList<Author> authors = new ArrayList<Author>();
    protected int published;
    protected boolean onLoan = false;//is the book on loan or not

    /**
     * Default constructor. Creates a new <code>Book</code> object
     */
    public Book() {     //default

    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given ID number. Also initializes the title and author.
     *
     * @param i ID number of this <code>Book</code>
     */
    public Book(int i) {
        id = i;

        //initalize most important attributes
        getTitleFromDatabase();
        getAuthorFromDatabase();
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
     * <code>Book</code>
     */
    public Book(String t, int m, int y, double p, Shop plc, int pub, ArrayList<Author> a) {
        title = t;
        month = m;
        year = y;
        price = p;
        shop = plc;
        published = pub;
        authors = a;
    }

    /**
     * Copy constructor. Creates a new <code>Book</code> object that is a copy
     * of the given <code>Book</code>
     *
     * @param copy <code>Book</code> to create a copy of
     */
    public Book(Book copy) {
        title = copy.title;
        month = copy.month;
        year = copy.year;
        price = copy.price;
        shop = new Shop(copy.shop);
        published = copy.published;
        authors = new ArrayList<Author>(copy.authors);
    }

    /**
     * Sets the title of this <code>Book</code> by using the ID number and
     * getting the title from the database
     */
    public void getTitleFromDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL getBookTitle(?)}");

            cstmt.setInt(1, id);

            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                title = rs.getString(1);
            } else {
                System.out.println("library.Book.getTitleFromDatabase() title for book " + id + " not found.");
            }

        } catch (SQLException se) {
            System.out.println("library.Book.getTitleFromDatabase(): " + se);
            se.printStackTrace();
        }
    }

    /**
     * Sets the author(s) of this <code>Book</code> by using the ID number and
     * getting the author(s) from the database
     */
    public void getAuthorFromDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL getBookAuthors(?)}");

            cstmt.setInt(1, id);

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                Author auth = new Author();

                auth.setID(rs.getInt(1));
                auth.setName(rs.getString(2));

                addAuthor(auth);
            }

        } catch (SQLException se) {
            System.out.println("library.Book.getAuthorFromDatabase(): " + se);
            se.printStackTrace();
        }
    }

    /**
     * Check if 2 books are equal to each other. <code>Book</code>s are equal if
     * they have the same author(s) and the same title
     *
     * @param other object to compare to book
     * @return boolean indicating equality
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {//check if same class
            //if not same class, they can't be equal, so return false
            return false;
        } else {
            //are same class, so cast object to book
            Book otherB = (Book) other;

            //check if title and author are the same
            return (this.title.equals(otherB.title) && this.authors.equals(otherB.authors));
        }
    }

    /**
     * Adds this Book to the database.
     *
     * @return boolean indicating successful insertion
     */
    @Override
    public boolean addToDatabase() {
        /*
        insert this book
        get max bookID
        set this book's ID to maxID
        for each author:
            if new author:
                insert new author
                get max author ID
            insert link entry
        return boolean        
         */

        try {
            //`addBook`(tit VARCHAR(100), cost INT, shop INT, month INT, year INT, pub INT)
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL addBook(?,?,?,?,?,?)}");

            cstmt.setString(1, title);
            cstmt.setDouble(2, price);
            System.out.println("library.Book.addToDatabase() shop: " + shop.toString());
            cstmt.setInt(3, shop.getID());
            cstmt.setInt(4, month);
            cstmt.setInt(5, year);
            cstmt.setInt(6, published);

            boolean success = cstmt.executeUpdate() == 1;

            if (success) {
                //get max ID
                cstmt = DRIVER.getCallStatement("{CALL getMaxBookID()}");

                ResultSet rs = cstmt.executeQuery();

                //get max ID from ResultSet
                if (rs.next()) {
                    id = rs.getInt(1);

                } else {
                    DRIVER.errorMessageNormal("No max Book ID found");
                    return false;
                }
                rs.close();

                //add Authors
                return addLinkEntries();

            } else {
                DRIVER.errorMessageNormal("The book \"" + title + "\" could not be added");
                return false;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Update a specific value (eg title, series) of this book.
     *
     * TODO: how to update authors? Book.
     *
     * @param field String. value to be updated
     * @param newValue String containing new updated value
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        /*title
        author
        price
        placebought
        mnth
        yr
        firstpub*/
        field = field.toLowerCase();

        CallableStatement cstmt;

        try {
            switch (field) {
                case "title": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksTitle(?,?)}");

                    cstmt.setString(2, newValue);
                    break;
                }
                case "price": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksPrice(?,?)}");

                    cstmt.setDouble(2, Double.parseDouble(newValue));
                    break;
                }
                case "place bought": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksShop(?,?)}");

                    cstmt.setInt(2, Integer.parseInt(newValue));
                    break;
                }
                case "month bought": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksMonth(?,?)}");

                    cstmt.setInt(2, Integer.parseInt(newValue));
                    break;
                }
                case "year bought": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksYear(?,?)}");

                    cstmt.setInt(2, Integer.parseInt(newValue));
                    break;
                }
                case "first published": {
                    cstmt = DRIVER.getCallStatement("{CALL updateBooksFirstPub(?,?)}");

                    cstmt.setInt(2, Integer.parseInt(newValue));
                    break;
                }
                default: {
                    DRIVER.errorMessageNormal("Please select a valid field to update.");
                    return false;
                }
            }

            cstmt.setInt(1, id);

            return cstmt.executeUpdate() == 1;

        } catch (SQLException se) {
            System.out.println("library.Book.updateInDatabase() - se: " + se);
            se.printStackTrace();
            return false;
        }
    }

    /**
     * Delete this <code>Book</code> from the database.
     *
     * @return boolean indicating success of deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        try {

            int c = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
                    + authors + "?");

            if (c == 0) {
                //delete
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteBook(?)}");

                cstmt.setInt(1, id);

                return cstmt.executeUpdate() == 1;
            } else {
                System.out.println("library.Book.deleteFromDatabase() - user chose not to delete " + title);
                return false;
            }
        } catch (SQLException se) {
            DRIVER.errorMessageNormal("From Book.deleteFromDatabase: " + se);
            se.printStackTrace();
        }

        return false;
    }

    /**
     * Sets the title of this book from database using ID
     *
     */
    //<editor-fold defaultstate="collapsed" desc="getTitleFromDatabase">
    /*public void getTitleFromDatabase() {
    try {
    //query to get title
    ResultSet rs = DRIVER.query("SELECT title FROM AllBooks WHERE id = " + id);
    
    if (rs.next()) {
    title = rs.getString(1);
    rs.close();
    } else {
    DRIVER.errorMessageNormal("Book.getTitleFromDatabase: no title found");
    }
    } catch (SQLException se) {
    DRIVER.errorMessageNormal("From Book.getTitleFromDatabase: " + se);
    }
    }*/
//</editor-fold>
    /**
     * Sets the author of this book from database using ID
     *
     */
    //<editor-fold defaultstate="collapsed" desc="getAuthorFromDatabase">
    /*public void getAuthorFromDatabase() {
    try {
    //query to get title
    ResultSet rs = DRIVER.query("SELECT author FROM AllBooks WHERE id = " + id);
    
    if (rs.next()) {
    Author temp = new Author();
    
    temp.setName(rs.getString(1));
    
    auth = new Author(temp);
    rs.close();
    } else {
    DRIVER.errorMessageNormal("book.getAuthorFromDatabase: noAuthorFound");
    }
    } catch (SQLException se) {
    DRIVER.errorMessageNormal("From Book.getAuthorFromDatabase: " + se);
    }
    }*/
//</editor-fold>
    /**
     * Returns a <code>String</code> representation of this <code>Book</code>.
     * The format is: "title - authorName, authoName, ..."
     *
     * @return String representing this <code>Book</code>
     */
    @Override
    public String toString() {
        String authorsString = "";

        for (Author author : authors) {
            authorsString += author + ", ";
        }

        return title + " - " + authorsString;
    }

    /**
     * Returns the title of this <code>Book</code>.
     *
     * @return title of this <code>Book</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns month in which this <code>Book</code> was bought
     *
     * @return month as int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year in which this <code>Book</code> was bought
     *
     * @return year of purchase as int
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the <code>Shop</code> where this <code>Book</code> was bought
     *
     * @return <code>Shop</code> where <code>Book</code> was bought
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * Return the amount (in Rand) paid for this <code>Book</code>
     *
     * @return price of this <code>Book</code>
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns an <code>ArrayList</code> of this <code>Book</code>'s
     * <code>Author</code>s.
     *
     * @return <code>Author</code>s in an <code>ArrayList</code>
     */
    public ArrayList<Author> getAuthor() {
        return authors;
    }

    /**
     * Returns the ID number of this
     *
     * @return this <code>Book</code>'s ID number
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the year that this <code>Book</code> was first published
     *
     * @return year of publication
     */
    public int getPublished() {
        return published;
    }

    //not sure if this will be used
    /*public boolean getOnLoan() {
    return onLoan;
    }*/

 /* public void setonLoan(boolean l) {
    onLoan = l;
    }*/
    /**
     * Sets the title of this <code>Book</code>
     *
     * @param t title of this <code>Book</code>
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * Sets the price of this <code>Book</code>
     *
     * @param p price of this <code>Book</code>
     */
    public void setPrice(double p) {
        price = p;
    }

    /**
     * Sets the month in which this <code>Book</code> was bought
     *
     * @param m month of purchase
     */
    public void setMonth(int m) {
        month = m;
    }

    /**
     * Sets year in which this <code>Book</code> was bought
     *
     * @param y year of purchase
     */
    public void setYear(int y) {
        year = y;
    }

    /**
     * Sets <code>Shop</code> where this book was bought<code>Book</code>
     *
     * @param s place of purchase
     */
    public void setShop(Shop s) {
        System.out.println("library.Book.setShop() 1 s.toString: " + s.toString());
        shop = s;
        System.out.println("library.Book.setShop() 2 s.toString: " + s.toString());
        System.out.println("library.Book.setShop() 3 shop.toString: " + shop.toString());
    }

    /**
     * Sets year in which this <code>Book</code> was published
     *
     * @param fp year of first publication
     */
    public void setPublished(int fp) {
        published = fp;
    }

    /**
     * Sets the <code>Author</code>s of this <code>Book</code>
     *
     * @param ar <code>ArrayList</code> of <code>Authors</code>
     */
    public void setAuthor(ArrayList<Author> ar) {
        authors = ar;
    }

    /**
     * Determines if this <code>Book</code> is currently on loan
     *
     * @return true if on loan
     */
    public boolean isOnLoan() {
        return onLoan;
    }

    /**
     * Adds an <code>Author</code> to the list of this <code>Book</code>'s
     * <code>Author</code>s
     *
     * @param a <code>Author</code> to add
     */
    public void addAuthor(Author a) {
        authors.add(a);
    }

    /**
     * Determines if the given <code>Author</code> is an author of this
     * <code>Book</code>
     *
     * @param a <code>Author</code> to see if an author
     * @return true if the given <code>Author</code> is an author of this
     * <code>Book</code>
     */
    public boolean isAuthor(Author a) {
        return authors.contains(a);
    }

    /**
     * Adds all of the <code>Author</code>s of this <code>Book</code> to the
     * LinkBookAuthor Table
     *
     * @return boolean indicating successful insertion
     */
    public boolean addLinkEntries() {
        boolean allAdded = true;

        for (Author author : authors) {
            try {
                //addLinkEntry(author INT, book INT, role INT)
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL addLinkEntry(?,?,?)}");

                System.out.println("library.Book.addLinkEntries(). author: " + author);

                cstmt.setInt(1, author.getID());
                cstmt.setInt(2, id);
                cstmt.setInt(3, author.getRole().getRoleID());

                allAdded &= cstmt.executeUpdate() == 1;

                if (allAdded) {
                    System.out.println("library.Book.addLinkEntries() " + author.getName() + " added");
                } else {
                    System.out.println("library.Book.addLinkEntries() " + author.getName() + " could not be added");
                }

            } catch (SQLException se) {
                System.out.println("library.Book.addLinkEntries(): SQLException when adding " + author);
                allAdded = false;
                se.printStackTrace();
            }
        }
        return allAdded;
    }
}
