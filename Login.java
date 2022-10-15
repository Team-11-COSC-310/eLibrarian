import java.util.Scanner;
//Login class will contain every data which needs for authentication of user.
//From user input, this class check user account data from database and send authentication for users to go to main menu. 
public class Login {
	private String UserEmail;
	private String UserPassword;
	private boolean authentication;
	Scanner reader = new Scanner(System.in);
	//This constructor suggests users enter their email and password. This also check if this user has already account or not. 
	//If they have, return T, if not, F. 
     public Login(){
    	 System.out.println("Enter your email: ");
    	 setEmail(reader.nextLine());
    	 System.out.println("Enter your password: ");
    	 setPassword(reader.nextLine());
     }
     
     //get this login session's email
     public String getEmail(){
    	 return UserEmail;
     }
     
     //set this login session's email
     public String setEmail(String Eml) {
    	 return this.UserEmail = Eml;
     }
     
     //check if this login session's email is in the database
     public boolean HasEmail() {
    	 return true;
     }
     
     //Ask this login session's password
     public String getPassword() {
    	 return UserPassword;
     }
     
     public String setPassword(String pass) {
    	 return this.UserPassword = pass;
     }
     
     //check if this login session's password is in the database
     public boolean HasPassword() {
    	 return true;
     }
     
     //check if this login info match with the database info
     public boolean HasRegistry() {
    	 if(HasEmail()&&HasPassword()) {
    		 return this.authentication = true;
    	 }else {
    		 return this.authentication = false;
    	 }
     }
     
     
}
