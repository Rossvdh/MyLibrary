/*Testing possiblity of an interface for library
Ross van der Heyde
18 February 2017. Room was painted*/
package library;

import java.sql.ResultSet;

/**
 * An interface for all classes of objects that can be added to the database.
 * The <code>DatabaseEntry</code> interface provides methods for adding,
 * deleting and updating records in the database. It also provides a static
 * instantiation of the <code>Driver</code> for access to method for connecting
 * to the database and info or error messages.
 */
public interface DatabaseEntry {

    static final Driver DRIVER = new Driver();

    //TODO: initialize attributes from ID? (if it has an ID, it is in the Database)
    //TODO: get ID from name/title/type etc?
    /**
     * Adds this <code>DatabaseEntry</code> object to the database. This method
     * will set the object's id attribute and then return a boolean indicating
     * the success of the insertion.
     *
     * @return true if successfully inserted, false otherwise
     */
    public boolean addToDatabase();

    /**
     * Deletes this <code>DatabaseEntry</code> object from the database. This
     * method will return a boolean indicating the success of the
     * deletion. There will always be a pop-up asking for confirmation of
     * deletion.
     *
     * @return true if successfully deleted, false otherwise
     */
    public boolean deleteFromDatabase();

    /**
     * Updates the given field of this <code>DatabaseEntry</code> object in the
     * database. The class variable's value in this <code>Object</code> will
     * also be updated. This method will return a boolean indicating the
     * success of the update.
     *
     * @param field The field to update
     * @param newValue The new value of the field to update.
     * @return true if successfully updated, false otherwise
     */
    public boolean updateInDatabase(String field, String newValue);

    /**
     * A method that search the database for <code>DatabaseEntry</code>s that
     * match the criterion in the given field. If the criterion is a
     * <code>String</code>, then the field is matched using LIKE. If it is a
     * number, it is matched with =.<br>
     * This method is static, so requires an implementation in this interface.
     * It just returns null. So this method must be implementing in all
     * implementing subclasses, even though the compiler will not have an error
     * if it is not implemented.
     *
     * @param field The field to search by
     * @param criterion What is being searched for.
     * @return <code>ResultSet</code> containing the results of the search.
     */
    public static ResultSet search(String field, String criterion) {
        return null;
    }
}
