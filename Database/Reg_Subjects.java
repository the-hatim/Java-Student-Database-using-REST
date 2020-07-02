
package InitDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Reg_Subjects {
    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";

   
    public void addTable() {

        String sql ="CREATE TABLE R_Subjects(S_Code VARCHAR(30), S_no INTEGER Primary Key "
                + "GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 5),Email VARCHAR(30),FOREIGN KEY(Email) REFERENCES S_Details(Email))";
                
// try with resource
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {

// execute statement 
            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, 
                    "Registered Subjects Table Created successfully");

                        
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Message: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Code: " + sqle.getSQLState());
        }
    }

    /**
     * Adds a new row to the Person table with the given information.
     * @param sub Registered Subjects in string format
     * @param xmail Email in string format
     * @param ID ID of the Student Auto Generated Linking to StudentDB
     * @return  Row count of affected rows.
     */
    
    public void addRow(String xmail, String sub) {
        String sql = "INSERT INTO R_Subjects(Email,S_code)VALUES(?,?)";
        // use try with resource
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement pstmt = connect.prepareStatement(sql);) {

            // set sql parameters with received values
            pstmt.setString(1,xmail);
            pstmt.setString(2,sub);
     
            
            // execute statement 
            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, 
                    "Row for " + xmail + " " + sub 
                    +" has been added");
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

        Reg_Subjects app = new Reg_Subjects();
        JOptionPane.showMessageDialog(null, "Starting Application ...");

    // call addTable
        app.addTable();
        
      
        String email,S_code;
        email = JOptionPane.showInputDialog("Please enter Email");
        S_code= JOptionPane.showInputDialog("Please enter Subject Code");
        
        
   // call addRow
        app.addRow(email,S_code);
        System.exit(0);

    }
 
}
