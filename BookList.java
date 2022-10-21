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
            System.out.println("Book can't be empty");
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
        System.out.println(book.toString() + " is added into book list.");
        this.Books.add(book);
        return true;
    }
    public boolean CompareBook(Book book) {
        if(Books.contains(book)) {
            return true;
        }
        return false;
    }
    public boolean RemoveBook(Book book) {
        if(book.getBookTitle().equals("") || book.getBookAuthor().equals("")) {
            System.out.println("Book can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(CompareBook(book) == false) {
                System.out.println("Book doesn't exist in the book list.");
                return false;
            }
        }
        System.out.println(book  + " has been removed from the book list.");
        this.Books.remove(book);
        return true;
    }
    public boolean EditBook(int index, Book book) {
        if(book == null && book.equals("")) {
            System.out.println("Book can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(CompareBook(book) == true) {
                System.out.println("Book already exist in the book list.");
                return false;
            }
        }
        System.out.println(book.toString() + " has replace index "+ index + " and added into the book list.");
        this.Books.set(index, book);
        return true;
    }
    public boolean EditBook(Book book, int ID, String Title, String Author, int waitlist, boolean avaliability) {
    	book.setID(ID);
    	book.setBookTitle(Title);
    	book.setBookAuthor(Author);
    	book.setIsAvailable(avaliability);
    	book.setwl(waitlist);
    	System.out.println(book.toString() + " value has been updated in the book list.");
    	return true;
    }
    public boolean BookSearch(Book book) {
        for(int i = 0; i < Books.size(); i++) {
            if(Books.contains(book)) {
                System.out.println(book.toString() + " is in the book list.");
                return true;
            }
        }
        System.out.println(book.toString() + " is not in the book list.");
        return false;
    }
    public boolean getBookFromLibrary(Book book) {
        if(BookSearch(book)) {
            if(book.IsBookAvailable().equals("Yes")) {
                book.setIsAvailable(false);
                System.out.println("Successfully borrowed " + book.toString() + " from the library.");
                return true;
            } else {
                System.out.println(book.toString() + " is not avaiable, please join the waitlist.");
                return false;
            }
        } 
        System.out.println(book.toString() + " is not in the library book list, please add the book into the book list.");
        return false;
    }
    public boolean returnBook(Book book) {
        if(BookSearch(book)) {
            if(book.IsBookAvailable().equals("No")) {
                book.setIsAvailable(true);
                System.out.println("Successfully return " + book.toString() + " to the library.");
                return true;
            } else {
                System.out.println(book.toString() + " is already in the library.");
                return false;
            }
        } 
        System.out.println(book.toString() + " is not in the library book list, please add the book into the book list.");
        return false;
    }
    public void print() {
    	System.out.println("Books in the library book list are: ");
    	for(Book book: Books) {
    		System.out.println(book.toString());
    	}
    }

    
}