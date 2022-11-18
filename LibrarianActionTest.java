import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibrarianActionTest {
    private static LibrarianAction ac = new LibrarianAction();
    private static Create mock = new Create();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("LibrarianAction Testing-----------------------start");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("LibrarianAction Testing-----------------------end");

	}

	@Before 
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		ac.EditBook("try");
	}

	@Test
	public void testAddBook() throws ClassNotFoundException, SQLException {
		assertTrue(ac.AddBook("try", "try", "try", true, 0));
	}
	

	@Test
	public void testAddBookEmptyTitleFail() throws ClassNotFoundException, SQLException {
		assertFalse(ac.AddBook("","try", "try", true, 0));
	}
	

	@Test
	public void testAddBookAvailabilityFail() throws ClassNotFoundException, SQLException {
		assertFalse(ac.AddBook("try","try", "try", null, 0));
	}


	@Test
	public void testHasBook() throws ClassNotFoundException, SQLException {
		assertFalse(ac.HasBook("try"));
	}
	

	@Test
	public void testHasBookEmptyTitleFail() throws ClassNotFoundException, SQLException {
		assertFalse(ac.HasBook(""));
	}
	

	@Test
	public void testHasBookNonExisitingTitleFail() throws ClassNotFoundException, SQLException {
		assertFalse(ac.HasBook("try1"));
	}



	@Test
	public void testDeleteUser() throws ClassNotFoundException, SQLException {
		mock.Register("mock@mock.com","mock");
		assertTrue(ac.DeleteUser("mock@mock.com"));
	}
	

	@Test
	public void testDeleteUserAdmin() throws ClassNotFoundException, SQLException {
		mock.RegisterLibrarian("mock@mock.com","mock");
		assertTrue(ac.DeleteUser("mock@mock.com"));
	}
	

	@Test
	public void testDeleteUserFail() throws ClassNotFoundException, SQLException {
		mock.Register("mock@mock.com","mock");
		assertFalse(ac.DeleteUser("mck@mock.com"));
		ac.DeleteUser("mock@mock.com");
	}
	
	
	
	
	

}
