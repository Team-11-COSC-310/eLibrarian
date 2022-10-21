import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ViewBook extends connecttodb{
    Scanner reader = new Scanner(System.in);
    private String answer;

	//need to get book's id from user
	public ViewBook() {
		// Ask input from user
		System.out.println("Which book would like to look at? (ENTER its ID): ");
		setInput(reader.next());
	}
    // set the input
	public String setInput(String Eml) {
		return this.answer = Eml;//store user input in answer
	}
    // get the input
	public String getInput() {
		return answer;//return the user's input
	}
    // check if the id the user inputted is in the database
	public boolean HasID() throws SQLException, ClassNotFoundException {
		// get the inputted book's id and get result of the query.
		String usersbookID = getInput();
		ResultSet r = getResultSet("select * from books");
		// Use while loop to check existence until the end of the ID column
		while (r.next()) {
			if (r.getString("id").equals(usersbookID)) {
				return true;
			}
		}
		return false;//if the inputted id does NOT MATCH then return false
	}
}

