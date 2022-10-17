import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class createaccount {
    public static void main(String[] args) {

        System.out.println("What is your email address? ");
        Scanner input = new Scanner(System.in);
        String email = input.next();
        System.out.println("What is your password? ");
        Scanner input1 = new Scanner(System.in);
        String password = input.next();

        String sql = "insert into users" + "(email, password)" + "values (?, ?)";
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, email);
        stmt.setString(2, password);

        stmt.executeUpdate();
        //text
    }
}
