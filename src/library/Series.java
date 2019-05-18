/*Series of books
Ross van der Heyde
17 Feb 2017. Proteas laid the smack down on NZ this morning
 */
package library;

import util.PopUpMessages;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a series of books. It has an ID, a series name,
 * and the number of books in the series.
 *
 * @author Ross
 */
public class Series implements DatabaseEntry {
    private static Logger logger = Logger.getLogger(Series.class.getName());

    private int id = -1;
    private String name = "";
    private int numberOfBooks = 0;

    /**
     * Default constructor for <code>Series</code>
     */
    public Series() {
    }

    /**
     * Parameterized constructor for <code>Series</code>
     *
     * @param name  Name of this <code>Series</code>
     * @param numberOfBooks number of books in this <code>Series</code>
     */
    public Series(String name, int numberOfBooks) {
        this.name = name;
        this.numberOfBooks = numberOfBooks;
    }

    /**
     * Parameterized constructor for <code>Series</code>. Also sets the ID of
     * this <code>Series</code> object from the database using the name of the
     * series.
     *
     * @param name name of the series
     */
    public Series(String name) {
        this.name = name;
        setIDFromName();
    }

    /**
     * copy constructor for <code>Series</code>
     *
     * @param other <code>Series</code> to create a copy of.
     */
    public Series(Series other) {
        this.id = other.id;
        this.name = other.name;
        this.numberOfBooks = other.numberOfBooks;
    }

    /**
     * Returns this <code>Series</code>'s ID
     *
     * @return int with ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns this <code>Series</code>'s name
     *
     * @return String with name of Series
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of books in this <code>Series</code>
     *
     * @return number of book as int
     */
    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    /**
     * Set this <code>Series</code>'s id
     *
     * @param id ID number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set this <code>Series</code>'s name
     *
     * @param name Name of the series
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the number of books in this <code>Series</code>.
     *
     * @param numberOfBooks number of books in the <code>Series</code>
     */
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    /**
     * Determines if this <code>Series</code> and the given <code>Object</code>
     * are equal. Two series are considered
     * equal if their IDs are the same or their names are the same
     *
     * @param obj <code>Object</code> to test equality of.
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
        final Series other = (Series) obj;
        return this.id == other.id || this.name == other.name;
    }

    /**
     * Returns the has code value of this <code>Series</code>. NOte that this is
     * a generated method
     * @return hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfBooks);
    }

    /**
     * Deletes this <code>Series</code> from the database
     *
     * @return Boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        CallableStatement stmt = DRIVER.getCallStatement("{call deleteSeries(?)}");
        try {

            stmt.setInt(1, id);

            int numberDeleted = stmt.executeUpdate();

            logger.fine("from Series.deleteFromDatabase: ret = " + numberDeleted);

            stmt.close();
            return numberDeleted == 1;

        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
        return false;
    }

    /**
     * Adds this <code>Series</code> to the database
     *
     * @return Boolean indicating successful addition
     */
    @Override
    public boolean addToDatabase() {
        ResultSet rs = null;

        try {
            CallableStatement cstmt = DRIVER.getCallStatement("{call addSeries(?, ?)}");

            cstmt.setString(1, name);
            cstmt.setInt(2, numberOfBooks);

            int numberAdded = cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            cstmt.close();
            return numberAdded == 1;

        } catch (SQLFeatureNotSupportedException fns) {
            logger.log(Level.WARNING, fns.toString(), fns);
        } catch (SQLException se) {
            logger.log(Level.WARNING, se.toString(), se);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.log(Level.WARNING, "Exception while trying to close ResultSet: " + e, e);
                }
            }
        }

        return false;
    }

    /**
     * Gets the ID number of <code>Series</code> in the database with the name
     * of this <code>Series</code> and then sets the ID of this
     * <code>Series</code>
     *
     * @return true if a series with the given name of found
     */
    public boolean setIDFromName() {
        CallableStatement cstmt = DRIVER.getCallStatement("{CALL getSeriesID(?)}");

        try {
            cstmt.setString(1, name);

            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
                rs.close();

                logger.fine("Series.setIDFromName(): name: " + name);
                return true;
            } else {
                logger.fine("library.Series.setIDFromName(). series \"" + name + "\" not found");
                rs.close();
                return false;
            }

        } catch (SQLException ex) {
            logger.log(Level.WARNING, ex.toString(), ex);
        }

        return false;
    }

    /**
     * Update a field of this <code>Series</code> in the database. <i>field</i>
     * can be "name" or "numberOfBooks". The method also sets the new value of
     * the applicable attribute of this <code>Series</code>.
     *
     * @param field    the field in the database to update
     * @param newValue the new value of the field
     * @return Boolean indicating successful update
     */
    public boolean updateInDatabase(String field, String newValue) {

        switch (field) {
            case "Name":
            case "name": {
                setName(newValue);
                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateSeriesName(?,?)}");

                try {
                    cstmt.setInt(1, id);
                    cstmt.setString(2, newValue);

                    int num = cstmt.executeUpdate();
                    cstmt.close();
                    return num == 1;
                } catch (SQLException ex) {
                    logger.log(Level.WARNING, ex.toString(), ex);
                }

                break;
            }
            case "NumberOfBooks":
            case "numberOfBooks": {
                int nBooks = Integer.parseInt(newValue);
                setNumberOfBooks(nBooks);

                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateSeriesNumBooks(?,?)}");

                try {
                    cstmt.setInt(1, id);
                    cstmt.setInt(2, nBooks);

                    int num = cstmt.executeUpdate();
                    cstmt.close();
                    return num == 1;
                } catch (SQLException ex) {
                    logger.log(Level.WARNING, ex.toString(), ex);
                }
                break;
            }
            default: {
                logger.fine("Series.updateInDatabase(): invalid field name");
                PopUpMessages.errorMessageNormal("please select a field in the Series table");
            }
        }

        return false;
    }
}
