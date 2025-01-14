/*
 * Logic package is responsible for rules.
 * It exists in the middle between GUI and Database.
 */
package Logic;

import java.sql.ResultSet;
import java.sql.*;

import Database.ClientDB;
/*
 * LogIn class validates the log in user and password for logging in.
 * It compares data from user's input and data from database.
 */
public class LogIn {
	
	public static boolean validateLogin(String userName, String password) {
		boolean find = false;
		ResultSet result;
		Connection con = null;
		try {
			con = ClientDB.dbConnection();
			String validateUser = "SELECT * from account where TRIM(username)= '"+ userName+"' and TRIM(password)= '" + password + "' ; "; 
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(validateUser); 
			System.out.println(result);
			if(result.next()) {
				find = true; }}
		catch(Exception e) {
			System.out.print(e);
		}
			
		return find;
		
	}
}
