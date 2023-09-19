import java.sql.*;

public class Staff {
	void changePassword(String staff_id,String oldPassword,String newPassword){
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/krishna_medical_store", "root", "");
			
			Statement stmt = conn.createStatement();

			ResultSet table = stmt.executeQuery("SELECT * FROM staff_login WHERE staff_id = " + staff_id + ";");

			if(!table.next()){
				System.out.println("\nStaff Member Not Found ( Staff Id Not Found ) -");
			}
			else{
				if(table.getString(2).equals(oldPassword)){

					if(stmt.executeUpdate("UPDATE staff_login SET password = " + newPassword + " WHERE staff_id = " + staff_id + ";") == 1){
						System.out.println("\nPassword Updated Successfully -");
					}
					else{
						System.out.println("\nPassword Cannot Be Changed -");
					}

				}
				else{
					System.out.println("\nOld Password Is Not Matched -");
				}
			}

		} catch (SQLException e) {
			System.out.println("\nSQLException Occured -");
		}	
	}
}