import java.sql.*;

public class Stock {
    void addNewMedicine(String manufacturerName, String medicineName, int power, int pricePerTablet, int quantity) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            Statement stmt = conn.createStatement();

            ResultSet table = stmt.executeQuery("SELECT * FROM stock_data WHERE medicine_name = '" + medicineName + "';");

            if(!table.next()){

                // Create a SQL prepared statement with parameter binding
                String sql = "INSERT INTO stock_data (manufacturer_name, medicine_name, power, price_per_tablet, quantity) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, manufacturerName);
                pstmt.setString(2, medicineName);
                pstmt.setInt(3, power);
                pstmt.setInt(4, pricePerTablet);
                pstmt.setInt(5, quantity);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 1) {
                    System.out.println("\nNew Medicine Added Successfully");
                } else {
                    System.out.println("\nMedicine Data Cannot Be Added");
                }

                pstmt.close();
                conn.close();

            }
            else{
                System.out.println("\nMedicine Already Exists -");
            }
            
        } catch (SQLException e) {
            System.out.println("\nSQLException Occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
