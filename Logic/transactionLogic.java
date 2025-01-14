package Logic;
/*
 * Logic package is responsible for rules.
 * It exists in the middle between GUI and Database.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.ClientDB;
/*
 * This class checks activities related to Transaction.
 */

public class transactionLogic {
	static Connection con = null;
	
	/*
	 * This method starts the connection to database.
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
	 * This method displays the user's transaction history that is stored in database.
	 */
	public static void showTransaction(String userName, DefaultTableModel model) {
		ResultSet result;
		startConnection();
			
		try {
		Statement st = con.createStatement();
		String showQuery = "SELECT * from " + userName + " ;";
		result = st.executeQuery(showQuery);
		ResultSetMetaData metaData = result.getMetaData();
		int column = metaData.getColumnCount();
		String []colName = new String[column];
		
		for (int i =0; i <column; i++) {
			colName[i]=metaData.getColumnName(i+1);
		}
		
		model.setColumnIdentifiers(colName);
		String Date, Time, Added_Amount, Withdrawn_Amount, Balance;
		while(result.next()) {
			Date = result.getString(1);
			Time = result.getString(2);
			Added_Amount = result.getString(3);
			Withdrawn_Amount =result.getString(4);
			Balance= result.getString(5);
			String[]row = {Date,Time,Added_Amount,Withdrawn_Amount,Balance};
			model.addRow(row);
		}
		result.close();
		con.close();
	}
		catch(Exception e) {
			e.printStackTrace();
	}
}
	
	/*
	 * showBalance method displays balance from database when the user needs to.
	 */
	public static String showBalance(String userName) {
		startConnection();
		ResultSet result;
		String data ="";
		try {
			
			String balanceQuery = "SELECT balance FROM " + userName +" ORDER BY date DESC, time DESC LIMIT 1;";
			Statement sta = con.createStatement();
			result = sta.executeQuery(balanceQuery);
			if (result.next()==true) {
				 data = result.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*
	 * withdrawlBalance method is called when the user wants to withdraw.
	 */
	
	public static void withdrawlBalance (String userName, Double wantToWithdrawl) {
		startConnection();
		ResultSet result;
		String balanceString ="";
		Double balance;
		try {
		
		String checkBalance = "SELECT balance FROM " + userName +" ORDER BY date DESC, time DESC LIMIT 1;";
		Statement sta = con.createStatement();
		result = sta.executeQuery(checkBalance);
		if (result.next()==true) {
			balanceString = result.getString(1);
		}
		balance = Double.parseDouble(balanceString);
				
		if (remainBalance(balance,wantToWithdrawl)==true) {
					
			RegistrationLogic.changeBalance(userName, 0, wantToWithdrawl, (balance- wantToWithdrawl));
			JOptionPane.showMessageDialog(null, wantToWithdrawl + "$ was withdrwan from your account.");
		}
		else {
			JOptionPane.showMessageDialog(null, "You don't have sufficient fund.");
		}
			
	}
		catch (Exception e) {
			e.printStackTrace();
		}
}
	
	/*
	 * Check if the balance is enough to withdraw.
	 */
	public static boolean remainBalance(double balance, double withdrawn) {
		boolean balanceRemain = false;
		if (balance - withdrawn >= 1) {
			balanceRemain = true;
		}
		return balanceRemain;
	}
	
	/*
	 * addBalance method is called when the user wants to deposit.
	 */
	
	public static void addBalance (String userName, Double deposit) {
	    startConnection();
		ResultSet result;
		String balanceString="";
		Double balance;
		
		try {
	
		String checkBalance = "SELECT balance FROM " + userName +" ORDER BY date DESC, time DESC LIMIT 1;";
		Statement sta = con.createStatement();
		result = sta.executeQuery(checkBalance);
		if (result.next()==true) {
			balanceString = result.getString(1);
		}
		balance = Double.parseDouble(balanceString);
				
		RegistrationLogic.changeBalance(userName, deposit, 0, (balance+deposit));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
