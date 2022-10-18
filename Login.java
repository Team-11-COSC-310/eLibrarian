import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Login class will contain every data which needs for authentication of user.
//From user input, this class check user account data from database and send authentication for users to go to main menu. 
public class Login {
	private String UserEmail;
	private String UserPassword;
	private boolean authentication;
	Scanner reader = new Scanner(System.in);

	// This constructor suggests users enter their email and password. This also
	// check if this user has already account or not.
	// If they have, return T, if not, F.
	public Login() throws SQLException {
			// Ask input from user
		System.out.println("what is your Email: ");
		setEmail(reader.next());
		System.out.println("What is your Password: ");
		setPassword(reader.next());
	if(HasRegistry()) {
		System.out.println("Login Success!");
		}else {
			System.out.println("No account matched...");
		}
	}

	// get database connection
	public Connection getConnect() throws SQLException {
		dbconnct conn_o = new dbconnct();
		Connection conn = conn_o.dbc();
		return conn;
	}

	// get ResultSet from database with query
	public ResultSet getResultSet() throws SQLException {
		Statement stmt = getConnect().createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		return rs;
	}

	// get this login session's email
	public String getEmail() {
		return UserEmail;
	}

	// set this login session's email (input from user)
	public String setEmail(String Eml) {
		return this.UserEmail = Eml;
	}

	// check if this login session's email is in the database
	public boolean HasEmail() throws SQLException {
		// get password from input by getPassword function and get resultSet.
		String uEmail = getEmail();
		ResultSet r = getResultSet();
		// Use while loop to check existence until the end of the email column
		while (r.next()) {
			if (r.getString("email").equals(uEmail)) {
				return true;
			}
		}
		System.out.println("email not found!");
		return false;
	}

	// Ask this login session's password
	public String getPassword() {
		return UserPassword;
	}
	
        // Set this session's password data (user's input)
	public String setPassword(String pass) {
		return this.UserPassword = pass;
	}

	// check if this login session's password is in the database
	public boolean HasPassword() throws SQLException {
		// get password from input by getPassword function and get resultSet.
		String uPassword = getPassword();
		ResultSet r = getResultSet();
		// Use while loop to check existence until the end of the password column
		while (r.next()) {
			if (r.getString("password").equals(uPassword)) {
				return true;
			}
		}
		System.out.println("password not found!");
		return false;
	}

	// check if this login info match with the database info
	public boolean HasRegistry() throws SQLException {
		if (HasEmail() && HasPassword()) {
			return this.authentication = true;
		} else {
			return this.authentication = false;
		}
	}

}




