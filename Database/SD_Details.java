
package InitDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hatim
 */
public class SD_Details {
    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";

   
    public void addTable() {

        String sql = "CREATE TABLE S_Details(Email VARCHAR(30) Primary Key, B_Group VARCHAR(30),ID INTEGER "
                + "GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1),FOREIGN KEY(ID) REFERENCES StudentDB(ID), UNIQUE(ID))";
                
// try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

// execute statement 
            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, 
                    "Student Details Table Created successfully");

                        
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());
        }
    }

    /**
     * Adds a new row to the Person table with the given information.
     * @param mail Email in string format
     * @param Group Blood Group in string format
     * @param ID ID of the Student Auto Generated Linking to StudentDB
     * @return  Row count of affected rows.
     */
    
    public void addRow(String mail, String Group) {
        String sql = "INSERT INTO S_Details(Email,B_Group) VALUES(?,?)";
        // use try with resource
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement pstmt = connect.prepareStatement(sql);) {

            // set sql parameters with received values
            pstmt.setString(1,mail);
            pstmt.setString(2,Group);
     
            
            // execute statement 
            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, 
                    "Row for " + mail + " " + Group 
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

        SD_Details app = new SD_Details();
        JOptionPane.showMessageDialog(null, "Starting Application ...");

    // call addTable
        app.addTable();
        
      
        String email,bgroup;
        email = JOptionPane.showInputDialog("Please enter Email");
        bgroup= JOptionPane.showInputDialog("Please enter Blood Group");
        
        
   // call addRow
        app.addRow(email,bgroup);
        System.exit(0);

    }
}
