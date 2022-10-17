import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BookList {
    // private ArrayList<ArrayList<String>> BookList = new ArrayList();
    // private ArrayList<String> Books = new ArrayList<>();
    // Scanner reader = new Scanner(System.in);
    private ArrayList<Book> Books = new ArrayList<Book>();

    public BookList(ArrayList<Book> Books) {
        this.Books.addAll(Books);
    }
    public BookList() {
        this(new ArrayList<Book>());
    }
    public boolean CompareBook(Book book) {
        
        return true;
    }
    public boolean AddBook(Book book) {
        if(book != null && !book.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        Books.add(book);
       return true;
    }
    public boolean RemoveBook(Book book) {
        if(book != null && !book.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        Books.remove(book);
       return true;
    }
    public boolean EditBook(int index, Book book) {
        if(book != null && !book.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        Books.set(index, book);
       return true;
    }
    public boolean BookSearch(Book book) {
        for(int i = 0; i < Books.size(); i++) {
            if(Books.contains(book)) {
                return true;
            }
        }
        return false;
    }
    public Book getBookFromLibrary(Book book) {
        if(BookSearch(book)) {
            book.setIsAvailable(false);
            RemoveBook(book);
            return book;
        }
        return null;
    }
    // public void BookEdit(int ID, String name, String Author) {
    //     book.setBookTitle(ID, name);
    //     book.setBookAuthor(ID, Author);
    // }

    
}
