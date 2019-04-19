/*Class for TypeOfBook of book. Has id and type
Ross van der Heyde
24 Feb 2017.
 */
package library;

import sun.awt.AWTAccessor;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ross
 */
public class TypeOfBook implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Author.class.getName());

    //attributes
    private int id = -1;
    private String type = "";

    /**
     * Default constructor. Creates a new <code>TypeOfBook</code> object
     */
    public TypeOfBook() {

    }

    /**
     * Parameterized constructor. Creates a new <code>TypeOfBook</code> object with
     * the given id
     *
     * @param id The ID number of the <code>TypeOfBook</code>
     */
    public TypeOfBook(int id) {
        this.id = id;
    }

    /**
     * Parameterized constructor. Creates a new <code>TypeOfBook</code> object with
     * the given type name. Sets the ID of this object from the database using
     * the type name
     *
     * @param typeName name of the <code>TypeOfBook</code>
     */
    public TypeOfBook(String typeName) {
        this.type = typeName;
        setIDFromDatabase();
    }

    /**
     * Copy constructor. Creates a new <code>TypeOfBook</code> object that is
     * equal to this one.
     *
     * @param typeOfBook <code>TypeOfBook</code> object to copy
     */
    public TypeOfBook(TypeOfBook typeOfBook) {
        this.id = typeOfBook.id;
        this.type = typeOfBook.type;
    }

    /**
     * Sets the ID of this <code>TypeOfBook</code> object from the database, using
     * the type name
     */
    public void setIDFromDatabase() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getTypeID(?)}");

            stmt.setString(1, type);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    logger.warning("dirver.getTypeID: type not found");
                }
            }

        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
    }

    /**
     * Returns the ID number of this <code>TypeOfBook</code>
     *
     * @return ID of this <code>TypeOfBook</code>
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the ID number of this <code>TypeOfBook</code>
     *
     * @param id ID number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the type name of this <code>TypeOfBook</code>
     *
     * @return type name of this <code>TypeOfBook</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type name of this <code>TypeOfBook</code>
     *
     * @param type type name
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a <code>String</code> representation of this
     * <code>TypeOfBook</code>
     *
     * @return String representing this <code>TypeOfBook</code>
     */
    public String toString() {
        return type + "(" + id + ")";
    }

    /**
     * Determines if this <code>TypeOfBook</code> and the given
     * <code>Object</code> are equal. <code>TypeOfBook</code>s are equal if their
     * type names are the same. Note that most of this method was automatically
     * generated.
     *
     * @param obj Object to compare to
     * @return boolean indicating equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeOfBook other = (TypeOfBook) obj;

        return this.type.equals(other.type);
    }

    /**
     * Returns the has code of this <code>{@link GUIs.TypeGUI}</code>
     * @return hash value
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    /**
     * Add this <code>TypeOfBook</code> to the database
     *
     * @return boolean indicating successful insertion
     */
    @Override
    public boolean addToDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL addType(?)}");

            cstmt.setString(1, type);

            return cstmt.executeUpdate() == 1;

        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
        return false;
    }

    /**
     * Delete this <code>TypeOfBook</code> from the database
     *
     * @return boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteType(?)}");

            cstmt.setInt(1, id);

            return cstmt.executeUpdate() == 1;
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }
        return false;
    }

    /**
     * Update a field of this <code>TypeOfBook</code> in the database. The only
     * field that can be updated is typeName
     *
     * @param field must be "type"
     * @param newValue the new type name
     * @return boolean indicating successful update.
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equalsIgnoreCase("type")) {
            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateType(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setString(2, newValue);

                boolean success = cstmt.executeUpdate() == 1;

                if (success) {
                    type = newValue;
                    return true;
                }

            } catch (SQLException se) {
                logger.log(Level.WARNING, se.toString(), se);
            }
        } else {
            DRIVER.errorMessageNormal("Please select a valid field to update (i.e type)");
        }

        return false;
    }
}
