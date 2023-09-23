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

    void showAllMedicineData() {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
    
            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
    
            // Execute the SQL query to select all data from the stock_data table
            ResultSet medicine_data_table = stmt.executeQuery("SELECT * FROM stock_data;");
    
            // Initialize variables to store column values
            String manufacturer_name, medicine_name;
            int power, price_per_tablet, quantity;
    
            // Check if there are rows in the result set
            if (!medicine_data_table.isBeforeFirst()) {
                System.out.println("\nNo Data Found -"); // Display a message if no data is found
            } else {
                // Display column headers
                System.out.println("\nManufacturer Name   | Medicine Name     | Power       | Price Per Tablet | Quantity");
    
                // Iterate through the result set using a while loop
                while (medicine_data_table.next()) {
                    // Retrieve values from the result set
                    manufacturer_name = medicine_data_table.getString(1);
                    medicine_name = medicine_data_table.getString(2);
                    power = medicine_data_table.getInt(3);
                    price_per_tablet = medicine_data_table.getInt(4);
                    quantity = medicine_data_table.getInt(5);
    
                    // Define the format for displaying medicine data as a table
                    String format = "\n%-19s | %-17s | %-11d | %-16d | %-8d";
    
                    // Use String.format() to format and display the data
                    System.out.println(String.format(format, manufacturer_name, medicine_name, power, price_per_tablet, quantity));
                }
            }
    
            // Close the database connection
            conn.close();
    
        } catch (SQLException e) {
            // Handle SQL exceptions and print error messages
            e.printStackTrace();
            System.out.println("\nSQLException Occurred -");
        }
    }  
    // Method to search for medicine in the database by its name and power
    void searchMedicine(String medicine_name, String power) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
        
            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
            ResultSet medicineData;
        
            String manufacturer_name, med_name;
            int pwr, price_per_tablet, quantity;
        
            // Check if power is "0" (assuming "0" means no power specified)
            if ("0".equals(power)) {
                // Search for medicine by name without considering power
                medicineData = stmt.executeQuery("SELECT * FROM stock_data WHERE medicine_name = '" + medicine_name + "';");
        
                // Check if the medicine data was found
                if (!medicineData.next()) {
                    System.out.println("\nMedicine Data Not Found -");
                } else {
                    // Display a header for the table
                    System.out.println("\nManufacturer Name   | Medicine Name     | Power       | Price Per Tablet | Quantity\n");
        
                    do {
                        // Retrieve data from the ResultSet
                        manufacturer_name = medicineData.getString(1);
                        med_name = medicineData.getString(2);
                        pwr = medicineData.getInt(3);
                        price_per_tablet = medicineData.getInt(4);
                        quantity = medicineData.getInt(5);
        
                        // Define the format for displaying medicine data as a table
                        String format = "%-19s | %-17s | %-11d | %-16d | %-8d";
        
                        // Use String.format() to format and display the data
                        System.out.println(String.format(format, manufacturer_name, med_name, pwr, price_per_tablet, quantity));
        
                    } while (medicineData.next());
                }
            } else {
                // Search for medicine by both name and power
                medicineData = stmt.executeQuery("SELECT * FROM stock_data WHERE medicine_name = '" + medicine_name + "' AND power = '" + power + "';");
        
                // Check if the medicine data was found
                if (!medicineData.next()) {
                    System.out.println("\nMedicine Data Not Found -");
                } else {
                    // Display a header for the table
                    System.out.println("\nManufacturer Name   | Medicine Name     | Power       | Price Per Tablet | Quantity");
        
                    do {
                        // Retrieve data from the ResultSet
                        manufacturer_name = medicineData.getString(1);
                        med_name = medicineData.getString(2);
                        pwr = medicineData.getInt(3);
                        price_per_tablet = medicineData.getInt(4);
                        quantity = medicineData.getInt(5);
        
                        // Define the format for displaying medicine data as a table
                        String format = "\n%-19s | %-17s | %-11d | %-16d | %-8d";
        
                        // Use String.format() to format and display the data
                        System.out.println(String.format(format, manufacturer_name, med_name, pwr, price_per_tablet, quantity));
        
                    } while (medicineData.next());
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("\nSQLException Occurred");
        }
    }
     
}