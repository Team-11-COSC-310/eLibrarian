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
    private int count;

    public BookList(ArrayList<Book> Books) {
        this.Books.addAll(Books);
    }
    public BookList() {
        this(new ArrayList<Book>());
    }
    public boolean CompareAddBook(Book book1, Book book2) {
        if(book1.getBookTitle().equals(book2.getBookTitle())) {
            System.out.println("Title name is already in the book list.");
            return false;
        }
        if(book1.getBookAuthor().equals(book2.getBookAuthor())) {
            System.out.println("Author name is already in the book list.");
            return false;
        }
        return true;
    }
    public boolean AddBook(Book book) {
        if(book.getBookTitle().equals("") || book.getBookAuthor().equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(this.CompareAddBook(book1, book) == false) {
                return false;
            }
        }
        if(book.IsBookAvailable().equals("No")) {
            book.setIsAvailable(true);
        }
        this.Books.add(book);
        return true;
    }
    public boolean CompareBook(Book book1, Book book2) {
        if(book1.getBookTitle().equals(book2.getBookTitle()) && book1.getBookAuthor().equals(book2.getBookAuthor())) {
            return true;
        }
        return false;
    }
    public boolean RemoveBook(Book book) {
        if(book.getBookTitle().equals("") || book.getBookAuthor().equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(CompareBook(book1, book) == false) {
                System.out.println("Book doesn't exist in the book list.");
                return false;
            }
        }
        this.Books.remove(book);
        return true;
    }
    public boolean EditBook(int index, Book book) {
        if(book != null && !book.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(CompareBook(book1, book) == false) {
                System.out.println("Book doesn't exist in the book list.");
                return false;
            }
        }
        this.Books.set(index, book);
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
