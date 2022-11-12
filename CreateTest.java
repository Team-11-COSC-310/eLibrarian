import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class CreateTest {

    @Test
    public void testRegister() throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(null);
                Statement stmt = conn.createStatement();) {
            PreparedStatement pst = (PreparedStatement) stmt
                    .executeQuery("insert into users(email, password)" + "values (?, ?)");
            pst.setString(1, "email");
            pst.setString(2, "password");
        } catch (SQLException e) {

        }

    }

}
