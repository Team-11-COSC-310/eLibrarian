import java.util.*;

public class Book {
    private int ID;
    private String BookTitle;
    private String BookAuthor;
    private boolean IsAvailable;
    private int wl; //wl count

    public Book(int ID, String BookTitle, String BookAuthor, int wl) {
        this.ID = ID;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.IsAvailable = true;
        this.wl = wl;
    }
    public Book() {
        ID = 0;
        BookTitle = "";
        BookAuthor = "";
        IsAvailable = false;
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
    public String getwl() {
        return wl;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }
    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }
    public void setwl(int wl) {
        this.wl = wl;
    }
    public void setIsAvailable(boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
    public String IsBookAvailable() {
        return this.IsAvailable ? "Yes" : "No";
    }
    public String toString( ) {
        return ID + " " + BookTitle + " " + BookAuthor + " " + wl;
    }
}
