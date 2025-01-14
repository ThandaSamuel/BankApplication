package Database;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/*
 * ClientDB connects to the database. 
 */
public class ClientDB {
	private static Connection con = null;
	private static ResultSet result;
	DefaultTableModel model = new DefaultTableModel();
/*
 * dbConnection method connects to the postgresql database and returns back the the connection.	
 */
	public static Connection dbConnection () {
		String jdbcDriver = "org.postgresql.Driver";
		/*
		 * This url, user and password are for my local postgresql server.
		 */
		String url = "jdbc:postgresql://localhost:5432/customer";
		String user = "postgres";
		String password = "1234";
		
		/*
		 * This is for connecting to AWS cloud database server.
		 */
		String urlAWS = "jdbc:postgresql://bank.cvyey0yaqtgi.us-east-2.rds.amazonaws.com/postgres";
		String userAWS= "postgres";
		String passwordAWS= "####";
		
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(urlAWS, userAWS, passwordAWS);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
