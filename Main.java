import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mainMenuChoice;

        do {
            // Display the main menu
            System.out.println("\nMain Menu");
            System.out.println("\n1. Login As Staff Member");
            System.out.println("2. Login As Admin");
            System.out.println("0. Exit");

            // Prompt for user input
            System.out.print("\n_ : ");
            mainMenuChoice = scanner.nextInt();

            Login login = new Login();

            // Process user choice
            if (mainMenuChoice == 1) {
                // Staff Member Login
                System.out.println("\nStaff Member Login");

                System.out.print("\nEnter Staff ID: ");
                int staffId = scanner.nextInt();

                System.out.print("Enter Password: ");
                String password = scanner.next();

                int reply = login.staffLogin(staffId, password);

                // Handle login responses
                if (reply == 1) {
                    // Successful login
                    System.out.println("\nWelcome, Staff Member!");

                    int staffMenuChoice = -1;

                    do {
                        // Staff Menu
                        System.out.println("\nStaff Menu");
                        System.out.println("\n1. Change Password");
                        System.out.println("0. Exit");

                        System.out.print("\n_ : ");
                        staffMenuChoice = scanner.nextInt();

                        if (staffMenuChoice == 1) {
                            // Change Password
                            System.out.println("\nChange Password");

                            // Prompt for user input
                            System.out.print("Enter Your Staff Id : "); // input staff id
                            String id = scanner.next();

                            System.out.print("Enter Your Old Password : "); // input old password
                            String oldPassword = scanner.next();

                            System.out.print("Enter Your New Password : "); // input new password
                            String newPassword = scanner.next();

                            // Create a Staff object and call the changePassword method
                            Staff staff = new Staff();
                            staff.changePassword(id, oldPassword, newPassword);
                        }
                        else if (staffMenuChoice == 0) {
                            System.out.println("\nExiting Staff Menu."); // if the user chooses 0 to exit staff menu
                        }
                        else {
                            System.out.println("\nInvalid choice. Please try again."); // if the user enters a number other than in the menu
                        }

                    } while (staffMenuChoice != 0); // loop breaks if the user enters 0, which means exiting staff menu

                }
                else if (reply == 0) {
                    // Incorrect password
                    System.out.println("\nPassword is incorrect.");
                }
                else if (reply == -1) {
                    // Staff ID not found
                    System.out.println("\nStaff ID not found.");
                }
                else if (reply == -2) {
                    // SQL exception occurred
                    System.out.println("\nAn SQL exception occurred.");
                }

            } else if (mainMenuChoice == 2) {
                // Admin Login
                System.out.println("\nAdmin Login");

                System.out.print("\nEnter Admin ID: ");
                int staffId = scanner.nextInt();

                System.out.print("Enter Password: ");
                String password = scanner.next();

                int reply = login.adminLogin(staffId, password);

                // Handle admin login responses
                if (reply == 1) {
                    Stock stock = new Stock();
                    Admin admin = new Admin();
                    // Successful login
                    System.out.println("\nWelcome, Admin!");

                    int adminMenuChoice = -1;

                    do {
                        // Admin Menu
                        System.out.println("\nAdmin Menu");
                        System.out.println("\n1. Change Password");
                        System.out.println("2. Add New Medicine");
                        System.out.println("3. Show All Medicine Data");
                        System.out.println("0. Exit");

                        System.out.print("\n_ : ");
                        adminMenuChoice = scanner.nextInt();

                        if (adminMenuChoice == 1) {
                            // Change Password
                            System.out.println("\nChange Password");

                            // Prompt for user input
                            System.out.print("Enter Your Admin Id : "); // input admin id
                            String id = scanner.next();

                            System.out.print("Enter Your Old Password : "); // input old password
                            String oldPassword = scanner.next();

                            System.out.print("Enter Your New Password : "); // input new password
                            String newPassword = scanner.next();

                            // Create an admin object and call the changePassword method
                            admin.changePassword(id, oldPassword, newPassword);
                        }
                        else if (adminMenuChoice == 2) {
                            // Add New Medicine
                            System.out.println("\nAdd New Medicine");

                            System.out.println("\nEnter Manufacturer Name : ");
                            String manufacturer_name = scanner.nextLine();
                            manufacturer_name += scanner.nextLine();

                            System.out.print("\nEnter Medicine Name : ");
                            String medicine_name = scanner.nextLine();
                            medicine_name += scanner.nextLine();

                            System.out.print("\nEnter Power ( if don't have power enter '0' ) : ");
                            int power = scanner.nextInt();

                            System.out.print("\nEnter Price Per Tablet : ");
                            int price_per_tablet = scanner.nextInt();

                            System.out.print("\nEnter Total Quantity : ");
                            int quantity = scanner.nextInt();

                            // Modify the manufacturer name and medicine name by converting to lowercase and trimming spaces
                            String modifiedManufacturerName = manufacturer_name.toLowerCase().trim();
                            String modifiedMedicineName = medicine_name.toLowerCase().trim();

                            // Call the addNewMedicine method with the modified manufacturer name, modified medicine name, and other arguments
                            stock.addNewMedicine(modifiedManufacturerName, modifiedMedicineName, power, price_per_tablet, quantity);

                        }
                        else if (adminMenuChoice == 3){

                            System.out.println("\nAll Medicine Data");
                            stock.showAllMedicineData();

                        }
                        else if (adminMenuChoice == 0) {
                            System.out.println("\nExiting Admin Menu."); // if the user chooses 0 to exit admin menu
                        }
                        else {
                            System.out.println("\nInvalid choice. Please try again."); // if the user enters a number other than in the menu
                        }

                    } while (adminMenuChoice != 0); // loop breaks if the user enters 0, which means exiting admin menu
                }
                else if (reply == 0) {
                    // Incorrect password
                    System.out.println("\nPassword is incorrect.");
                }
                else if (reply == -1) {
                    // Admin ID not found
                    System.out.println("\nAdmin ID not found.");
                }
                else if (reply == -2) {
                    // SQL exception occurred
                    System.out.println("\nAn SQL exception occurred.");
                }

            }
            else if (mainMenuChoice == 0) {
                System.out.println("\nExiting the program. Goodbye!");
            } 
            else {
                System.out.println("\nInvalid choice. Please select a valid option (1/2/0).");
            }

        } while (mainMenuChoice != 0);

        scanner.close();
    }
}