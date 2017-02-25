/*Class for BookType of book. Has id and type
Ross van der Heyde
24 Feb 2017.
 */
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ross
 */
public class BookType implements DatabaseEntry {

    //attributes
    private int id = -1;
    private String type = "";

    /**
     * Default constructor. Creates a new <code>BookType</code> object
     */
    public BookType() {

    }

    /**
     * Parametized constructor. Creates a new <code>BookType</code> object with
     * the given id
     *
     * @param id The ID number of the <code>BookType</code>
     */
    public BookType(int id) {
        this.id = id;
    }

    /**
     * Parametized constructor. Creates a new <code>BookType</code> object with
     * the given type name. Sets the ID of this object from the database using
     * the type name
     *
     * @param name name of the <code>BookType</code>
     */
    public BookType(String name) {
        type = name;
        setIDFromDatabase();
    }

    /**
     * Copy constructor. Creates a new <code>BookType</code> object that is
     * equal to this one.
     *
     * @param g <code>BookType</code> object to copy
     */
    public BookType(BookType g) {
        this.id = g.id;
        this.type = g.type;
    }

    /**
     * Sets the ID of this <code>BookType</code> object from the database, using
     * the type name
     */
    public void setIDFromDatabase() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getTypeID(?)}");

            stmt.setString(1, type);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                DRIVER.errorMessageNormal("dirver.getTypeID: type not found");
            }
            rs.close();

        } catch (SQLException se) {
            DRIVER.errorMessageCritical("From driver.getGenreID: " + se);
        }
    }

    /**
     * Returns the ID number of this <code>BookType</code>
     *
     * @return ID of this <code>BookType</code>
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the ID number of this <code>BookType</code>
     *
     * @param id ID number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the type name of this <code>BookType</code>
     *
     * @return type name of this <code>BookType</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type name of this <code>BookType</code>
     *
     * @param type type name
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a <code>String</code> representation of this
     * <code>BookType</code>
     *
     * @return String representing this <code>BookType</code>
     */
    public String toString() {
        return type + "(" + id + ")";
    }

    /**
     * Determines if this <code>BookType</code> and the given
     * <code>Object</code> are equal. <code>BookType</code>s are equal if their
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
        final BookType other = (BookType) obj;

        return this.type.equals(other.type);
    }

    /**
     * Add this <code>BookType</code> to the database
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
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Delete this <code>BookType</code> from the database
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
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Update a field of this <code>BookType</code> in the database. The only
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
                se.printStackTrace();
            }
        } else {
            DRIVER.errorMessageNormal("Please select a valid field to update (i.e type)");
        }

        return false;
    }
}
