/*
 * Library 3. Book class. variables for both fiction and non-fiction books,
 * add, update, and delete methods.
 * Ross van der Heyde
 * started: 30 November 2014

 Changes on 25 July 2015: No longer abstract class, methods implemented
 */
package library;

import util.PopUpMessages;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class representing a Book
 *
 * @author Ross
 */
public class Book implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Book.class.getName());

    protected int id;
    protected String title;
    protected int month;
    protected int year;
    protected double price;
    protected Shop shop;
    protected List<Author> authors = new ArrayList<>();
    protected int published;
    protected boolean onLoan = false;

    /**
     * Default constructor. Creates a new <code>Book</code> object
     */
    public Book() {

    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given ID number. Also initializes the title and author.
     *
     * @param i ID number of this <code>Book</code>
     */
    public Book(int i) {
        id = i;

        //initialize most important attributes
        getTitleFromDatabase();
        getAuthorFromDatabase();
    }

    /**
     * Parameterized constructor. Creates a new <code>Book</code> object with
     * the given attributes.
     *
     * @param title          title of <code>Book</code>
     * @param month          month <code>Book</code> was bought
     * @param year           year <code>Book</code> was bought
     * @param price          priced paid for <code>Book</code> was bought
     * @param shop           <code>Shop</code> where <code>Book</code> was bought
     * @param firstPublished year <code>Book</code> was first published
     * @param authors        <code>ArrayList</code> of <code>Author</code>s of this
     *                       <code>Book</code>
     */
    public Book(String title, int month, int year, double price, Shop shop, int firstPublished, List<Author> authors) {
        this.title = title;
        this.month = month;
        this.year = year;
        this.price = price;
        this.shop = shop;
        this.published = firstPublished;
        this.authors = authors;
    }

    /**
     * Copy constructor. Creates a new <code>Book</code> object that is a copy
     * of the given <code>Book</code>
     *
     * @param copy <code>Book</code> to create a copy of
     */
    public Book(Book copy) {
        this.id = copy.id;
        this.title = copy.title;
        this.month = copy.month;
        this.year = copy.year;
        this.price = copy.price;
        this.shop = new Shop(copy.shop);
        this.published = copy.published;
        this.authors = new ArrayList<>(copy.authors);
        this.onLoan = copy.onLoan;
    }

    /**
     * Sets the title of this <code>Book</code> by using the ID number and
     * getting the title from the database
     */
    public void getTitleFromDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL getBookTitle(?)}");

            cstmt.setInt(1, id);

            try (ResultSet rs = cstmt.executeQuery()) {

                if (rs.next()) {
                    this.title = rs.getString(1);
                } else {
                    logger.fine("library.Book.getTitleFromDatabase() title for book " + id + " not found.");
                }
            }
            cstmt.close();
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
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

            try (ResultSet rs = cstmt.executeQuery()) {

                while (rs.next()) {
                    Author auth = new Author();

                    auth.setID(rs.getInt(1));
                    auth.setName(rs.getString(2));

                    addAuthor(auth);
                }
            }
            cstmt.close();
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
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
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            Book otherB = (Book) other;

            return (this.title.equals(otherB.title) && this.authors.equals(otherB.authors));
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.authors);
        return hash;
    }

    /**
     * Adds this Book to the database. The process is as folLows:
     * insert this book
     * get max bookID
     * set this book's ID to maxID
     * for each author:
     * if new author:
     * insert new author
     * get max author ID
     * insert link entry
     * return boolean
     *
     * @return boolean indicating successful insertion
     */
    @Override
    public boolean addToDatabase() {
        try {
            //`addBook`(tit VARCHAR(100), cost INT, shop INT, month INT, year INT, pub INT)
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL addBook(?,?,?,?,?,?)}");

            cstmt.setString(1, title);
            cstmt.setDouble(2, price);
            logger.fine("library.Book.addToDatabase() shop: " + shop.toString());
            cstmt.setInt(3, shop.getID());
            cstmt.setInt(4, month);
            cstmt.setInt(5, year);
            cstmt.setInt(6, published);

            boolean success = cstmt.executeUpdate() == 1;

            if (success) {
                //get max ID
                cstmt = DRIVER.getCallStatement("{CALL getMaxBookID()}");

                try (ResultSet rs = cstmt.executeQuery()) {
                    //get max ID from ResultSet
                    if (rs.next()) {
                        id = rs.getInt(1);
                    } else {
                        PopUpMessages.errorMessageNormal("No max Book ID found");
                        return false;
                    }
                }

                //add Authors
                return addLinkEntries();
            } else {
                PopUpMessages.errorMessageNormal("The book \"" + title + "\" could not be added");
                return false;
            }

        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
        return false;
    }

    /**
     * Update a specific value (title, author, price, placebought, mnth, yr, firstpub)
     * of this book.
     * <p>
     * TODO: how to update authors? Book.
     *
     * @param field    String. value to be updated
     * @param newValue String containing new updated value
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
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
                    PopUpMessages.errorMessageNormal("Please select a valid field to update.");
                    return false;
                }
            }

            cstmt.setInt(1, id);

            return cstmt.executeUpdate() == 1;

        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
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

            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete \"" + title + "\" by "
                    + authors + "?");

            if (choice == JOptionPane.YES_OPTION) {
                //delete
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteBook(?)}");

                cstmt.setInt(1, id);

                return cstmt.executeUpdate() == 1;
            } else {
                logger.fine("library.Book.deleteFromDatabase() - user chose not to delete " + title);
                return false;
            }
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }

        return false;
    }

    /**
     * Returns a <code>String</code> representation of this <code>Book</code>.
     * The format is: "title - authorName, authorName, ..."
     *
     * @return String representing this <code>Book</code>
     */
    @Override
    public String toString() {
        StringBuilder authorsString = new StringBuilder();

        for (Author author : authors) {
            authorsString.append(author).append(", ");
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
     * Returns a <code>List</code> of this <code>Book</code>'s
     * <code>Author</code>s.
     *
     * @return <code>Author</code>s in an <code>ArrayList</code>
     */
    public List<Author> getAuthor() {
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

    /**
     * Sets the on loan status of this <code>Book</code>
      * @param onLoan true if the book is on loan, otherwise false
     */
    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    /**
     * Sets the title of this <code>Book</code>
     *
     * @param title title of this <code>Book</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the price of this <code>Book</code>
     *
     * @param price price of this <code>Book</code>
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the month in which this <code>Book</code> was bought
     *
     * @param month month of purchase
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Sets year in which this <code>Book</code> was bought
     *
     * @param year year of purchase
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets <code>Shop</code> where this book was bought<code>Book</code>
     *
     * @param shop place of purchase
     */
    public void setShop(Shop shop) {
        logger.fine("library.Book.setShop() 1 shop.toString: " + shop.toString());
        this.shop = shop;
        logger.fine("library.Book.setShop() 2 shop.toString: " + shop.toString());
        logger.fine("library.Book.setShop() 3 shop.toString: " + this.shop.toString());
    }

    /**
     * Sets year in which this <code>Book</code> was published
     *
     * @param firstPublished year of first publication
     */
    public void setPublished(int firstPublished) {
        published = firstPublished;
    }

    /**
     * Sets the <code>Author</code>s of this <code>Book</code>
     *
     * @param authors <code>ArrayList</code> of <code>Authors</code>
     */
    public void setAuthor(List<Author> authors) {
        this.authors = authors;
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
     * @param author <code>Author</code> to add
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Determines if the given <code>Author</code> is an author of this
     * <code>Book</code>
     *
     * @param author <code>Author</code> to see if an author
     * @return true if the given <code>Author</code> is an author of this
     * <code>Book</code>
     */
    public boolean isAuthor(Author author) {
        return authors.contains(author);
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

                logger.fine("library.Book.addLinkEntries(). author: " + author);

                cstmt.setInt(1, author.getID());
                cstmt.setInt(2, id);
                cstmt.setInt(3, author.getRole().getRoleID());

                allAdded &= cstmt.executeUpdate() == 1;

                if (allAdded) {
                    logger.fine("library.Book.addLinkEntries() " + author.getName() + " added");
                } else {
                    logger.fine("library.Book.addLinkEntries() " + author.getName() + " could not be added");
                }

            } catch (SQLException se) {
                logger.log(Level.WARNING, se.toString(), se);
                allAdded = false;
            }
        }
        return allAdded;
    }
}
