import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class createaccount extends Login {
    private String userEmail;
	private String userPassword;
    
     public createaccount() throws SQLException {
		super();
		userEmail=super.getEmail();
		userPassword=super.getPassword();
		Register(userEmail,userPassword);
		System.out.println("Registration successed!");
	    }

    public void Register(String email, String password) throws SQLException{
        String sql = "insert into users(email, password)" + "values (?, ?)";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        stmt.executeUpdate();
        }
  }



