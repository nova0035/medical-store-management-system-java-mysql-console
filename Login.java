import java.sql.*;

public class Login {
    public int staffLogin(int staff_id, String password) {
        
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            // Prepare an SQL query to retrieve staff information
            String query = "SELECT * FROM staff_login WHERE staff_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, staff_id);

            // Execute the SQL query and retrieve the result set
            ResultSet staff_login_table = stmt.executeQuery();

            // Check if the result set is empty (no matching staff_id)
            if (!staff_login_table.next()) {
                System.out.println("\nStaff ID Not Found -");
                return -1; // Staff ID not found in the database
            }

            else {
                // Retrieve the stored password from the result set
                String storedPassword = staff_login_table.getString("password");

                // Compare the entered password with the stored password
                if (password.equals(storedPassword)) {
                    System.out.println("\nLogin Successful -");
                    return 1; // Password matches, login successful
                }
                else {
                    System.out.println("\nPassword Is Wrong -");
                    return 0; // Incorrect password
                }
            }

        } catch (SQLException e) {
            System.out.println("\nSQLException Occurred: " + e.getMessage());
            return -2; // SQL exception occurred
        }
    }

    public int adminLogin(int admin_id, String password) {
        
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            // Prepare an SQL query to retrieve staff information
            String query = "SELECT * FROM admin_login WHERE admin_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, admin_id);

            // Execute the SQL query and retrieve the result set
            ResultSet admin_login_table = stmt.executeQuery();

            // Check if the result set is empty (no matching admin_id)
            if (!admin_login_table.next()) {
                System.out.println("\nAdmin ID Not Found -");
                return -1; // Admin ID not found in the database
            }

            else {
                // Retrieve the stored password from the result set
                String storedPassword = admin_login_table.getString("password");

                // Compare the entered password with the stored password
                if (password.equals(storedPassword)) {
                    System.out.println("\nLogin Successful -");
                    return 1; // Password matches, login successful
                }
                else {
                    System.out.println("\nPassword Is Wrong -");
                    return 0; // Incorrect password
                }
            }

        } catch (SQLException e) {
            System.out.println("\nSQLException Occurred: " + e.getMessage());
            return -2; // SQL exception occurred
        }
    }
}
