import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
public class BorrowTest {
    private static Borrow b = new Borrow();
    private static String email;
    private static Book book = new Book();
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Using @BeforeClass, executed before all test cases ");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Using @AfterClass, executed after all test cases ");
	}

	@Before
	public void setUp() throws Exception {
		email = "johnbooks@book.com";
		b.resetwl("1");
		b.resetwl("2");
		
		
//		String sql = "select * from books where id = ?";
//		PreparedStatement stmt = b.getConnect().prepareStatement(sql);
//	    stmt.setInt(1, 1);
//		ResultSet list = stmt.executeQuery();
//		int waitlistNum = list.getInt(6);
//		b.jWl(waitlistNum, email, "1");
	}

	@After
	public void tearDown() throws Exception {
		//b.resetwl("1");
		b.resetwl("2");
	}
	
	
	@Test
	public void testRbook() throws ClassNotFoundException, SQLException {
		assertTrue(b.rbook(email, "1"));
	}

	@Test
	public void testRbookOverbookingFail() throws ClassNotFoundException, SQLException {
		//the same person try to borrow the same book
		b.rbook(email, "1");
		assertFalse(b.rbook(email, "1"));
		
	}
	
 
	@Test
	public void testRbookBookingFail() throws ClassNotFoundException, SQLException {
		b.rbook("johnbooks@book.com", "1");
		System.out.println(book.checkAvailability("1"));
		//someone already borrowed the book, and the other person try to borrow the same instead of joining waitlist
		assertFalse(b.rbook("iheartbooks@book.com", "1"));
	}
	
	@Test
	public void testJwl() throws ClassNotFoundException, SQLException {
	    b.rbook("green@green.com", "1");
		assertTrue(b.jWl("johnbooks@book.com", "1"));
	}
	
    
	@Test
	public void testJwlOverWaitlisting() throws ClassNotFoundException, SQLException {
		b.jWl("johnbooks@book.com", "2");
		assertFalse(b.jWl("johnbooks@book.com", "2"));
	}

	@Test
	public void testJwlFailBecauseOfAvailability() throws ClassNotFoundException, SQLException {
		book.changeAvailability(true, "2");
		assertFalse(b.jWl("johnbooks@book.com", "2"));
	}
	
	



}
