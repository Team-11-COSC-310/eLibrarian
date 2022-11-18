

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//TO do: 1, password encription and decode as well. 2, email varification check

//Login class will contain every data which needs for authentication of user.
//From user input, this class check user account data from database and send authentication for users to go to main menu. 
public class Login extends connecttodb{
	private String UserEmail;
	private String UserPassword;
	private boolean authentication;
	private boolean adminAuthentication = false; 
	public int Emailind;
	public int Passind;
	Scanner reader = new Scanner(System.in);
        public Login(){
            
        }
	// This constructor suggests users enter their email and password. This also
	// check if this user has already account or not. 
	// If they have, return T, if not, F.
	public Login(int attempt, String uname) throws SQLException, ClassNotFoundException {
                 
		// Ask input from user
		if (attempt == 1) { //blank slate
			System.out.println("Please enter your email: ");
			setEmail(reader.next());
			//handles invalid email entry
			if(!EmailVerification()) { 
				InvalidEmailAction();
				}
		    System.out.println("Please enter your password");
		    setPassword(reader.next());
	 
		} else if (attempt == 2) { //incorrect password but right username
			setEmail(uname); //store correct username
			System.out.println("Forgot password?: y or n");
			if(reader.next().equals("y")) {
				System.out.println("Would you like to reset your password?: yes or no");
				PasswordResetAction(reader.next());
			}else {
	            System.out.println("Please re-enter your Password: ");
	            setPassword(reader.next());}
			
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
				//System.out.println(r.getRow());

				EmailindSet(r.getRow());
				return true;
			}
			//System.out.println(r.getRow());
		}
		return false;
	}
	// check if this login session's email is in the database
	public boolean HasAdminEmail() throws SQLException, ClassNotFoundException {
		
		// get password from input by getPassword function and get resultSet.
		String uEmail = getEmail();
		//since this retrieves the data from librarian table, row count starts from 1, which makes unmatched login
		ResultSet r = getResultSet("select * from librarians");
	    
		// Use while loop to check existence until the end of the email column
		while (r.next()) {
			if (r.getString(1).equals(uEmail)) {
				EmailindSet(r.getRow());
				adminAuthentication = true; 
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
		int j =1;
		// get password from input by getPassword function and get resultSet.
		String uPassword = PasswordEncryption(getPassword());
		ResultSet r = getResultSet("select * from users");
		// Use while loop to check existence until the end of the password column
		while (r.next()) {
			if (r.getString(2).equals(uPassword)) {
				PassindSet(r.getRow());
				return true;
			}
			
		}
		return false;
	}
        public boolean HasAdminPassword( ) throws SQLException, ClassNotFoundException{
            int j =1;
		// get password from input by getPassword function and get resultSet.
		String uPassword = PasswordEncryption(getPassword());
		ResultSet r = getResultSet("select * from librarians");
		// Use while loop to check existence until the end of the password column
		while (r.next()) {
			if (r.getString(2).equals(uPassword)) {
				PassindSet(r.getRow());
				return true;
			}
		}
		return false;
        }
	//check the index of table from database for checking password and email matching
	public int EmailindSet(int ind) {
		return this.Emailind = ind;
	}
	public int PassindSet(int ind) {
		return this.Passind = ind;
	}
	public int EmailindGet() {
		return Emailind;
	}
	public int PassindGet() {
		return Passind;
	}
	//check the index matching
	public boolean indCheck() {
		if(EmailindGet()==PassindGet()) {
			return true;
		}else {
			System.out.println();
			return false;
		}
	}
        
	// check if this login info match with the database info
	public boolean HasRegistry() throws SQLException, ClassNotFoundException {
		if (HasAdminEmail() && HasAdminPassword()&&indCheck()) {
			return this.adminAuthentication = true; //authenticates if admin logs in ONLY USED BY ADMIN SCREEN
		}else if (HasEmail() && HasPassword()&&indCheck()) { //authenticates if anyone logs in
			return this.authentication = true;
		} else {
			return this.authentication = false;
		}
	}
	//verifies user's email format briefly
	public boolean EmailVerification() {
		String email = getEmail();
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	//handles invalid email error. Asks to re-try until they enter a valid one
	public void InvalidEmailAction() {
		while(!EmailVerification()) {
		System.out.println("Your email is invalid. Please re-enter your email: ");
		setEmail(reader.next());}
	}
	//password encription function. This returns encripted version of password.
	public String PasswordEncryption(String pass) {
		String password = pass;
		String encryptedPassword = null; 		
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes());
			//convert the hash value into bytes
			byte[] bytes = m.digest();
			//the bytes array has bytes in decimal form. Converting it into hexadecimal format. 
			StringBuilder s = new StringBuilder();
			
			for(int i = 0;i<bytes.length;i++) {
				s.append(Integer.toString((bytes[i]& 0xff)+ 0x100,16).substring(1));
			}
			encryptedPassword = s.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
		return encryptedPassword;
	}
	//password should be different from the previous one, also the user should have useremail in database
	public String PasswordReset(String pass) throws ClassNotFoundException, SQLException {
		if(HasEmail()&&pass!=getPassword()) {
			String pd =pass;
			
			
			pd = PasswordEncryption(pd);
			
			 String sql = "update users set password = ?"+" where email = ?";
	        PreparedStatement stmt = getConnect().prepareStatement(sql);
            stmt.setString(1, pd);
            stmt.setString(2, getEmail());
	        stmt.executeUpdate();
	        setPassword(pass);
	        System.out.println("Your password is updated!");
	        return pass;
		}else {
			System.out.println("Password Reset stopped....");
			return getPassword();
		}
		
			}
	public void PasswordResetAction(String answer) throws ClassNotFoundException, SQLException {
		if(answer.equals("yes")) {
			System.out.println("Enter your new password: ");
			PasswordReset(reader.next());
		}else if(answer.equals("no")) {
			return;
		}
		return;
	}
	
        public boolean getAdminAuthentification(){
            return this.adminAuthentication;
        }
        
        public boolean getAuthentification(){
            return this.authentication;
        }
	
	
}
