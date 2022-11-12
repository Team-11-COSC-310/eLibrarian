import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
class BorrowTest {
    private static Borrow b;
    private static String email;
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
		b = new Borrow();
		email = "johnbooks@book.com";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountWl() throws ClassNotFoundException, SQLException {
		assertNotNull(b.countwl("1"));
	}
	
	@Test
	public void testCheckTime() throws ClassNotFoundException, SQLException {
		assertNotNull(b.checkTime(email,"1"));
	}
	
	@Test
	public void testWlTop() throws ClassNotFoundException, SQLException {
		assertEquals(0,b.wlTop("1"));
	}



}
