import java.util.*;

public class BookListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book();
		Book book2 = new Book(1, "A", "B", 0);
		Book book2_1 = new Book(2, "C", "D", 0);
		BookList Books = new BookList();
		System.out.println(book1.toString());
		Books.AddBook(book1);
		Books.AddBook(book2);
		System.out.println(Books.BookSearch(book1));
		System.out.println(Books.BookSearch(book2));
		System.out.println(Books.EditBook(0, book2_1));
		book2_1.setID(3);
		book2_1.setBookTitle("E");
		book2_1.setBookAuthor("F");
		book2_1.setwl(1);
		System.out.println(book2_1.toString());
		System.out.println(Books.RemoveBook(book1));
		System.out.println(Books.RemoveBook(book2));
		System.out.println(Books.RemoveBook(book2_1));
	}

}