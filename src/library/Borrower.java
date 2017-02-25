/* Person who borrows books
 Ross van der Heyde
 26 January 2015*/
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ross
 */
public class Borrower implements DatabaseEntry{

    //attributes
    private int id = -1;
    private String name;
    private String number;
    private String email;
    private Driver driver = null;

    //constructors
    public Borrower() {//default
        driver = new Driver();
    }

    public Borrower(int i, Driver d) {
        id = i;
        driver = d;
        setNameFromDatabase();
    }

    public Borrower(int i, String na, String num, String e, Driver d) {
        id = i;
        name = na;
        number = num;
        email = e;
        driver = d;
    }

    public Borrower(int i, String na, String num, String e) {
        id = i;
        name = na;
        number = num;
        email = e;
    }

    //copy constructor
    public Borrower(Borrower copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.name = copy.name;
        this.number = copy.number;
        this.driver = copy.driver;
    }

    //set methods
    public void setID(int i) {
        id = i;
    }

    public void setName(String na) {
        name = na;
    }

    public void setNumber(String num) {
        number = num;
    }

    public void setEMail(String e) {
        email = e;
    }

    //get methods
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Sets the name of this borrower from database using ID
     *
     */
    private void setNameFromDatabase() {
        try {
            ResultSet rs = driver.query("SELECT fullName FROM Borrowers WHERE id =" + id);

            if (rs.next()) {
                name = rs.getString(1);
                rs.close();
            } else {
                driver.errorMessageNormal("Borrower with ID " + id + " not found.");
            }
        } catch (SQLException se) {
            driver.errorMessageNormal("FROM borrower.getNameFromDatabase: " + se);
        }
    }

    public String getNumber() {
        return number;
    }

    public String getEMail() {
        return email;
    }

    //toString method
    public String toString() {
        return id + "/" + name + "/" + number + "/" + email;
    }

    //equals method
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other instanceof Borrower) {
            Borrower otherB = (Borrower) other;

            if (this.id == otherB.id) {
                return true;
            } else {
                return this.name.equals(otherB.name) && this.number.equals(otherB.number)
                        && this.email.equals(otherB.email);
            }
        } else {
            return false;
        }
    }

    /**
     * Add this borrower to the database
     *
     * @return Boolean indicating successfulness of addition
     */
    public boolean addToDatabase() {
        //name, contact, email
        CallableStatement cstmt = driver.getCallStatement("{CALL addBorrower(?,?,?)}");
        try {
            //set parameters
            cstmt.setString(1, name);
            cstmt.setString(2, number);
            cstmt.setString(3, email);

            int num = cstmt.executeUpdate() ;
            
            cstmt.close();
            
            return num == 1;
        } catch (SQLException se) {
            driver.errorMessageNormal("From Borrower.addToDatabase: " + se);
            se.printStackTrace();
        } 
        
        return false;

        //String q = "INSERT INTO Borrowers (fullName, ContactNumber, email) VALUES"
        //      + " ('" + name + "', '" + number + "', '" + email + "')";
    }

    /**
     * Update a specific field of this borrower
     *
     * @param field String specifying field to be updated
     * @param newValue String containing new value of field
     *
     * @return Boolean indicating successfulness of update
     */
    public boolean updateInDatabase(String field, String newValue) {
        String q = "UPDATE Borrowers SET " + field + " = " + newValue
                + " WHERE id = " + id;

        return driver.modifyQuery(q);
    }

    /**
     * Deletes this borrower from the database
     *
     * @return Boolean indicating successfulness of deletion
     */
    public boolean deleteFromDatabase() {
        setNameFromDatabase();

        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + name+"?") == 0) {
            //delete
            CallableStatement cstmt = driver.getCallStatement("{CALL deleteBorrower(?)}");

            try {
                cstmt.setInt(1, id);

                int num = cstmt.executeUpdate();
                
                cstmt.close();
                
                return num ==1;
            } catch (SQLException se) {
                driver.errorMessageNormal("From Borrower.deleteFromDatabase: " + se);
                se.printStackTrace();
            }

            //return driver.modifyQuery("DELETE FROM Borrowers WHERE id = " + id);
        }
        //do not delete
        return false;

    }

    /**
     * Loans a book to this Borrower
     *
     * @param book Book being borrowed
     * @param date String with date book is being borrowed
     *
     * @return Boolean indicating successful loan
     */
    public boolean borrow(Book book, String date) {
        //String q1 = "INSERT INTO BBLink (borrowerID, bookID, date)"
        //        + "VALUES (" + id + ", " + book.id + ", '" + date + "')";

        //(person INT, book INT, date VARCHAR(10))
        CallableStatement cstmt = driver.getCallStatement("{CALL borrow(?,?,?)}");

        try {
            cstmt.setInt(1, id);
            cstmt.setInt(2, book.getID());
            cstmt.setString(3, date);

            int num = cstmt.executeUpdate() ;
            cstmt.close();
            
            return num== 1;
        } catch (SQLException se) {
            driver.errorMessageNormal("From Borrower.borrow: " + se);
            se.printStackTrace();
        }

        return false;
    }

    /**
     * Returns a book loaned by this borrower
     *
     * @param book Book being returned
     * @param date String with date book was returned
     * @return boolean indicating successful return
     */
    public boolean returnBook(Book book, String date) {
        //String q1 = "UPDATE BBLink SET dateReturned = '" + date + "' WHERE bookID = "
         //       + book.id + " AND borrowerID = " + id;

         //(person INT, book INT, date VARCHAR(10)
         CallableStatement cstmt = driver.getCallStatement("{CALL returnBook(?,?,?)}");

        try {
            cstmt.setInt(1, id);
            cstmt.setInt(2, book.getID());
            cstmt.setString(3, date);

            int num = cstmt.executeUpdate() ;
            cstmt.close();
            
            return num == 1;
        } catch (SQLException se) {
            driver.errorMessageNormal("From Borrower.returnBook: " + se);
            se.printStackTrace();
        }
         
        return false;// && driver.modifyQuery(q2);
    }

}
