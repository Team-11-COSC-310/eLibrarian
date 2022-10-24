import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//Login class will contain every data which needs for authentication of user.
//From user input, this class check user account data from database and send authentication for users to go to main menu. 
public class Login extends connecttodb{
	private String UserEmail;
	private String UserPassword;
	private boolean authentication;
	Scanner reader = new Scanner(System.in);

	// This constructor suggests users enter their email and password. This also
	// check if this user has already account or not.
	// If they have, return T, if not, F.
	public Login(int attempt, String uname) throws SQLException {
		// Ask input from user
		if (attempt == 1) { //blank slate
			System.out.println("Please enter your email: ");
			setEmail(reader.next());
			System.out.println("Please enter your Password: ");
			setPassword(reader.next());
		} else if (attempt == 2) { //incorrect password but right username
			setEmail(uname); //store correct username
			System.out.println("Please re-enter your Password: ");
			setPassword(reader.next());
		} else if (attempt == 3) { //email is incorrect OR already in use
			System.out.println("Please enter a different Email: ");
			setEmail(reader.next());
			System.out.println("Please enter your Password: ");
			setPassword(reader.next());
		}
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
	public boolean HasEmail() throws SQLException, ClassNotFoundException {
		// get password from input by getPassword function and get resultSet.
		String uEmail = getEmail();
		ResultSet r = getResultSet("select * from users");
		// Use while loop to check existence until the end of the email column
		while (r.next()) {
			if (r.getString("email").equals(uEmail)) {
				return true;
			}
		}
		return false;
	}
	// check if this login session's email is in the database
	public boolean HasAdminEmail() throws SQLException, ClassNotFoundException {
		// get password from input by getPassword function and get resultSet.
		String uEmail = getEmail();
		ResultSet r = getResultSet("select * from librarians");
		// Use while loop to check existence until the end of the email column
		while (r.next()) {
			if (r.getString("email").equals(uEmail)) {
				return true;
			}
		}
		return false;
	}

	// Ask this login session's password
	public String getPassword() {
		return UserPassword;
	}

    // set this login session's password (input from user)
	public String setPassword(String pass) {
		return this.UserPassword = pass;
	}

	// check if this login session's password is in the database
	public boolean HasPassword() throws SQLException, ClassNotFoundException {
		// get password from input by getPassword function and get resultSet.
		String uPassword = getPassword();
		ResultSet r = getResultSet("select * from users");
		// Use while loop to check existence until the end of the password column
		while (r.next()) {
			if (r.getString(2).equals(uPassword)) {
				return true;
			}
		}
		System.out.println("The password you have entered is incorrect.");
		return false;
	}

	// check if this login info match with the database info
	public boolean HasRegistry() throws SQLException, ClassNotFoundException {
		if (HasAdminEmail() && HasPassword()) {
			return this.authentication = true; //authenticates if admin logs in ONLY USED BY ADMIN SCREEN
		}
		else if (HasEmail() && HasPassword()) { //authenticates if anyone logs in
			return this.authentication = true;
		} else {
			return this.authentication = false;
		}
	}

}
