/*Testing possiblity of an interface for library
Ross van der Heyde
18 February 2017. Room was painted*/

package library;

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
     * the successfulness of the insertion.
     *
     * @return boolean indicating successful addition to database
     */
    public boolean addToDatabase();

    /**
     * Deletes this <code>DatabaseEntry</code> object from the database. This
     * method will return a boolean indicating the successfulness of the
     * deletion. There will always be a pop-up asking for confirmation of
     * deletion.
     *
     * @return boolean indicating successful removal from database
     */
    public boolean deleteFromDatabase();

    /**
     * Updates the given field of this <code>DatabaseEntry</code> object in the
     * database. The class variable's value in this <code>Object</code> will
     * also be updated.
     * This method will return a boolean indicating the successfulness
     * of the update.
     *
     * @param field The field to update
     * @param newValue The new value of the field to update.
     * @return boolean indicating successful update in the database
     */
    public boolean updateInDatabase(String field, String newValue);
}
