import java.util.*;

public class AddEditBook {
    private ArrayList<ArrayList<String>> BookList = new ArrayList();
    private int BookID;
    private String BookTitle;
    private String BookAuthor;
    Scanner reader = new Scanner(System.in);

    public void BookAdd() {
        ArrayList<String> Books = new ArrayList<>();
        Books.add(BookTitle);
        Books.add(BookAuthor);
        BookList.add(Books);
    }
    public void BookEdit(int index, String name, String Author) {
        setBookName(index, name);
        setBookAuthor(index, Author);
    }
    public void BookRemove(int index) {
        BookList.remove(index);
    }
    public String getBookName(int index) {
        return BookList.get(index).get(0);
    }
    public String getBookAuthor(int index) {
        return BookList.get(index).get(1);
    }
    public void setBookName(int index, String name) {
        BookList.get(index).set(0, name);
    }
    public void setBookAuthor(int index, String author) {
        BookList.get(index).set(0, author);
    }
}
