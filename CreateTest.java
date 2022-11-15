import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateTest {
    private static Create a;
    private static Create b;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Using @BeforeClass, executed before all test cases");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Using @AfterClass, executed after all test cases");

    }

    @Before
    public void setUp() throws Exception {
        CreateTest a = new CreateTest();

        CreateTest b = new CreateTest();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRegister() throws ClassNotFoundException, SQLException {
        assertTrue(a.Register("getone@gmail.com", "getone"));

    }

    @Test
    public void testRegisterLibrarian() throws ClassNotFoundException, SQLException {
        assertTrue(b.RegisterLibrarian("gettwo@gmail.com", "gettwo"));
    }

}
