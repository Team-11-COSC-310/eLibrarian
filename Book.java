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
        return this.Availability ? "It is available now!           Enter 'B' to rent the book.    " : "Currently unavailable.         Enter 'W' to join the waitlist.";
    }
    public void setWL(int wl) throws SQLException, ClassNotFoundException {
        this.wl = wl;
    }
    public void countwl(String bid) throws SQLException, ClassNotFoundException{//make list of users on waitlist
        int result = 0;
        String sql = "SELECT COUNT(email) FROM waitlists where id ='"+bid+"'";//check using the book selected's id
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();  
		while (list.next()) { //get a book's waitlist info and count the members. return count.
            result += list.getInt(1);//# of user's emails on list
        } 
        setWL(result);//set WL to be the amount of users from the actual database   
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
        } 
        String sql2 = "SELECT COUNT(email) FROM waitlists where id ='"+bid+"'";
        PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
        ResultSet list2 = stmt2.executeQuery();//count names on the waitlist to get the number of users waiting for a specific book
        int count = 0;
		while (list2.next()) {
            count = list2.getInt(1);
            setWL(count);//get int number of people on the waitlist
        }
        if (count == 0) {//if available
            setAvailability(true,bid);//set availablility of book for binfo to read
            String sqlAT = "UPDATE books SET availability = ? WHERE id ='"+bid+"'";
            PreparedStatement stmtU = getConnect().prepareStatement(sqlAT);//actually use waitlist database to check availability and update
            stmtU.setBoolean(1, true);
            stmtU.executeUpdate();//UPDATE DATABASE after getting book info
        }
        else if (count > 0) {//if NOT available
            setAvailability(false,bid);//set availablility of book false since there is a wait
            String sqlAF = "UPDATE books SET availability = ? WHERE id ='"+bid+"'";
            PreparedStatement stmtAF = getConnect().prepareStatement(sqlAF);//actually use waitlist database to check availability and update
            stmtAF.setBoolean(1, false);
            stmtAF.executeUpdate();//UPDATE DATABASE after getting book info
        }   
    }

}
