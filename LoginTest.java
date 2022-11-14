import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
     
    private static Login l= new Login();
    private static Create c = new Create();
  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	  
	  l.setPassword("apple");
	  l.setEmail("apple@apple.com");
	  c.Register("apple@apple.com","apple");
//	  String sql = "Delete from users where email = '"+l.getEmail()+"'";
//		PreparedStatement stmt = l.getConnect().prepareStatement(sql);
//				
//		stmt.executeUpdate();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testHasRegistery() throws ClassNotFoundException, SQLException {
		l.setEmail("apple@apple.com");
		l.setPassword("apple");
		assertTrue(l.HasRegistry());
	}

	@Test
	public void testHasRegistryWrongPassword() throws ClassNotFoundException, SQLException {
		l.setEmail("apple@apple.com");
		l.setPassword("green");
		assertFalse(l.HasRegistry());
	}
	
	@Test
	public void testHasRegistryWrongEmail() throws ClassNotFoundException, SQLException {
		l.setEmail("green@apple.com");
		l.setPassword("apple");
		assertFalse(l.HasRegistry());
	}
	

	@Test
	public void testEmailVerification() throws ClassNotFoundException, SQLException {
		l.setEmail("apple@apple.com");
		assertTrue(l.EmailVerification());
	}
	
	@Test
	public void testEmailVerificationFail() throws ClassNotFoundException, SQLException {
		l.setEmail("appleapple.com");
		assertFalse(l.EmailVerification());
	}
	
	@Test
	public void testEmailVerificationFail2() throws ClassNotFoundException, SQLException {
		l.setEmail("@");
		assertFalse(l.EmailVerification());
	}
	
	@Test
	public void testPasswordEncryption() throws ClassNotFoundException, SQLException {
		assertEquals("1f3870be274f6c49b3e31a0c6728957f",l.PasswordEncryption("apple"));
	}
	

	@Test
	public void testPasswordEncryptionFail() throws ClassNotFoundException, SQLException {
		assertNotEquals("1f3870be274f6c49b3e31a0c6728957f",l.PasswordEncryption("Apple"));
	}
	
	@Test
	public void testPasswordEncryptionFail2() throws ClassNotFoundException, SQLException {
		assertNotEquals("1f3870be274f6c49b3e31a0c6728957f",l.PasswordEncryption("green"));
	}
    
	@Test
	public void testPasswordReset() throws ClassNotFoundException, SQLException {
		assertEquals("green",l.PasswordReset("green"));
		//after checking the reset function, use it again for the sake of other testing compatibility
		l.PasswordReset("apple");
	}
	@Test
	public void testPasswordResetNonExisitingEmailFail() throws ClassNotFoundException, SQLException {
		l.setEmail("green@apple.com");
		assertEquals("apple",l.PasswordReset("apple"));
	}


}
