# Medical Store Management System (Console Application)

![Medical Store](medical_store_image.png)

A simple console-based Medical Store Management System implemented in Java with a MySQL database backend. This system allows users to manage staff members, medicines, and stock data for a medical store.

## Features

- **Staff Member Management**: Add new staff members with their details, including ID, name, contact information, and salary.
- **Staff Login**: Staff members can log in with their ID and password for authentication.
- **Medicine Management**: Add new medicines to the stock database, including details such as manufacturer name, medicine name, power, price per tablet, and quantity.
- **Display Medicine Data**: View all medicine data in a tabular format, including manufacturer name, medicine name, power, price per tablet, and quantity.

## Technologies Used

- **Java**: The core programming language for the console application.
- **MySQL**: Used as the database management system to store staff and medicine data.
- **JDBC**: Java Database Connectivity for connecting and interacting with the MySQL database.

## Setup and Usage

1. **Database Setup**: You need to have MySQL installed on your system. Create a database named "krishna_medical_store" and configure the connection details in your Java code.

2. **Compile**: Compile the Java code using your preferred Java development environment or the command line.

3. **Run**: Execute the compiled Java program to launch the console application.

4. **Main Menu**: Upon running the program, you will see a main menu with options to log in as a staff member or an admin, or exit the program.

5. **Staff Member Login**: Staff members can log in using their ID and password to access the staff menu, where they can change their passwords.

6. **Admin Login**: Admins can log in using their ID and password to access the admin menu, where they can manage staff members and medicines, including adding new entries and viewing medicine data.

## Usage Examples

- Add a new staff member: Enter the staff member's details, including ID, password, name, contact information, and salary.
- Add a new medicine: Enter medicine details, including manufacturer name, medicine name, power, price per tablet, and quantity.

## Screenshots

![Login Menu](login_menu.png)
![Staff Menu](staff_menu.png)
![Admin Menu](admin_menu.png)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

