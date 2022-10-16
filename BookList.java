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

    public boolean AddBook(Book book) {
        if(book != null && !book.equals("")) {
            System.out.println("Can't be empty");
            return false;
        }
        Books.add(book);
       return true;
    }
    public boolean BookSearch(Book Title) {
        for(Book Title: Books) {
            if(Book.getBookTitle().equals(Title)) {
                return true;
            }
        }
        return false;
    }
    // public void BookEdit(int ID, String name, String Author) {
    //     book.setBookTitle(ID, name);
    //     book.setBookAuthor(ID, Author);
    // }
    // public boolean BookRemove(int ID) {
    //     if(Books.containsKey(ID)) {
    //         Books.remove(ID);
    //         return true;
    //   }
    //       return false;
    //   }
    // public Book getBookFromLibrary(int ID) {
    //     Book book = null;
    //     if(!Books.containsKey(ID))
    //         return book;
    //     if(Books.containsKey(ID)) {
    //         book = Books.get(ID);
    //         book.setIsAvailable();
    //     }
    //     return book;
    // }
    
}
