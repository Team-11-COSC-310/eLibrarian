import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class Search  extends connecttodb {
	private String UserSInput;
	Scanner reader = new Scanner(System.in);
    private boolean authentication;

    public Search() throws SQLException {
		// Ask input from user
		System.out.println("Title OR Author: ");
		setSInput(reader.nextLine());//store any string in the next line input in set
	}

	// get search input
	public String getSInput() {
		return UserSInput;
	}

	// set search input from user
	public String setSInput(String Eml) {
		return this.UserSInput = Eml;
	}

    // check if this book is in the database
	public boolean HasBook() throws SQLException, ClassNotFoundException {
		// get title from input by getSInput function and get resultSet.
		String uinput = getSInput();
		ResultSet r = getResultSet("select * from books");//get all books
		// Use while loop to check existence until the end of the title column
		while (r.next()) { 
			if (r.getString("title").equals(uinput)) {//check all titles
				return true; //if input MATCHES TITLE in database
			}
		}
		return false;
	}
    // check if this author is in the database
	public boolean HasAuthor() throws SQLException, ClassNotFoundException {
		// get author from input by getSInput function and get resultSet.
		String uinput = getSInput();
		ResultSet r = getResultSet("select * from books");//get all books
		// Use while loop to check existence until the end of the author column
		while (r.next()) { 
			if (r.getString("author").equals(uinput)) {
				return true; //if input MATCHES AUTHOR in database
			}
		}
		return false;
	}
    // check if book's info match with the database info
	public boolean IsValid() throws SQLException, ClassNotFoundException {
		if (HasBook() ||  HasAuthor()) {
			return this.authentication = true;
		} else {
			return this.authentication = false;
		}
	}
}
