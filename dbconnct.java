
import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class dbconnct {
	
	public static void main (String[] args) throws SQLException {
		if(HasAccount()) {
		   Login l1 = new Login();
		}else{
		   createaccount a1 = new createaccount();
		}
	}
	
	public static boolean HasAccount() {
		String b;
		System.out.println("Do you have library account?: y or n");
		Scanner c = new Scanner(System.in);
		b = c.next();
		if(b.equals("y")) {
			return true;
		}else {
			System.out.println("you dont have account...Try Register!!");
		    return false;
		}
	}
	
	public Connection dbc() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1:3306/LibMan";
		String username = "root";
		String password ="kkato41496746";
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}
