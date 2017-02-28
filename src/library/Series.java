/*Series of books
Ross vander Heyde
17 Feb 2017. Proteas laid the smack down on NZ this morning
 */
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Objects;

/**
 *
 * @author Ross
 */
public class Series implements DatabaseEntry {

    //class variables
    private int id = -1;
    private String name = "";
    private int numBooks = 0;

    /**
     * Default constructor for <code>Series</code>
     */
    public Series() {
    }

    /**
     * Parameterized constructor for <code>Series</code>
     * @param n Name of this <code>Series</code>
     * @param nb number of books in this <code>Series</code>
     */
    public Series(String n, int nb) {
        name = n;
        numBooks = nb;
    }

    /**
     * Parameterized constructor for <code>Series</code>. Also set the ID of
     * this <code>Series</code> object from the database using the name of the
     * series.
     *
     * @param n name of the series
     */
    public Series(String n) {
        name = n;
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
        this.numBooks = other.numBooks;
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
    public int getNumBooks() {
        return numBooks;
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
     * @param numBooks number of books in the <code>Series</code>
     */
    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }

    /**
     * Determines if this <code>Series</code> and the given <code>Object</code>
     * are equal. Note that this is a generated method
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * Deletes this <code>Series</code> from the database
     *
     * @return Boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        try {
            Driver driver = new Driver();

            CallableStatement stmt = driver.getCallStatement("{call deleteSeries(?)}");

            stmt.setInt(1, id);

            int ret = stmt.executeUpdate();

            System.out.println("from Series.deleteFromDatabase: ret = " + ret);

            return ret == 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }

    /**
     * Adds this <code>Series</code> to the database
     *
     * @return Boolean indicating successful addition
     */
    @Override
    public boolean addToDatabase() {
        Driver driver = new Driver();
        int newId = -1;

        try {
            CallableStatement stmt = driver.getCallStatement("{call addSeries(?, ?)}");

            stmt.setString(1, name);
            stmt.setInt(2, numBooks);

            newId = stmt.executeUpdate();

            //--------------------
            //Statement.RETURN_GENERATED_KEYS;
            ResultSet rs = stmt.getGeneratedKeys();

            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("column count: " + rsmd.getColumnCount());

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + "\t");
            }

            while (rs.next()) {
                System.out.println("next");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println("");
            }

            //-------------------
            System.out.println("Series.addToDatabase: newID: " + newId);

        } catch (SQLFeatureNotSupportedException fns) {
            System.out.println("SQLFeatureNotSupportedException");
            fns.printStackTrace();
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

                System.out.println("Series.setIDFromName(): name: " + name);
                return true;
            } else {
                System.out.println("library.Series.setIDFromName(). series \"" + name + "\" not found");
                rs.close();
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("from Series.setIDFromName: " + ex);
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Update a field of this <code>Series</code> in the database. <i>field</i>
     * can be "name" or "numberOfBooks". The method also sets the new value of
     * the applicable attribute of this <code>Series</code>.
     *
     * @param field the field in the database to update
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

                    return num == 1;
                } catch (SQLException ex) {
                    System.out.println("Series.updateInDatabase(): " + ex);
                    ex.printStackTrace();
                }

                break;
            }
            case "NumberOfBooks":
            case "numberOfBooks": {
                int nBooks = Integer.parseInt(newValue);
                setNumBooks(nBooks);

                CallableStatement cstmt = DRIVER.getCallStatement("{CALL updateSeriesNumBooks(?,?)}");

                try {
                    cstmt.setInt(1, id);
                    cstmt.setInt(2, nBooks);

                    int num = cstmt.executeUpdate();

                    return num == 1;
                } catch (SQLException ex) {
                    System.out.println("Series.updateInDatabase(): " + ex);
                    ex.printStackTrace();
                }
                break;
            }
            default: {
                System.out.println("Series.updateInDatabase(): invalid field name");
                DRIVER.errorMessageNormal("please select a field in the Series table");
            }
        }

        return false;
    }
}
