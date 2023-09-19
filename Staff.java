import java.sql.*;

public class Staff {
    // Method to change the password for a staff member
    void changePassword(String staff_id, String oldPassword, String newPassword) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
            
            // Create a SQL statement
            Statement stmt = conn.createStatement();

            // Execute a query to select the staff member by staff_id
            ResultSet table = stmt.executeQuery("SELECT * FROM staff_login WHERE staff_id = " + staff_id + ";");

            // Check if the staff member exists
            if (!table.next()) {
                System.out.println("\nStaff Member Not Found (Staff Id Not Found) -");
            }
			else {
                // Compare the old password provided with the stored password
                if (table.getString(2).equals(oldPassword)) {
                    // Update the password if the old password matches
                    if (stmt.executeUpdate("UPDATE staff_login SET password = " + newPassword + " WHERE staff_id = " + staff_id + ";") == 1) {
                        System.out.println("\nPassword Updated Successfully -");
                    }
					else {
                        System.out.println("\nPassword Cannot Be Changed -");
                    }
                }
				else {
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
