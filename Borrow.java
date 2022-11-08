import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Borrow extends connecttodb{
    private int id;
    private String BookTitle;
    private String Tstamp;

    public Borrow(int id, String BookTitle, String Tstamp) {
        this.id = id;
        this.BookTitle = BookTitle;
        this.Tstamp = Tstamp;
    }
    public Borrow() {
        id = 0;
        BookTitle = "";
        Tstamp = "";
    }
    public int getid() {
        return id;
    }
    public String gettitle() {
        return BookTitle;
    }
    public String getTstamp() {
        return Tstamp;
    }
    public void setID(int id) {
        this.id = id;
    }
    public void setbtitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }
    public void setTstamp(String Tstamp) {
        this.Tstamp = Tstamp;
    }

    public String readwl(String bid) throws SQLException, ClassNotFoundException{
        String wlinfo = "";
        String sql = "SELECT * FROM waitlists where id ='"+bid+"' ORDER BY created_at ASC";//check using the book selected's id
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();    
		while (list.next()) { //get a book's waitlist info and print it to a string
            wlinfo += "| | ";//start of line               
			wlinfo += list.getString(1);//user's emails 
            wlinfo += "\n";//new line
        }    return wlinfo;
    }
    public String checkTime(String uemail, String bid) throws SQLException, ClassNotFoundException{
        String atime = "";
        String sql = "SELECT created_at FROM waitlists where email ='"+uemail+"' and id ='"+bid+"'";//check using the book selected's id and user's email
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();    
		while (list.next()) { //get a book's waitlist info and print it to a string
            atime += "| | ";//start of line               
			atime += list.getString(1);//get string of the timestamp when they rented the book OR joined the wl
            atime += "\n";//new line
        }    return atime;//
    }
    public void rbookORjwl(String uemail, String bid) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO waitlists (email,id) VALUES ('"+uemail+"','"+bid+"')";//join/create waitlist using current user's id & the book selected
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist    
    }
    public void editwl(String uemail, String bid) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM waitlists WHERE email = '"+uemail+"' and id = '"+bid+"'";//deletes current user's id & the book selected from waitlist
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.executeUpdate();//UPDATE DATABASE after wait ends  
    }
}
