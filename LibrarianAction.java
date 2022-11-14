import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarianAction extends Login{
	private String bookname;
	private String id;
	private String author;
	private String content;
	public String in;
    public String in2;
	private String userEmail;
	private String userPassword;
	private int cAttempt;
	Scanner input = new Scanner(System.in);
	 public LibrarianAction(){
		//Empty constructor
	 }
	 
     public LibrarianAction(int att, String uname) throws SQLException, ClassNotFoundException {
		super(att, uname);
	}
     
	//it is called when the user turned out a librarian
	//This class allows the user to add book and edit book from database
	public boolean AddBook(String title,String author,String summary, Boolean availability, int wl) throws ClassNotFoundException, SQLException {
		if(!title.isEmpty()&&!author.isEmpty()&&!summary.isEmpty()&&availability !=null&&wl>=0) {
		try {
			String idsql = "Select count(id) as ids from books";
        	ResultSet r = getResultSet(idsql);//count how many ids there are, so that adding a new book just increments them by one
        	int info = 0;
			// Use while loop to store the count of ids in a string
			while (r.next()) { 
				info = r.getInt("ids");// add count of ids
        	} 
        	info += 4;//add 4 in order to increment the value each time a book is added outside of while loop
			
			String sql = "insert books(title,author,summary,availability,wl)"+"values(?,?,?,?,?)";
			PreparedStatement stmt = getConnect().prepareStatement(sql); //dont need id beacue it should auto increment

        	setId(String.valueOf(info));//set Id to count of ids plus 1
          	setBookname(title);//set title to the inputted string
        	stmt.setString(1, getBookname());//set DATABASE title to the inputted string

        	
        	setAuthor(author);//set author to the inputted string
        	stmt.setString(2, getAuthor());//set DATABASE author to the inputted string

        	
        	setContent(summary);//set description to the inputted string
        	stmt.setString(3, getContent());//set DATABASE content to the inputted string

        	stmt.setBoolean(4, availability); //availability DEFAULT to available
        	
        	stmt.setInt(5,wl); //DEFAULT waitlist to 0 people
        	stmt.executeUpdate();
        	return true;
		}catch(ClassNotFoundException SQLException) {
			return false;
		}}else {return false;}
	}
	
	public boolean EditBook(String title) throws ClassNotFoundException, SQLException {
		
		try {
		    setBookname(title);
			while (HasBook(getBookname())) { //if that name exists then delete it from the db.
                String sql = "Delete from books where title = '"+getBookname()+"'";
			    PreparedStatement stmt = getConnect().prepareStatement(sql);
				
			    stmt.executeUpdate();
			    System.out.println(getBookname()+" was deleted from database.");
            }
		//}
		   return true;
		}catch(Exception e) {
			return false;
		}
	}
    // check if this book is in the database
	public boolean HasBook(String input) throws SQLException, ClassNotFoundException {
		// get title from input by getBookname function and get resultSet.
		String uinput = input;
		if(!input.isBlank()) {
		ResultSet r = getResultSet("select * from books");//get all books
		// Use while loop to check existence until the end of the title column
		while (r.next()) { 
			if (r.getString("title").equals(uinput)) {//check all titles
				return true; //if input MATCHES TITLE in database
			}
		}
		return false;
		}else {return false;}
	}
	public void UpdateUser() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the name of the librarian/user account you want to update: ");
		setUserEmail(input.nextLine());//Get input
		if(HasAdminEmail()) { //if that name exists then update it from the db.
			System.out.println("Enter the password to update " + getUserEmail() +": ");
			setUserPassword(input.nextLine());//Get input
			String sql = "Update librarians set password = '" + getUserPassword() + "' where email = '"+ getUserEmail()+"'";
			PreparedStatement stmt = getConnect().prepareStatement(sql);

			stmt.executeUpdate();

			String sql2 = "Update users set password = '" + getUserPassword() + "' where email = '"+ getUserEmail()+"'";
			PreparedStatement stmt2 = getConnect().prepareStatement(sql2);

			stmt2.executeUpdate();
			System.out.println(getUserEmail()+" was updated from database.");
			in2 = "Librarian";
		} else if(HasEmail()) { //if that name exists then update it from the db.
			System.out.println("Enter the password to update " + getUserEmail() +": ");
			setUserPassword(input.nextLine());//Get input
			String sql = "Update users set password = '" + getUserPassword() + "' where email = '"+ getUserEmail()+"'";
			PreparedStatement stmt = getConnect().prepareStatement(sql);
					
			stmt.executeUpdate();
			System.out.println(getUserEmail()+" was updated from database.");
			in2 = "User";
		} else {}
		return;
	}
	public boolean DeleteUser(String email) throws ClassNotFoundException, SQLException{
		
		
		setUserEmail(email);//Get input
		if(HasLibrarianEmail()) { //if that name exists then delete it from the db.
			String sql = "Delete from users where email = ?";
			PreparedStatement stmt = getConnect().prepareStatement(sql);
		    stmt.setString(1, getUserEmail());
			stmt.executeUpdate();
			System.out.println(getUserEmail()+" was deleted from database.");
			in2 = "Librarian";
			return true;
		} else if(HasEmail()) {//if that name exists then delete it from the db.
			String sql = "Delete from users where email = ?";
			PreparedStatement stmt = getConnect().prepareStatement(sql);
			stmt.setString(1, getUserEmail());
			stmt.executeUpdate();
			System.out.println(getUserEmail()+" was deleted from database.");
			in2 = "User";
			return true;
		} else {
			return false;
		}
		
		
	}
	public boolean HasEmail() throws SQLException, ClassNotFoundException {
		// get title from input by getUsername function and get resultSet.
		
		ResultSet r = getResultSet("select * from users");//get all users
		// Use while loop to check existence until the end of the title column
		while (r.next()) { 
			if (r.getString("email").equals(getUserEmail())) {//check all emails
				return true; //if input MATCHES EMAILS in database
			}
		}
		return false;
	}
	public boolean HasLibrarianEmail() throws SQLException, ClassNotFoundException {
		// get title from input by getUsername function and get resultSet.
		
		ResultSet r = getResultSet("select * from librarians");//get all librarians
		// Use while loop to check existence until the end of the title column
		while (r.next()) { 
			if (r.getString("email").equals(getUserEmail())) {//check all emails
				return true; //if input MATCHES EMAILS in database
			}
		}
		return false;
	}
		
    public String getBookname() {
    	return bookname;
    }
		
	public void setBookname(String bb) {
		this.bookname = bb;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String a) {
		this.author = a;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String s) {
		this.content=s;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}