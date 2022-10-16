import java.util.*;

public class Book {
    private int ID;
    private String BookTitle;
    private String BookAuthor;
    private boolean IsAvailable;

    public Book(int ID, String BookTitle, String BookAuthor) {
        this.ID = ID;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.IsAvailable = true;
    }
    public Book() {
        ID = 0;
        BookTitle = "";
        BookAuthor = "";
        IsAvailable = false;
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
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }
    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }
    public void setIsAvailable(boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
    public String IsBookAvailable() {
        return this.IsAvailable ? "Yes" : "No";
    }
}
