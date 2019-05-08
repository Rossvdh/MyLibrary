/*
 * Author class
 * Ross van der Heyde
 * started: 30 November 2014
 * a new line has been added here,
 * because I am testing push/pulls on github
 #another line just in case
 */
package library;

import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class representing an author. An <code>Author</code> has a name, id, and <code>Role</code>.
 *
 * @author Ross
 */
public class Author implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Author.class.getName());

    private int id = -1;
    private String name = "";
    private Role role = null;

    /**
     * Default constructor.
     */
    public Author() {

    }

    /**
     * Construct an <code>Author</code> with the given ID
     *
     * @param i ID number of the author
     */
    public Author(int i) {
        id = i;
    }

    /**
     * Construct and <code>Author</code> with the given name and role. Also sets
     * the ID from the database using the given name.
     *
     * @param n the <code>Author</code>'s name
     * @param r the <code>Role</code> of this <code>Author</code>
     */
    public Author(String n, Role r) {
        name = n;
        role = r;
        setIDFromName();
    }

    /**
     * Copy constructor
     *
     * @param a The <code>Author</code> to create a copy of
     */
    public Author(Author a) {
        this.id = a.id;
        this.name = a.name;
        this.role = new Role(a.role);
    }

    /**
     * Sets this <code>Author</code>'s ID from the database using the name
     */
    public void setIDFromName() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getAuthorID(?)}");

            //set parameters
            stmt.setString(1, name);

            //execute
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //set ID
                id = rs.getInt(1);
                rs.close();
            } else {
                DRIVER.errorMessageNormal("From Author.setIDFromName: author " + name + "not found");
            }
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
    }

    /**
     * Returns true if th given Object is equal to this Author. Authors are
     * equal if they have same name and same role
     *
     * @param other Object to compare this Author to
     * @return boolean indicating equality
     */
    @Override
    public boolean equals(Object other) { //in Person
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            Author otherA = (Author) other;
            return (this.name.equals(otherA.name) && this.role.equals(otherA.role));
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns a String representing this <code>Author</code>.
     *
     * @return String in the format "Name (id)"
     */
    @Override
    public String toString() {
        return name + "(" + id + ")";
    }

    /**
     * Returns the ID of this <code>Author</code>.
     *
     * @return the ID as an int
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the ID number of this <code>Author</code>
     *
     * @param i ID of this <code>Author</code>
     */
    public void setID(int i) {
        id = i;
    }

    /**
     * Returns the name of this <code>Author</code>
     *
     * @return the Author's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this <code>Author</code>.
     *
     * @param n the name of the Author
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Sets the <code>Role</code> of this <code>Author</code>
     *
     * @param rol <code>Role</code> of this <code>Author</code>
     */
    public void setRole(Role rol) {
        role = new Role(rol);
    }

    /**
     * Returns this <code>Author's Role</code>.
     *
     * @return <code>Role</code> of this <code>Author</code>
     */
    public Role getRole() {
        return role;
    }

    /**
     * Adds this <code>Author</code> to the database
     *
     * @return Boolean indicating successful addition
     */
    @Override
    public boolean addToDatabase() {
        Driver driver = new Driver();
        int newId = -1;

        try {
            CallableStatement stmt = driver.getCallStatement("{call addAuthor(?)}");

            stmt.setString(1, name);

            newId = stmt.executeUpdate();

            logger.fine("Author.addToDatabase: newID: " + newId);

        } catch (SQLException se) {
            se.printStackTrace();
        }

        if (newId > 0) {
            id = newId;

            return true;
        }

        return false;

    }

    /**
     * Deletes this <code>Author</code> from the database
     *
     * @return Boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        int numberUpdated = 0;
        CallableStatement stmt = null;
        try {
            Driver driver = new Driver();

            stmt = driver.getCallStatement("{call deleteAuthor(?)}");
            stmt.setInt(1, id);
            numberUpdated = stmt.executeUpdate();

            logger.log(Level.FINE, "numberUpdated = {0}", numberUpdated);

            stmt.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
        return numberUpdated == 1;
    }

    /**
     * Updates a field of this <code>Author</code> in the database. The only
     * field of an <code>Author</code> that can be updated is name. The method
     * also sets this <code>Author</code>'s new name
     *
     * @param field    the field to update (in this case, field can only be "name"
     * @param newValue the <code>Author</code> new name
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equals("name")) {
            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateAuthorName(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setString(field, newValue);

                boolean success = cstmt.executeUpdate() == 1;

                if (success) {
                    setName(newValue);
                    return true;
                }
            } catch (SQLException ex) {
                logger.log(Level.WARNING, ex.toString(), ex);
            }
        } else {
            DRIVER.errorMessageNormal("Please select a valid field to update (i.e. name");
        }
        return false;
    }
}
