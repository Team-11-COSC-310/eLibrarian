import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookTest {
    private static Book b = new Book();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		String sql = "UPDATE books SET wl = ?,availability = ? WHERE id = ?";
        PreparedStatement stmt = b.getConnect().prepareStatement(sql); 
        stmt.setInt(1, 1);
        stmt.setBoolean(2, false);
        stmt.setInt(3,3);
        stmt.executeUpdate();
        stmt.close();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testChangeWL() throws ClassNotFoundException, SQLException {
		assertTrue(b.changeWL(3,"3"));
	}
	@Test
	public void testChangeWLAvailabilityUnmatchingFail() throws ClassNotFoundException, SQLException {
		assertFalse(b.changeWL(5,"2"));
	}
	@Test
	public void testChangeWLInvalidBookIDFail() throws ClassNotFoundException, SQLException {
		assertFalse(b.changeWL(5,Integer.toString(b.bookListLength()+1)));
	}

	@Test
	public void testChangeAvailabilitySetTrueMakesZeroWaitlist() throws ClassNotFoundException, SQLException {
		b.changeAvailability(true, "3");
		b.binfo("3");
		assertEquals(0,b.getWL());
	}

	@Test
	public void testChangeAvailabilitySetFalse() {
		assertTrue(b.changeAvailability(false, "3"));
	}
	
	@Test
	public void testChangeAvailabilitySetNull() throws ClassNotFoundException, SQLException {
		b.changeAvailability(null, "3");
		b.binfo("3");
		assertEquals(0,b.getWL());
	}
	
}
