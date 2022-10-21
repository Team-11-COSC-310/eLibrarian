import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Scanner;

public class BookList extends connecttodb {
    private ArrayList<Book> Books = new ArrayList<Book>();
    private int count;
    Scanner reader = new Scanner(System.in);

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
    public boolean AddBook(Book book) throws ClassNotFoundException, SQLException {
        if(book.getBookTitle().equals("") || book.getBookAuthor().equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        for(Book book1: Books) {
            if(this.CompareAddBook(book1, book) == false) {
                return false;
            }
        }
        //if(book.IsBookAvailable().equals("No")) {
         //   book.setAvailability(true);
        //}
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
                System.out.println(book.toString() + " is in the book list.");
                return true;
            }
        }
        System.out.println(book.toString() + " is not in the book list.");
        return false;
    }
    // public boolean getBookFromLibrary(Book book) {
    //     if(BookSearch(book)) {
    //         if(book.IsBookAvailable().equals("Yes")) {
    //             book.setIsAvailable(false);
    //             System.out.println("Successfully borrowed " + book.toString() + " from the library.");
    //             return true;
    //         } else {
    //             System.out.println(book.toString() + " is not avaiable, please join the waitlist.");
    //             return false;
    //         }
    //     } 
    //     System.out.println(book.toString() + " is not in the library book list, please add the book into the book list.");
    //     return false;
    // }
    // public boolean returnBook(Book book) {
    //     if(BookSearch(book)) {
    //         if(book.IsBookAvailable().equals("No")) {
    //             book.setIsAvailable(true);
    //             System.out.println("Successfully return " + book.toString() + " to the library.");
    //             return true;
    //         } else {
    //             System.out.println(book.toString() + " is already in the library.");
    //             return false;
    //         }
    //     } 
    //     System.out.println(book.toString() + " is not in the library book list, please add the book into the book list.");
    //     return false;
    // }
    public String inventory() throws SQLException, ClassNotFoundException{
        String invent="";
        ResultSet list = getResultSet("select * from books");//should be every title and author
		// Use while loop to add every book's title and its author to a big string
		while (list.next()) { 
            invent += "| | ";//new line               
			invent += list.getString(2);//title 
            invent += " ---- ";//space
            invent += list.getString(3);//author
            invent += " ---- ";//space
            invent += list.getString(1);//id 
            invent += "\n";//new line
		}
        return invent;
    }
}
