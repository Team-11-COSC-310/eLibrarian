import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book extends connecttodb {
	private int ID;
	private String BookTitle;
	private String BookAuthor;
	private String BookSum;
	private Boolean Availability;
	private int wl; // count of how many users are on the wait list

	public Book(int ID, String BookTitle, String BookAuthor, String BookSum, Boolean Availability, int wl) {
		this.ID = ID;
		this.BookTitle = BookTitle;
		this.BookAuthor = BookAuthor;
		this.BookSum = BookSum;
		this.Availability = false;
		this.wl = wl;
	}

	public Book() {
		ID = 0;
		BookTitle = "";
		BookAuthor = "";
		Availability = false;
		wl = 0;
	}

	public int getID() {
		return ID;
	}

	public String getBookTitle() {
		return BookTitle;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	public String getBookSum() {
		return BookSum;
	}

	public int getWL() {
		return wl;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setBookTitle(String BookTitle) {
		this.BookTitle = BookTitle;
	}

	public void setBookSum(String BookSum) {
		this.BookSum = BookSum;
	}

	public void setBookAuthor(String BookAuthor) {
		this.BookAuthor = BookAuthor;
	}

	public Boolean getAvailability() {
		return Availability;
	}

	public void setAvailability(Boolean Availablility, String bid) throws SQLException, ClassNotFoundException {
		this.Availability = Availablility;
	}

	public String IsBookAvailable() {
		return this.Availability ? "It is available now!           Enter 'B' to rent the book.    "
				: "Currently unavailable.           Enter 'W' to join the waitlist.";
	}

	public void setWL(int wl, String bid) throws SQLException, ClassNotFoundException {
		this.wl = wl;
	}
 
	public boolean changeWL(int wl, String bid) throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(bid);
		if (wl >= 0 && bookListLength() > id && id > 0 && checkAvailability(bid)==false) { 
			String sql = "UPDATE books SET wl = ? WHERE id ='" + bid + "'";
			PreparedStatement stmt = getConnect().prepareStatement(sql);
			stmt.setInt(1, wl);
			stmt.executeUpdate();// UPDATE DATABASE after joining a waitlist

			String sql2 = "select * from books where id ='" + bid + "'";
			PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
			ResultSet list = stmt2.executeQuery();
			while (list.next()) {
				setWL(list.getInt(6), bid);// update wl that will displayed
			}
			return true; 
		} else {
			return false;
		}
	}
	 // check if this login session's email has RENTED THIS book in the database
		public boolean borrowedBook(String uemail, String bid) throws SQLException, ClassNotFoundException {
			ResultSet r = getResultSet("SELECT email FROM waitlists where id ='"+bid+"' ORDER BY created_at ASC LIMIT 1");//only is they are the first on the list
			// Use while loop to check existence until the end of the email column
			while (r.next()) {
				if (r.getString("email").equals(uemail)) {
					return true;
				}
			}
			return false;
		}
		
		// check if this login session's email has JOINED THIS BOOK'S waitlist in the database
		public boolean inWaitlist(String uemail, String bid) throws SQLException, ClassNotFoundException {
			ResultSet r = getResultSet("select * from waitlists where id = '"+bid+"'");
			// Use while loop to check existence until the end of the email column
			while (r.next()) {
				if (r.getString("email").equals(uemail)) {
					return true;
				}
			}
			return false;
		}

	public int bookListLength() throws ClassNotFoundException, SQLException {
		String sql = "select * from books";
		PreparedStatement stmt = getConnect().prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		int size = 0;
		while (result.next()) {
			size++;
		}
		return size;
	}

	public boolean checkAvailability(String bid) throws ClassNotFoundException, SQLException {
		String sql = "select * from books where id ='" + bid + "'";
		PreparedStatement stmt = getConnect().prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			if (result.getInt(1) == Integer.parseInt(bid)) {
				return result.getBoolean(5);
			}
		}
		return false;
	}

	public boolean changeAvailability(Boolean i, String bid) {
		// if availability changed to true, its waitlist should be 0
		if (Boolean.TRUE.equals(i)) {
			try {
				String sql = "UPDATE books SET availability = ?,wl=? WHERE id ='" + bid + "'";
				PreparedStatement stmt = getConnect().prepareStatement(sql);
				stmt.setBoolean(1, i);
				stmt.setInt(2, 0);
				stmt.executeUpdate();// UPDATE DATABASE after joining a waitlist
				return true;
			} catch (Exception e) {
				System.out.println("Execution stoped.");
				return false;
			}
			// if availability is false, just change the availability on db
		} else if (Boolean.FALSE.equals(i)) {
			try {
				String sql = "UPDATE books SET availability = ? WHERE id ='" + bid + "'";
				PreparedStatement stmt = getConnect().prepareStatement(sql);
				stmt.setBoolean(1, i);
				stmt.executeUpdate();// UPDATE DATABASE after joining a waitlist
				return true;
			} catch (Exception e) {
				System.out.println("Execution stoped.");
				return false;
			}
		}
		try { 
			changeWL(0, bid);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public void binfo(String bid) throws SQLException, ClassNotFoundException {
		String sql = "select * from books where id ='" + bid + "'";
		PreparedStatement stmt = getConnect().prepareStatement(sql);
		ResultSet list = stmt.executeQuery();
		while (list.next()) {
			setID(list.getInt(1));// set id in class to the one selected
			setBookTitle(list.getString(2));// title
			setBookAuthor(list.getString(3));// author
			setBookSum(list.getString(4));// summary of book
			setAvailability(list.getBoolean(5), bid);// get availablility of book
			setWL(list.getInt(6), bid);// get number of people on the waitlist
		}
	}
}
