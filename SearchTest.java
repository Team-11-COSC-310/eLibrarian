import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class SearchTest {
    @Test
    public void testHasAuthor() throws SQLException {

        try (Connection conn = DriverManager.getConnection(null);
                Statement stmt = conn.createStatement();) {
            String u = "J.K. Rowling";
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                if (rs.getString("author").equals(u)) {
                    return;
                }
            }

        } catch (SQLException e) {

        }
    }

    @Test
    public void testHasBook() {
        try (Connection conn = DriverManager.getConnection(null);
                Statement stmt = conn.createStatement();) {
            String u = "Harry Potter and the Chamber of Secrets";
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                if (rs.getString("title").equals(u)) {
                    return;
                }
            }

        } catch (SQLException e) {
        }

    }

}
