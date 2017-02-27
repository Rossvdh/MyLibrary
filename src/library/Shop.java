/*
 Shop class
 Ross van der Heyde
 Started: 7 December 2014
 */
package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ross
 */
public class Shop implements DatabaseEntry {

    //class variables
    private int id = -1;
    private String name = "";
    private String area = "";
    private String phone = "";
    private String email = "";

    /**
     * Default constructor. Creates a new <code>Shop</code> object
     */
    public Shop() {
    }

    /**
     * Parameterized constructor. Creates a new <code>Shop</code> object with
     * the given ID
     *
     * @param i ID number of this <code>Shop</code>
     */
    public Shop(int i) {
        id = i;
    }

    /**
     * Parameterized constructor. Sets this <code>Shop</code> object's id using
     * the given shop name.
     *
     * @param name the name of the <code>Shop</code>
     */
    public Shop(String name) {
        this.name = name;
        setIDFromName();
    }

    /**
     * Parameterized constructor.
     *
     * @param n name of this <code>Shop</code>.
     * @param a Area/suburb that this <code>Shop</code>. is located in
     * @param ph Contact number of this <code>Shop</code>.
     * @param e E-mail address of this <code>Shop</code>.
     */
    public Shop(String n, String a, String ph, String e) {
        name = n;
        area = a;
        phone = ph;
        email = e;
    }

    /**
     * Copy constructor. Create a new <code>Shop</code>. object that is equal to
     * the <code>Shop</code>. given as parameter
     *
     * @param copy <code>Shop</code>. to copy
     */
    public Shop(Shop copy) {
        this.id = copy.id;
        this.name = copy.name;
        this.area = copy.area;
        this.email = copy.email;
        this.phone = copy.phone;
    }

    /**
     * Sets the id of this <code>Shop</code> from the database using the name.
     */
    private void setIDFromName() {
        try {
            //perform query, get ID, return
            CallableStatement stmt = DRIVER.getCallStatement("{CALL getShopID(?)}");

            //set parameters
            stmt.setString(1, name);

            //execute
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //set ID
                id = rs.getInt(1);

                System.out.println("library.Shop.setIDFromName(). toString " + toString());

                rs.close();
            } else {
                rs.close();
                DRIVER.errorMessageNormal("From Shop.setIDFromName: shop " + name + " not found");
            }
        } catch (SQLException se) {
            DRIVER.errorMessageCritical("From Shop.setIDFromName: " + se);
            se.printStackTrace();
        }
    }

    /**
     * Determines of this <code>Shop</code> is equal to the given
     * <code>Object</code>
     *
     * @param other
     * @return boolean indicating equality
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other.getClass() == this.getClass()) {
            Shop otherShop = (Shop) (other);

            return this.name.equals(otherShop.name);
        } else {
            return false;
        }
    }

    /**
     * Add this shop to database. sproc DONE
     *
     * @return boolean indicating successful addition
     */
    @Override
    public boolean addToDatabase() {
        //addShop`(name VARCHAR(50), ar VARCHAR(50), ph VARCHAR(12), address VARCHAR(100))

        CallableStatement cstmt = DRIVER.getCallStatement("{CALL addShop(?,?,?,?)}");
        int num = 0;

        try {
            cstmt.setString(1, name);
            cstmt.setString(2, area);
            cstmt.setString(3, phone);
            cstmt.setString(4, email);

            num = cstmt.executeUpdate();
        } catch (SQLException se) {
            DRIVER.errorMessageNormal("From Shop.addToDatabase: " + se);
            se.printStackTrace();
        }

        //execute update, return boolean
        return num == 1;
    }

    /**
     * Update a specific value of this shop
     *
     * @param field value to be updated
     * @param newValue updated value
     *
     * @return boolean indicating successful update
     */
    @Override
    public boolean updateInDatabase(String field, String newValue) {
        //create query
        String q = "UPDATE Shops SET " + field
                + " = '" + newValue + "' WHERE id = " + id;

        //execute query and return boolean
        return DRIVER.modifyQuery(q);
    }

    /**
     * Delete this <code>Shop</code> from the database.
     *
     * @return boolean indicating successful deletion
     */
    @Override
    public boolean deleteFromDatabase() {
        setNameFromDatabase();

        int c = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + name + "?");
        // 0 - yes
        // 1 - no
        // 2 - cancel

        if (c == 0) {
            CallableStatement cstmt = DRIVER.getCallStatement("{CALL deleteShop(?)}");
            int num = 0;

            try {
                cstmt.setInt(1, id);

                num = cstmt.executeUpdate();

                return num == 1;
            } catch (SQLException se) {
                DRIVER.errorMessageNormal("From Shop.deleteShop: " + se);
                se.printStackTrace();
            }

        }
        return false;
    }

    /**
     * Sets this Shop's name given the ID.
     */
    public void setNameFromDatabase() {
        try {
            ResultSet rs = DRIVER.query("SELECT shopName FROM Shops WHERE id = " + id);

            if (rs.next()) {
                name = rs.getString(1);
                rs.close();
            } else {
                DRIVER.errorMessageNormal("Shop with ID " + id + " was not founDRIVER.");
            }
        } catch (SQLException se) {
            DRIVER.errorMessageNormal("From Shop.deleteShop: " + se);
        }
    }

    /**
     * Returns a String representation of this Shop object
     *
     * @return String representing this Shop object
     */
    @Override
    public String toString() {
        return name + "(" + id + ")";
    }

    /**
     * Returns this <code>Shop</code>'s name
     *
     * @return name of the shop
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the area that this <code>Shop</code> is located in.
     *
     * @return area.suburb of this <code>Shop</code>
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns this <code>Shop</code>'s e-mail address
     *
     * @return e-mail adress
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns this <code>Shop</code>'s contact number
     *
     * @return contact number as String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns this <code>Shop</code>'s ID
     *
     * @return ID number of this <code>Shop</code>
     */
    public int getID() {
        return id;
    }

    /**
     * Sets this <code>Shop</code>'s ID number
     *
     * @param i ID number of this <code>Shop</code>
     */
    public void setID(int i) {
        id = i;
    }

    /**
     * Sets this <code>Shop</code>'s ID name
     *
     * @param n name of this <code>Shop</code>
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Sets this <code>Shop</code>'s ID are
     *
     * @param a area/suburb where this <code>Shop</code> is located
     */
    public void setArea(String a) {
        area = a;
    }

    /**
     * Sets this <code>Shop</code>'s e-mail address
     *
     * @param e e-mail address of this <code>Shop</code>
     */
    public void setEmail(String e) {
        email = e;
    }

    /**
     * Sets this <code>Shop</code>'s ID phone/contact number
     *
     * @param ph contact number of this <code>Shop</code>
     */
    public void setPhone(String ph) {
        phone = ph;
    }

}
