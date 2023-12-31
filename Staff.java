import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    // Method to add a new staff member
    void addNewStaffMember(int id, String password, String first_name, String last_name, String mobile_number, String email, String address, int salary) {
        
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
            
            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
    
            // Check if the staff member with the given ID already exists
            ResultSet table = stmt.executeQuery("SELECT * FROM staff_data WHERE id = " + id + ";");
    
            if (table.next()) {
                System.out.println("\nId Already Exists -");
            }
            else {
                // Create a SQL statement to insert a new staff member into the staff_data table
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO staff_data VALUES (?,?,?,?,?,?,?,?);");
    
                // Create a SimpleDateFormat with the desired date format
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
                // Get the current date
                Date currentDate = new Date();
    
                // Format the current date as a string in "DD/MM/YYYY" format
                String joining_date = dateFormat.format(currentDate);
    
                // Set the values for the prepared statement
                pstmt.setInt(1, id);
                pstmt.setString(2, first_name);
                pstmt.setString(3, last_name);
                pstmt.setString(4, mobile_number);
                pstmt.setString(5, email);
                pstmt.setString(6, address);
                pstmt.setString(7, joining_date);
                pstmt.setInt(8, salary);
    
                // Execute the insert query and check if it was successful
                if (pstmt.executeUpdate() == 1) {
                    System.out.println("\nNew Staff Member Added Successfully -");
    
                    // Create a SQL statement to insert the staff member's login information into the staff_login table
                    PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO staff_login VALUES (?,?);");
    
                    // Set the values for the login information
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, password);
    
                    // Execute the insert query for login information and check if it was successful
                    if (pstmt2.executeUpdate() == 1) {
                        System.out.println("\nId And Password Set Successfully -");
                    }
                    else {
                        System.out.println("\nId Password Cannot Be Set -");
                    }
                }
                else {
                    System.out.println("\nStaff Member Cannot Be Added");
                }
            }
    
            // Close the database connection
            conn.close();
    
        } catch (SQLException e) {
            // Handle SQL exceptions and print an error message
            System.out.println("\nSQLException Occurred: " + e.getMessage());
        }
    }

    // Method to remove a staff member
    void removeStaffMember(int id){

        try {

            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
            
            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            if(stmt.executeUpdate("DELETE FROM staff_data WHERE id = " + id + ";") == 1){

                System.out.println("\nStaff Member Removed Successfully");

                if(stmt.executeUpdate("DELETE FROM staff_login WHERE staff_id;") == 1){

                    System.out.println("Id And Password Removed Too -");
                }

                else{
                    System.out.println("\nId And Password Cannot Be Removed -");
                }
            }

            else{
                System.out.println("\nSTAFF ID NOT FOUND -");
            }
            
        } catch (SQLException e) {
            System.out.println("\nSQLException Occurred -");
        }
    }

    // Method to increase the salary of staff members
    void incrementSalary(int staffId, int incrementalValue) {

        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            // Get the current salary for the specified staff member
            int oldSalary = getSalary(staffId);

            if (oldSalary == -1) {
                // Staff ID not found
                return;
            }
            // Calculate the new salary by adding the incrementalValue
            int newSalary = oldSalary + incrementalValue;

            // Update the staff member's salary in the database
            if (stmt.executeUpdate("UPDATE staff_data SET salary = " + newSalary + " WHERE id = " + staffId + ";") == 1) {
                // Salary updated successfully
                System.out.println("\nSalary Incremented Successfully\nNew Salary = " + newSalary);
            }
            else {
                // Failed to update salary
                System.out.println("\nSalary Cannot Be Incremented");
            }
        }
        catch (SQLException e) {
            // Handle any SQL-related exceptions that may occur
            System.out.println("\nSQLException Occurred");
        }
    }

    int getSalary(int staffId) {

        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            // Retrieve the current salary of the staff member with the provided staffId
            ResultSet table = stmt.executeQuery("SELECT salary FROM staff_data WHERE id = " + staffId + ";");

            if (!table.next()) {
                // Staff ID not found in the database
                System.out.println("\nStaff Id Not Found -");
                return -1;
            }
            else {
                // Return the current salary
                return table.getInt(1);
            }
    
        }

        catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("\nSQLException Occurred -");
            return -2;
        }
    }

    void decrementSalary(int staffId, int decrementalValue) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
    
            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();
    
            // Get the current salary for the specified staff member
            int oldSalary = getSalary(staffId);
    
            if (oldSalary == -1) {
                // Staff ID not found
                System.out.println("\nStaff ID not found.");
                return;
            }
    
            int newSalary = oldSalary - decrementalValue;
    
            if (newSalary <= 0) {
                // Check if the new salary would be zero or negative
                System.out.println("\nAfter Decrement Salary = " + newSalary + "\nSalary Cannot Be Zero Or Negative");
                return;
            }
    
            // Update the salary in the database
            int rowsUpdated = stmt.executeUpdate("UPDATE staff_data SET salary = " + newSalary + " WHERE id = " + staffId + ";");
    
            if (rowsUpdated == 1) {
                // Salary updated successfully
                System.out.println("\nSalary Decremented Successfully\nNew Salary = " + newSalary);
            } else {
                // Failed to update salary
                System.out.println("\nSalary Cannot Be Decremented");
            }
    
            // Close the database resources
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle any SQLExceptions that may occur
            System.out.println("\nSQLException Occurred - " + e.getMessage());
        }
    }    
}