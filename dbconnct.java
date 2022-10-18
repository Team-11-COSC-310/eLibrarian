
import java.sql.*;
import java.io.*;

public class dbconnct {
	
	public static void main (String[] args) throws SQLException {
		Login l1 = new Login();
		if(l1.HasRegistry()) {
			System.out.println("Login Success!");
		}else {
			System.out.println("No account matched...");
		}
	}
	
	public Connection dbc() throws SQLException{

		String url = "jdbc:mysql://127.0.0.1:3306/CheckConnection";
		String username = "root";
		String password ="kkato41496746";
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}
