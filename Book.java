import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book extends connecttodb{
    private int ID;
    private String BookTitle;
    private String BookAuthor;
    private String BookSum;
    private Boolean Availability;
    private int wl; //count of how many users are on the wait list

    public Book(int ID, String BookTitle, String BookAuthor, String BookSum, Boolean Availability, int wl) {
        this.ID = ID;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.BookSum = BookSum;
        this.Availability = true;
        this.wl = wl;
    }
    public Book() {
        ID = 0;
        BookTitle = "";
        BookAuthor = "";
        Availability = true;
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
        return this.Availability ? "It is available now!           Enter 'B' to rent the book.    " : "Currently unavailable.           Enter 'W' to join the waitlist.";
    }
    public void setWL(int wl, String bid) throws SQLException, ClassNotFoundException {
        this.wl = wl;
    }
    public void changeWL(int wl, String bid) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE books SET wl = ? WHERE id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setInt(1, wl);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist

        String sql2 = "select * from books where id ='"+bid+"'";
        PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
        ResultSet list = stmt2.executeQuery();    
		while (list.next()) {
            setWL(list.getInt(6),bid);//update wl that will displayed
        }

    }
    public void changeAvailability(Boolean Availability, String bid) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE books SET availability = ? WHERE id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setBoolean(1, Availability);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist
    }
    public void binfo(String bid) throws SQLException, ClassNotFoundException{
        String sql = "select * from books where id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();    
		while (list.next()) {
            setID(list.getInt(1));//set id in class to the one selected
            setBookTitle(list.getString(2));//title 
            setBookAuthor(list.getString(3));//author 
            setBookSum(list.getString(4));//summary of book
            setAvailability(list.getBoolean(5),bid);//get availablility of book
            setWL(list.getInt(6),bid);//get number of people on the waitlist
        }        
    }
}
