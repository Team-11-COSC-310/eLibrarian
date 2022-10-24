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
	Scanner input = new Scanner(System.in);
	
     public LibrarianAction(int att, String uname) throws SQLException, ClassNotFoundException {
		super(att, uname);
		System.out.println("Hello, How can I help you?: 'Add' or 'Edit' ");
		in = input.nextLine();
		if(in.equals("Add")) {
			AddBook();
		}else if(in.equals("Edit")) {
			EditBook();
		}else {
			return;
		}
	}
    
	//it is called when the user turned out a librarian
	//This class allows the user to add book and edit book from database
	public void AddBook() throws ClassNotFoundException, SQLException {
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
        System.out.println("Tell me the book's details to add:");
        System.out.println("Enter the title:");
        setBookname(input.nextLine());//set title to the inputted string
        stmt.setString(1, getBookname());//set DATABASE title to the inputted string

        System.out.println("Enter the author:");
        setAuthor(input.nextLine());//set author to the inputted string
        stmt.setString(2, getAuthor());//set DATABASE author to the inputted string

        System.out.println("Enter the summary (in one line):");
        setContent(input.nextLine());//set description to the inputted string
        stmt.setString(3, getContent());//set DATABASE content to the inputted string

        stmt.setBoolean(4, true); //availability DEFAULT to available
        stmt.setInt(5,0); //DEFAULT waitlist to 0 people
        stmt.executeUpdate();
	}
	
	public void EditBook() throws ClassNotFoundException, SQLException {
		System.out.println("Select your editing action: Enter 'Delete' to delete a book.");
        in2 = input.nextLine();//Get input
		if(in2.equals("Delete")) {//if input equals delete
		    System.out.println("Enter the name of the book you want to delete: ");
		    setBookname(input.nextLine());
			while (HasBook(getBookname())) { //if that name exists then delete it from the db.
                String sql = "Delete from books where title = '"+getBookname()+"'";
			    PreparedStatement stmt = getConnect().prepareStatement(sql);
				
			    stmt.executeUpdate();
			    System.out.println(getBookname()+" was deleted from database.");
            }
		}
		return;
	}
    // check if this book is in the database
	public boolean HasBook(String input) throws SQLException, ClassNotFoundException {
		// get title from input by getBookname function and get resultSet.
		String uinput = input;
		ResultSet r = getResultSet("select * from books");//get all books
		// Use while loop to check existence until the end of the title column
		while (r.next()) { 
			if (r.getString("title").equals(uinput)) {//check all titles
				return true; //if input MATCHES TITLE in database
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
}
