package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {
	public Map<String,String> getUserData(String emailId){

		Map<String, String> userData = new HashMap<String, String>();

		//Register Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}  

		//Create Connection Statement
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental?serverTimezone=UTC","teja","teja");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Create Statement
		Statement stmt = null;
		try {
			stmt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Create Result Set
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from tblusers where EmailId='"+emailId+"'");
			rs.next();
			userData.put("FullName", rs.getString(2));
			userData.put("ContactNo", rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		} 



		return userData;
	}
}
