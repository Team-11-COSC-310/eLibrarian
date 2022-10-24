import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Book extends connecttodb{
    private int ID;
    private String BookTitle;
    private String BookAuthor;
    private String BookSum;
    private Array Namelist;
    private String[] strNamelist;
    private Boolean Availability;
    private int wl; //count of how many users are on the wait list

    public Book(int ID, String BookTitle, String BookAuthor, String BookSum, Boolean Availability, int wl, Array Namelist) {
        this.ID = ID;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.BookSum = BookSum;
        this.Availability = true;
        this.wl = wl;
        this.Namelist = Namelist;
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
    public String[] getNamelist() {
        return strNamelist;
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
    public String[] setNamelist(Array dbarray) throws SQLException, ClassNotFoundException {
        this.Namelist = dbarray;
        String [] strNamelist = (String[])this.Namelist.getArray();
        return strNamelist; //get database array, and make it a string
    }
    public void changeWL(int wl, String bid) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE books SET wl = ? WHERE id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setInt(1, wl); //old number plus 1 done in the main loop
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist
        setWL(wl);
    }
    public void changeAvailability(Boolean Availability, String bid) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE books SET availability = ? WHERE id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setBoolean(1, Availability);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist
    }
    public void changeNamelist(String[] uname, int cwl, String bid) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE books SET namelist = ? WHERE id ='"+bid+"'";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        String[] arr = Stream.concat(Arrays.stream(strNamelist), Arrays.stream(uname)).toArray(String[]::new); //Add username to original array
        Array names = getConnect().createArrayOf("namelist", arr);//convert string to java.sql.Array
        stmt.setArray(1, names);//SET NEW ARRAY IN DB
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
            setWL(list.getInt(6));//get number of people on the waitlist
            //setNamelist(list.getArray(7));//get array of people on the waitlist
        }        
    }
}
