
package InitDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hatim
 */
public class SD_Table {
    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";

   
    public void addTable() {

        String sql = "CREATE TABLE StudentDB(ID INTEGER Primary Key "
                + "GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1), "
                + "Firstname VARCHAR(30), Surname VARCHAR(30), "
                + "DateOfBirth DATE)";
// try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

// execute statement 
            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, 
                    "Student Table Created successfully");

                        
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());
        }
    }

    /**
     * Adds a new row to the Person table with the given information.
     * @param FName First name in string format
     * @param SName Surname in string format
     * @param DoB Date of birth in format "yyyy-[m]m-[d]d". The leading zero 
     *            for mm and dd may also be omitted.
     * @return  Row count of affected rows.
     */
    
    public void addRow(String FName, String SName, String DoB) {
        String sql = "INSERT INTO StudentDB(Firstname, Surname, "
                + "DateOfBirth) VALUES(?,?,?)";
        // use try with resource
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement pstmt = connect.prepareStatement(sql);) {

            // set sql parameters with received values
            pstmt.setString(1,FName);
            pstmt.setString(2,SName);
            pstmt.setDate(3, Date.valueOf(DoB));
            
            // execute statement 
            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, 
                    "Row for " + FName + " " + SName + ", DoB " + DoB 
                    + " has been added");
            }

            
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SD_Table app = new SD_Table();
        JOptionPane.showMessageDialog(null, "Starting Application ...");

    // call addTable
        app.addTable();
        
      
        String firstname, surname, dob;
        firstname = JOptionPane.showInputDialog("Please enter first name");
        surname = JOptionPane.showInputDialog("Please enter surname");
        dob = JOptionPane.showInputDialog("Please enter date of birth in "
                + "format yyyy-mm-dd");
        
   // call addRow
        app.addRow(firstname, surname, dob);
        System.exit(0);

    }
}
