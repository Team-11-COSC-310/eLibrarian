import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
class LibrarianActionTest {
	private static LibrarianAction a;

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
		a = new LibrarianAction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBook() throws ClassNotFoundException, SQLException {
		assertFalse(a.AddBook());
	}
	
	@Test
	public void testDeleteUser() throws ClassNotFoundException, SQLException {
		assertFalse(a.DeleteUser("aaa@icloud.com"));
	}
	@Test
	public void testHasBook() throws ClassNotFoundException, SQLException {
		assertFalse(a.HasBook("book"));
	}


}
