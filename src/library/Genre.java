/*Class for Genre: id and name
 */
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ross
 */
public class Genre implements DatabaseEntry {

    //attributes
    private int id = -1;
    private String genreName = "";

    /**
     * Default constructor. Creates a new <code>Genre</code> object
     */
    public Genre() {

    }

    /**
     * Parametized constructor. Creates a new <code>Genre</code> object with the
     * given id
     *
     * @param id The ID number of the <code>Genre</code>
     */
    public Genre(int id) {
        this.id = id;
    }

    /**
     * Parametized constructor. Creates a new <code>Genre</code> object with the
     * given genre name. Sets the ID from the database
     *
     * @param name name of the <code>Genre</code>
     */
    public Genre(String name) {
        genreName = name;
        setIDFromName();
    }

    /**
     * Copy constructor. Creates a new <code>Genre</code> object that is equal
     * to this one.
     *
     * @param g <code>Genre</code> object to copy
     */
    public Genre(Genre g) {
        this.id = g.id;
        this.genreName = g.genreName;
    }

    /**
     * Sets the ID of this <code>Genre</code> object from the database, using
     * the genre name
     */
    public void setIDFromName() {
        try {
            //get callStatment
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getGenreID(?)}");

            //set parameters
            stmt.setString(1, genreName);

            //execute
            ResultSet rs = stmt.executeQuery();

            //extract genre ID
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                DRIVER.errorMessageNormal("From driver.getGenreID: genre not found");
            }
            rs.close();
        } catch (SQLException se) {
            DRIVER.errorMessageCritical("From driver.getGenreID: " + se);
        }
    }

    /**
     * Returns the ID number of this <code>Genre</code>
     *
     * @return ID of this <code>Genre</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of this <code>Genre</code>
     *
     * @return name of this <code>Genre</code>
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * Sets the ID number of this <code>Genre</code>
     *
     * @param id ID number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of this <code>Genre</code>
     *
     * @param genreName name of <code>Genre</code>
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Determines if this <code>Genre</code> and the given <code>Object</code>
     * are equal. <code>Genre</code>s are equal if their names are the same.
     * Note that most of this method was automatically generated.
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
        final Genre other = (Genre) obj;

        return genreName.equals(other.genreName);
    }

    /**
     * Add this <code>Genre</code> to the database
     *
     * @return boolean indicating successful insertion
     */
    @Override
    public boolean addToDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL addGenre(?)}");

            cstmt.setString(1, genreName);

            return cstmt.executeUpdate() == 1;
        } catch (SQLException se) {
            System.out.println("Genre.addToDatabase(): " + se);
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes this <code>Genre</code> from the database.
     *
     * @return boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{Call deleteGenre(?)}");

            cstmt.setInt(1, id);

            return cstmt.executeUpdate() == 1;

        } catch (SQLException se) {
            System.out.println("library.Genre.deleteFromDatabase(): " + se);
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Update a field of this <code>Genre</code> in the database. The only field
     * that can be updated is genreNamw.
     *
     * @param field must be "genreName"
     * @param newValue the new genre name
     * @return boolean indicating successful update.
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        if (field.equalsIgnoreCase("genreName")) {
            try {
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateGenre(?,?)}");

                cstmt.setInt(1, id);
                cstmt.setString(2, newValue);

                boolean success = cstmt.executeUpdate() == 1;

                //only change attribute if the update was successful
                if (success) {
                    setGenreName(newValue);
                    return true;
                }
            } catch (Exception e) {
                System.out.println("library.Genre.updateInDatabase(): " + e);
                e.printStackTrace();
            }
        } else {
            DRIVER.errorMessageCritical("Please select a valid field to update (i.e. field)");
        }

        return false;
    }

}
