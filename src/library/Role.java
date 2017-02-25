/*Role class
Ross van der Heyde
5 February 2017*/
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static library.DatabaseEntry.DRIVER;

/**
 *
 * @author Ross
 */
public class Role implements DatabaseEntry {

    private String role = "";
    private int id = -1;

    /**
     * Default constructor. Creates a new Role object
     */
    public Role() {

    }

    /**
     * Parametized constructor. Creates a new <code>Role</code> object with the
     * given role name and ID number
     *
     * @param r role name
     * @param rI role ID number
     */
    public Role(String r, int rI) {
        role = r;
        id = rI;
    }

    /**
     * Parametized constructor. Creates a new <code>Role</code> object with the
     * given role name. Sets the role ID from the database using the given name
     *
     * @param r role name
     */
    public Role(String r) {
        role = r;
        setIDFromDatabase();
    }

    /**
     * Copy constructor. Creates a new Role that is a copy of the
     * <code>Role</code> given as parameter.
     *
     * @param other <code>Role</code> to copy
     */
    public Role(Role other) {
        this.role = other.role;
        this.id = other.id;
    }

    /**
     * Sets the ID number of this <code>Role</code> from the database using the
     * role name.
     */
    public void setIDFromDatabase() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getRoleID(?)}");

            //set parameters
            stmt.setString(1, role);

            //execute
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
                rs.close();
            } else {
                rs.close();
                DRIVER.errorMessageNormal("From Role.setIDFromName: role \"" + role + "\" not found");
            }
        } catch (SQLException se) {
            DRIVER.errorMessageCritical("From Role.setIDFromName: " + se);
            se.printStackTrace();
        }
    }

    /**
     * Returns this <code>Role</code>'s name as a String
     *
     * @return Name of this Role
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns this <code>Role</code>'s ID
     *
     * @return int with role ID
     */
    public int getRoleID() {
        return id;
    }

    /**
     * Set the name of this <code>Role</code>.
     *
     * @param r the name of the Role
     */
    public void setRole(String r) {
        role = r;
    }

    /**
     * Set the id of this <code>Role</code>.
     *
     * @param rid the role ID of the Role
     */
    public void setRoleID(int rid) {
        id = rid;
    }

    /**
     * *
     * Returns a String representation of this <code>Role</code>
     *
     * @return String representing this <code>Role</code>
     */
    public String toString() {
        return role + " (" + id + ")";
    }

    /**
     * Determines if this <code>Role</code> and the given <code>Object</code>
     * are equal. Roles are equal if they have the same name or the same ID
     *
     * @return boolean indicating if they are equal
     */
    public boolean equals(Object other) {
        if (other.getClass() == this.getClass()) {
            Role otherRole = (Role) other;

            return this.role.equals(otherRole.role) || this.id == otherRole.id;
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

            CallableStatement stmt = driver.getCallStatement("{call addRole(?)}");

            stmt.setString(1, role);

            return stmt.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes this <code>Author</code> from the database
     *
     * @return Boolean indicating successful deletion
     */
    public boolean deleteFromDatabase() {
        try {
            Driver driver = new Driver();

            CallableStatement stmt = driver.getCallStatement("{call deleteRole(?)}");

            stmt.setInt(1, id);

            int ret = stmt.executeUpdate();

            System.out.println("from Role.deleteFromDatabase: ret = " + ret);

            return ret == 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }

    /**
     * Updates a field of this <code>Role</code> in the database. The only field
     * of <code>Role</code> that can be update is "role"
     *
     * @param field the field to update. Can only be "Role"
     * @param newValue the new value of "role"
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equalsIgnoreCase("role")) {
            setRole(newValue);

            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateRole(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setString(1, newValue);

                return cstmt.executeUpdate() == 1;

            } catch (SQLException se) {
                System.out.println("library.Role.updateInDatabase():" + se);
                se.printStackTrace();
            }
        } else {
            DRIVER.errorMessageNormal("Please select an appropriate field to update (i.e role)");
        }

        return false;
    }

}
