import java.sql.*;

public class Admin {
    // Method to change the password for an admin
    void changePassword(String admin_id, String oldPassword, String newPassword) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
            
            // Create a SQL statement
            Statement stmt = conn.createStatement();

            // Execute a query to select the admin by admin_id
            ResultSet table = stmt.executeQuery("SELECT * FROM admin_login WHERE admin_id = " + admin_id + ";");

            // Check if the admin exists
            if (!table.next()) {
                System.out.println("\nAdmin Id Not Found -");
            } else {
                // Compare the old password provided with the stored password
                if (table.getString(2).equals(oldPassword)) {
                    // Update the password if the old password matches
                    if (stmt.executeUpdate("UPDATE admin_login SET password = '" + newPassword + "' WHERE admin_id = '" + admin_id + "';") == 1) {
                        System.out.println("\nPassword Updated Successfully -");
                    } else {
                        System.out.println("\nPassword Cannot Be Changed -");
                    }
                } else {
                    System.out.println("\nOld Password Is Not Matched -");
                }
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions that occur
            e.printStackTrace();
            System.out.println("\nSQLException Occurred - " + e.getMessage());
        }
    }
}
