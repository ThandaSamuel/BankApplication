/*
 * Logic package is responsible for rules.
 * It exists in the middle between GUI and Database.
 */
package Logic;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Database.ClientDB;

public class RegistrationLogic {
	static Connection con;
	/*
	 * Connection to the database.
	 */
	public static void startConnection() {
		try {
		 con = ClientDB.dbConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * When the user add information for registration, the function adds those into database.
	 */
		
	public static void insertCustomerData (String UserName,  String password, String name, String email) {
		startConnection();
		try {
			if (valideIfUserExists(UserName)== true) {
			JOptionPane.showMessageDialog(null, "The account already exists with the same name.");
			}
		else {
		String insertQuery = "INSERT INTO account values('" + UserName + " ','  " + password +" ',' " + name + "','" + email + "') " ;
		Statement sta = con.createStatement();
		int x = sta.executeUpdate(insertQuery); 
		JOptionPane.showMessageDialog(null, "The account is registered.");}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
	/*
	 * The function checks if the same user exists in the database.
	 */
	public static boolean valideIfUserExists(String userName) {
		startConnection();
		boolean find = false;
		ResultSet result;
		try {
			String validateUser = "SELECT * from account where TRIM(username)= '"+ userName+"' ; "; 
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(validateUser); 
		
			if(result.next()) {
				find = true; }
			}
			
		catch(Exception e) {
			System.out.print(e);
		}
		
		return find;
	}
	
	/*
	 * This function builds a table with user name and initializes the balance in the account as 0.
	 */
	public static void initializeBalance (String userName, double initial, double withdrawn, double balance) {
		startConnection();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate date = LocalDate.now();
		String localDate = date.format(dateFormatter);
		LocalTime time = LocalTime.now();
		String localTime = time.format(timeFormatter);
		 initial = 0;
		 withdrawn = 0;
		 balance=0;
		String initializeTable = "CREATE Table "+ userName + "( Date date, Time time, Amount_added double precision,"
															+ "Amount_withdrawn double precision,"
															+ "Balance double precision);";
		
		String addValue = "INSERT INTO " + userName+" VALUES ('" + localDate + "','" + localTime + "',"+ initial +","+ withdrawn +","+ balance +");";
		
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate(initializeTable);
			sta.executeUpdate(addValue);
							
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	/*
	 * This function is used for changing balance (deposit or withdrawal).
	 */
	public static void changeBalance (String userName, double initial, double withdrawn, double balance) {
		startConnection();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate date = LocalDate.now();
		String localDate = date.format(dateFormatter);
		LocalTime time = LocalTime.now();
		String localTime = time.format(timeFormatter);
			
		String addValue = "INSERT INTO " + userName+" VALUES ('" + localDate + "','" + localTime + "',"+ initial +","+ withdrawn +","+ balance +");";
		
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate(addValue);
							
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}
