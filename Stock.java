import java.sql.*;

public class Stock {
    // Method to add a new medicine to the stock database
    void addNewMedicine(String manufacturerName, String medicineName, int power, int pricePerTablet, int quantity) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            // Execute a SELECT query to check if the medicine already exists in the database
            ResultSet table = stmt.executeQuery("SELECT * FROM stock_data WHERE medicine_name = '" + medicineName + "';");

            // Check if the medicine is not found in the database
            if (!table.next()) {

                // Create a SQL prepared statement with parameter binding
                String sql = "INSERT INTO stock_data (manufacturer_name, medicine_name, power, price_per_tablet, quantity) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, manufacturerName);
                pstmt.setString(2, medicineName);
                pstmt.setInt(3, power);
                pstmt.setInt(4, pricePerTablet);
                pstmt.setInt(5, quantity);

                // Execute the INSERT query and get the number of rows affected
                int rowsAffected = pstmt.executeUpdate();

                // Check if the insertion was successful
                if (rowsAffected == 1) {
                    System.out.println("\nNew Medicine Added Successfully");
                } else {
                    System.out.println("\nMedicine Data Cannot Be Added");
                }

                // Close the prepared statement and database connection
                pstmt.close();
                conn.close();

            } else {
                // If the medicine already exists in the database, display a message
                System.out.println("\nMedicine Already Exists -");
            }

        } catch (SQLException e) {
            // Handle any SQL-related exceptions and display an error message
            System.out.println("\nSQLException Occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
