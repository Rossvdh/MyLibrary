/*Role class
Ross van der Heyde
5 February 2017*/
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents an <code>Author</code>'s roleName in the writing of the book.
 * Although it refers to an "author", it includes roles like illustrator, editor, etc.
 *
 * @author Ross
 */
public class Role implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Borrower.class.getName());

    private String roleName = "";
    private int id = -1;

    /**
     * Default constructor. Creates a new Role object
     */
    public Role() {

    }

    /**
     * Parameterized constructor. Creates a new <code>Role</code> object with the
     * given roleName name and ID number
     *
     * @param roleName roleName name
     * @param roleID   roleName ID number
     */
    public Role(String roleName, int roleID) {
        this.roleName = roleName;
        id = roleID;
    }

    /**
     * Parameterized constructor. Creates a new <code>Role</code> object with the
     * given roleName name. Sets the roleName ID from the database using the given name
     *
     * @param r roleName name
     */
    public Role(String r) {
        roleName = r;
        setIDFromDatabase();
    }

    /**
     * Copy constructor. Creates a new Role that is a copy of the
     * <code>Role</code> given as parameter.
     *
     * @param other <code>Role</code> to copy
     */
    public Role(Role other) {
        this.roleName = other.roleName;
        this.id = other.id;
    }

    /**
     * Sets the ID number of this <code>Role</code> from the database using the
     * roleName name.
     */
    public void setIDFromDatabase() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getRoleID(?)}");

            //set parameters
            stmt.setString(1, roleName);

            //execute
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                logger.fine("From Role.setIDFromName: roleName \"" + roleName + "\" not found");
                DRIVER.errorMessageNormal("From Role.setIDFromName: roleName \"" + roleName + "\" not found");
            }
            rs.close();
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
            DRIVER.errorMessageCritical("From Role.setIDFromName: " + se);
        }
    }

    /**
     * Returns this <code>Role</code>'s name as a String
     *
     * @return Name of this Role
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Returns this <code>Role</code>'s ID
     *
     * @return int with roleName ID
     */
    public int getRoleID() {
        return id;
    }

    /**
     * Set the name of this <code>Role</code>.
     *
     * @param roleName the name of the Role
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Set the id of this <code>Role</code>.
     *
     * @param roleID the roleName ID of the Role
     */
    public void setRoleID(int roleID) {
        id = roleID;
    }

    /**
     * *
     * Returns a String representation of this <code>Role</code>
     *
     * @return String representing this <code>Role</code>
     */
    public String toString() {
        return roleName + " (" + id + ")";
    }

    /**
     * Determines if this <code>Role</code> and the given <code>Object</code>
     * are equal. Roles are equal if they have the same name or the same ID
     *
     * @return boolean indicating if they are equal
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() == this.getClass()) {
            Role otherRole = (Role) other;

            return this.roleName.equals(otherRole.roleName) || this.id == otherRole.id;
        } else {
            return false;
        }
    }

    /**
     * Adds this <code>Role</code> to the database
     *
     * @return boolean indicating successful addition to the database
     */
    public boolean addToDatabase() {
        try {
            Driver driver = new Driver();

            CallableStatement cstmt = driver.getCallStatement("{call addRole(?)}");

            cstmt.setString(1, roleName);

            int numberAdded = cstmt.executeUpdate();
            cstmt.close();
            return numberAdded == 1;
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
            DRIVER.errorMessageNormal("Role '" + roleName + "' could not be added");
            return false;
        }
    }

    /**
     * Deletes this <code>Author</code> from the database
     *
     * @return boolean indicating successful deletion
     */
    public boolean deleteFromDatabase() {
        try {
            Driver driver = new Driver();

            CallableStatement cstmt = driver.getCallStatement("{call deleteRole(?)}");

            cstmt.setInt(1, id);

            int ret = cstmt.executeUpdate();
            cstmt.close();

            return ret == 1;
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
        return false;
    }

    /**
     * Updates a field of this <code>Role</code> in the database. The only field
     * of <code>Role</code> that can be update is "roleName"
     *
     * @param field    the field to update. Can only be "Role"
     * @param newValue the new value of "roleName"
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equalsIgnoreCase("roleName")) {
            setRoleName(newValue);

            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateRole(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setString(1, newValue);

                int numberUpdated = cstmt.executeUpdate();
                cstmt.close();
                return numberUpdated == 1;
            } catch (SQLException se) {
                logger.log(Level.WARNING, se.toString(), se);
            }
        } else {
            logger.fine("Please select an appropriate field to update (i.e roleName)");
            DRIVER.errorMessageNormal("Please select an appropriate field to update (i.e roleName)");
        }

        return false;
    }

}
