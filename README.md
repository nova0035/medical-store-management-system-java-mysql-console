# Medical Store Management System (Console Application)

A simple console-based Medical Store Management System implemented in Java with a MySQL database backend. This system allows users to manage staff members, medicines, and stock data for a medical store.

## Features

- **Staff Member Management**: Add new staff members with their details, including ID, name, contact information, and salary.
- **Staff Login**: Staff members can log in with their ID and password for authentication.
- **Medicine Management**: Add new medicines to the stock database, including details such as manufacturer name, medicine name, power, price per tablet, and quantity.
- **Display Medicine Data**: View all medicine data in a tabular format, including manufacturer name, medicine name, power, price per tablet, and quantity.
- **Admin Menu**: Administrators can access additional features including changing passwords for staff members, adding new medicines, showing all medicine data, adding new staff members, removing staff members, searching for medicine data, and incrementing staff member salaries.

This extended feature set provides administrators with enhanced control and management capabilities for the medical store.


## Technologies Used

- **Java**: The core programming language for the console application.
- **MySQL**: Used as the database management system to store staff and medicine data.
- **JDBC**: Java Database Connectivity for connecting and interacting with the MySQL database.

## Setup and Usage

1. **Database Setup**: Ensure you have MySQL installed on your system. Create a database named "krishna_medical_store" and configure the connection details in your Java code.

2. **Compile**: Compile the Java code using your preferred Java development environment or the command line.

3. **Run**: Execute the compiled Java program to launch the console application.

4. **Main Menu**: Upon running the program, you will see a main menu with options to log in as a staff member or an admin, or exit the program.

5. **Staff Member Login**: Staff members can log in using their ID and password to access the staff menu, where they can change their passwords.

6. **Admin Login**: Admins can log in using their ID and password to access the admin menu, where they can manage staff members and medicines, including adding new entries and viewing medicine data.

## Usage Examples

- **Add a New Staff Member**: Enter the staff member's details, including ID, password, name, contact information, and salary.
- **Add a New Medicine**: Enter medicine details, including manufacturer name, medicine name, power, price per tablet, and quantity.

Feel free to modify and expand this README to include any additional instructions, features, or usage examples as needed for your application.
