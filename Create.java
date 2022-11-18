
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create extends Login{
    private String userEmail;
	private String userPassword;
    private int cAttempt;
    
    public Create(int cattempt) throws SQLException, ClassNotFoundException {
		super(cattempt,null);//call to login function with blank slate

		userEmail=super.getEmail();
		userPassword=super.getPassword();
        if (super.HasEmail()){ //if the entered email matches one in databse already, dont add user and prompt to retry
            System.out.println("That email is already being used by an account.");
            cattempt = 3;
            setAttempt(cattempt);//store construct attempt # in variable to be seen by main app
        }
		else { //if the email doesn't match, then make new user. DON'T care about repeat passwords
            Register(userEmail,userPassword);//get login info and put it in database
            cattempt = 1; //reset create input
            setAttempt(cattempt);//store construct attempt # in variable to be seen by main app
        }
	}
    Create() {
         
    } 
    
   
    
    // get the attempt number from the super
	public int getAttempt() {
		return cAttempt;
	}
    // set attempt from constructor
	public int setAttempt(int Eml) {
		return this.cAttempt = Eml;
	}

    public boolean Register(String email, String password) throws SQLException, ClassNotFoundException{
    	
    	System.out.println("Try registering now...");
    	super.setEmail(email);
    	super.setPassword(password);
    	if(!HasRegistry()&&EmailVerification())
        try{
        String sql = "insert into users(email, password)" + "values (?, ?)";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, super.PasswordEncryption(password));
        stmt.executeUpdate();
        System.out.println("Registry success");
        return true;
        }catch(Exception e){
            return false;
        }else{return false;}}
     public boolean RegisterLibrarian(String email, String password) throws SQLException, ClassNotFoundException{
    	 System.out.println("Try registering now...");
    	 super.setEmail(email);
    	 super.setPassword(password);
    	 if(!HasRegistry()&&EmailVerification()) {
         try{
        	Register(email,password);
            String sql = "insert into librarians(email,password)" + "values (?,?)";
            PreparedStatement stmt = getConnect().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, super.PasswordEncryption(password));
            stmt.executeUpdate();
            System.out.println("Librarian registry success");
            return true;
         }catch(Exception e){
             return false;
         }
    	 }else {return false;}}
  }
