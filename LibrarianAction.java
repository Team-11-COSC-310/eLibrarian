import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarianAction extends Login{
	private String bookname;
	private int id;
	private String author;
	private String content;
	private String waitlist;
	private String in;
	Scanner input = new Scanner(System.in);
	
     public LibrarianAction() throws SQLException, ClassNotFoundException {
		super();
		System.out.println("Hello, How can I help you?: 'Add' or 'Edit' ");
		in = input.next();
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
		System.out.println("Tell me your book to add:");
		String sql = "insert books(id,title,author,summary,availability,wl)"+"values(?,?,?,?,?,?)";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        System.out.println("Enter the id:");
        setId(input.nextInt());
        stmt.setInt(1, getId());
        System.out.println("Enter the title:");
        setBookname(input.next());
        stmt.setString(2, getBookname());
        System.out.println("Enter the author:");
        setAuthor(input.next());
        stmt.setString(3, getAuthor());
        System.out.println("Enter the content:");
        setContent(input.next());
        stmt.setString(4, getContent());
        stmt.setBoolean(5, true); //availability
        stmt.setInt(6,0);
        stmt.executeUpdate();
	}
	
	public void EditBook() throws ClassNotFoundException, SQLException {
		System.out.println("Select your editing action: 'Delete'");
		if(input.next().equals("Delete")) {
		System.out.println("Enter your book name you want to delete: ");
		setBookname(input.nextLine());
				String sql = "Delete from books"+"where title = "+getBookname();
				PreparedStatement stmt = getConnect().prepareStatement(sql);
				
				stmt.executeUpdate();
				System.out.println("it is deleted from database");
			}
			return;
		}
		
    public String getBookname() {
    	return bookname;
    }
		
	public void setBookname(String bb) {
		this.bookname = bb;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		this.id = i;
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
