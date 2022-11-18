import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateTest {
    private static Create c = new Create();
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { 
	  
	}
	
	//Everytime run after each test case, cleans up the database;
	@After
	public void tearDown() throws Exception {

		  String sql = "delete from users where email = ?";
	      PreparedStatement stmt = c.getConnect().prepareStatement(sql);
          stmt.setString(1, "abc@icloud.com");
          stmt.executeUpdate();
	  
	}

	@Test
	public void testRegister() throws ClassNotFoundException, SQLException {
		assertTrue(c.Register("abc@icloud.com", "abc"));
	}
	
//duplicate entry check
	@Test
	public void testRegisterFail() throws ClassNotFoundException, SQLException {
		c.Register("abc@icloud.com", "abc");
		assertFalse(c.Register("abc@icloud.com", "abc"));
	}
	
//invalid email handle check
	@Test
	public void testRegisterFail2() throws ClassNotFoundException, SQLException {
		assertFalse(c.Register("abc", "abc"));
	}


	@Test
	public void testnRegisterLibrarian() throws ClassNotFoundException, SQLException {
		assertTrue(c.RegisterLibrarian("abc@icloud.com", "abc"));
	}
	

	@Test
	public void testnRegisterLibrarianFail() throws ClassNotFoundException, SQLException {
		c.RegisterLibrarian("abc@icloud.com", "abc");
		assertFalse(c.RegisterLibrarian("abc@icloud.com", "abc"));
	}
	
	@Test
	public void testnRegisterLibrarianFail2() throws ClassNotFoundException, SQLException {
		assertFalse(c.RegisterLibrarian("abc", "abc"));
	}


}
