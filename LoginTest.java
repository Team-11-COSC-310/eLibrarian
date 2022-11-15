import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
    private static Login a;
    private static Login b;
    private static Create c;
    private static Create lc;

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
        a = new Login();
        b = new Login();
        c = new Create();
        c.Register("try1@icloud.com", "try1");
        lc = new Create();
        lc.RegisterLibrarian("try2@icloud.com", "try2");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testHasRegistry() throws ClassNotFoundException, SQLException {
        assertFalse(a.HasRegistry());
        assertTrue(c.HasRegistry());
        assertTrue(lc.HasRegistry());
    }

    @Test
    public void testPasswordEncryption() {
        assertEquals("9711c44bc923072c69621cd5362de3e2", c.PasswordEncryption("try1"));
    }

    @Test
    public void testEmailVerification() {
        assertTrue(a.EmailVerification());
    }

}