import java.util.*;

public class BookList {
    private HashMap<Integer, Book> Books;
    // private ArrayList<ArrayList<String>> BookList = new ArrayList();
    // private ArrayList<String> Books = new ArrayList<>();
    // Scanner reader = new Scanner(System.in);

    public BookList() {
        Books = new HashMap<Integer, Book>();
    }

    public boolean AddBook(Book book) {
        if(!Books.containsKey(book.getID())) {
            Books.put(book.getID(), book);
            return true;
         }
       return false;
    }
    public void BookEdit(int ID, String name, String Author) {
        book.setBookTitle(ID, name);
        book.setBookAuthor(ID, Author);
    }
    public boolean BookRemove(int ID) {
        if(Books.containsKey(ID)) {
            Books.remove(ID);
            return true;
      }
          return false;
      }
    public Book getBookFromLibrary(int ID) {
        Book book = null;
        if(!Books.containsKey(ID))
            return book;
        if(Books.containsKey(ID)) {
            book = Books.get(ID);
            book.setIsAvailable();
        }
        return book;
    }
    
}
