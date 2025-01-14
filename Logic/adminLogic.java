package Logic; 
/*
 * Logic package is responsible for rules.
 * It exists in the middle between GUI and Database.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import Database.ClientDB;

/*
 * adminLogic is responsible for showing account table to admin.
 * It gets data from database.
 */
public class adminLogic {
	public static void showTable(DefaultTableModel model) {
		ResultSet result;
		Connection con = null;
	
	     try {
	    	 con = ClientDB.dbConnection();
	    	 Statement st = con.createStatement();
			String showQuery = "select * from account";
			result = st.executeQuery(showQuery);
			ResultSetMetaData metaData = result.getMetaData();
			int column = metaData.getColumnCount()	;
			String[] colName = new String [column] ;
			for (int i =0; i <column; i++) {
				colName[i]=metaData.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			String userName, password, name, email;
			while(result.next()) {
				userName=result.getString(1);
				password= result.getString(2);
				name = result.getString(3);
				email=result.getString(4);
				String[]row = {userName,password,name,email};
				model.addRow(row);
			}
			result.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
