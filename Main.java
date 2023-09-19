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

                System.out.println("\nStaff Member Login");

                System.out.print("\nEnter Staff ID: ");
                int staffId = scanner.nextInt();

                System.out.print("Enter Password: ");
                String password = scanner.next();

                int reply = login.staffLogin(staffId, password);

                // Add conditions based on reply
                if (reply == 1) {
                    // Successful login
                    System.out.println("\nWelcome, Staff Member!");

                    int staffMenuChoice = -1;

                    do {

                        System.out.println("\nStaff Menu");
                        System.out.println("\n1. Change Password");
                        System.out.println("0. Exit");
                        System.out.print("\nSelect an option: ");
                        staffMenuChoice = scanner.nextInt();
            
                        if (staffMenuChoice == 1) {
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
                            System.out.println("\nExiting Staff Menu."); // if user choose 0 to exit staff menu
                        }

                        else {
                            System.out.println("\nInvalid choice. Please try again."); // if user enter number other than in menu
                        }

                    } while (staffMenuChoice != 0); // loop breaks if user enter 0 which means exiting staff menu

                }
                else if (reply == 0) {
                    // Incorrect password
                    System.out.println("\nPassword is incorrect.");
                }
                else if (reply == -1) {
                    // Staff ID not found
                    System.out.println("Staff ID not found.");
                }
                else if (reply == -2) {
                    // SQL exception occurred
                    System.out.println("An SQL exception occurred.");
                }

            } else if (mainMenuChoice == 2) {
                System.out.println("\nAdmin Login");
                // Implement admin login logic here
                // You can use a similar approach as for staff member login
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
