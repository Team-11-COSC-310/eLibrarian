import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class Borrow extends connecttodb{
    private int id;
    private String BookTitle;
    private static Book b = new Book();
    public Borrow(int id, String BookTitle) {
        this.id = id;
        this.BookTitle = BookTitle;
    }
    public Borrow() {
        id = 0;
        BookTitle = "";
    }
    public int getid() {
        return id;
    }
    public String gettitle() {
        return BookTitle;
    }
    public void setID(int id) {
        this.id = id;
    }
    public void setbtitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String readwl(String bid) throws SQLException, ClassNotFoundException{//make list of users on waitlist
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
    public int countwl(String bid) throws SQLException, ClassNotFoundException{//make list of users on waitlist
        int result = 0;
        String sql = "SELECT COUNT(email) FROM waitlists where id ='"+bid+"' ORDER BY created_at ASC";//check using the book selected's id
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();  
		while (list.next()) { //get a book's waitlist info and count the members. return count.
            result += list.getInt(1);//# of user's emails on list
        }    return result;
    }
    public String wlTop(String bid) throws SQLException, ClassNotFoundException{//get first user on the waitlist
        String topinfo = "";
        String sql = "SELECT email FROM waitlists where id ='"+bid+"' ORDER BY created_at ASC LIMIT 1";//check using the book selected's id
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();    
		while (list.next()) { //get a book's waitlist info and print it to a string             
			topinfo += list.getString(1);//user's email
        }    return topinfo;
    }
    public int checkTime(String uemail, String bid) throws SQLException, ClassNotFoundException{
        Instant instant = Instant.now();//get current time
        OffsetDateTime atime = OffsetDateTime.parse( "2012-01-01T12:30:30+01:00" );//random date just to set up variable for rent time
        String sql = "SELECT created_at FROM waitlists where email ='"+uemail+"' and id ='"+bid+"'";//check using the book 
        //selected's id and user's email
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();    
		while (list.next()) { //get the created_at timestamp from the database to compare to the current time            
			atime = list.getObject("created_at", OffsetDateTime.class);//get object of the timestamp when they rented the book OR joined the wl
        }
        long result = ChronoUnit.DAYS.between(instant, atime.toInstant());//return number of days between the rent day and now
        int returnDate = 21-(int)result;//get 21 days minus the difference to find the date its due back.
        return returnDate;//
    }
    public boolean rbook(String uemail, String bid) throws SQLException, ClassNotFoundException{
    	Boolean available = b.checkAvailability(bid);
    	if(available==true&&checkDoubleBooking(uemail,bid)==false&&countwl(bid)==0) {
        String sql = "INSERT INTO waitlists (email,id) VALUES ('"+uemail+"','"+bid+"')";//create waitlist using current user's id & the book selected
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist
        String sql2 = "UPDATE books SET availability = ?, wl = ? WHERE id ='"+bid+"'";//need to update availability AND wl
        PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
        stmt2.setBoolean(1, b.changeAvailability(false, bid));//change availility to opposite
        stmt2.setInt(2, countwl(bid)+1);//update waitlist to add 1
        stmt2.executeUpdate();//UPDATE DATABASE after renting a book (CREATING a waitlist)
        return true;
    	}else {
    		return false;
    	}
    }
    //check if the same person try to borrow the same id (bid) book 
    public boolean checkDoubleBooking(String uemail,String bid) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM waitlists where id ='"+bid+"' ORDER BY created_at ASC";//check using the book selected's id
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        ResultSet list = stmt.executeQuery();   
        while(list.next()) {
        	if(list.getString(1).equals(uemail)) {
        		return true;
        	}
        }
        return false;
    }
    
    public boolean jWl(String uemail, String bid) throws SQLException, ClassNotFoundException{
    	if(!checkDoubleBooking(uemail,bid)&&!b.checkAvailability(bid)) {
        String sql = "INSERT INTO waitlists (email,id) VALUES ('"+uemail+"','"+bid+"')";//join/create waitlist using current user's id & the book selected
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.executeUpdate();//UPDATE DATABASE after joining a waitlist
        String sql2 = "UPDATE books SET wl = ? WHERE id ='"+bid+"'";//only need to update wl since book is staying unavailable
        PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
        stmt2.setInt(1, countwl(bid)+1);//update waitlist to add 1
        stmt2.executeUpdate();//UPDATE DATABASE after joining an EXISTING waitlist 
        return true; 
    	}else {
    		return false;
    	}
    }
    public void editwl(String uemail, String bid) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM waitlists WHERE email = '"+uemail+"' and id = '"+bid+"'";//deletes current user's id & the book selected from waitlist
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.executeUpdate();//UPDATE DATABASE after wait ends  
    } 
    public void resetwl(String bid) throws ClassNotFoundException, SQLException {
    	String sql = "DELETE FROM waitlists where id = '"+bid+"'";
    	PreparedStatement stmt = getConnect().prepareStatement(sql);
    	stmt.executeUpdate();
    	String sql2 = "Update books set availability = true, wl = 0 where id = '"+bid+"'";
    	PreparedStatement stmt2 = getConnect().prepareStatement(sql2);
    	stmt2.executeUpdate();
    }
} 