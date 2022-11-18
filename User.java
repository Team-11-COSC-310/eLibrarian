import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User extends connecttodb {
    private String Email;
    private String Password;
    Scanner reader = new Scanner(System.in);

    public User(String email, String password) {
        this.Email = email;
        this.Password = password;
    }
    public User() {
        Email = "";
        Password = "";
    }
    public String getEmail() {
        return Email;
    }
    public String getPasword() {
        return Password;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String info(String uemail) throws SQLException, ClassNotFoundException {
        String sql = "select * from users where email ='"+uemail+"'";//get email and password from the user
        String info="";
        ResultSet list = getResultSet(sql);//should be every title and author  
		while (list.next()) {
            info += "| | ";//new line
            info += list.getString(1);//email
            info += " ---- ";//space
            info += list.getString(2);//pass
            info += "\n";//new line
        }
        info += "| |------------------------------------------------------------------| |\n";
        info += "| | Books currently borrowing, or waiting for:                       | |\n";
        info += "| |------------------------------------------------------------------| |\n";
        //use a subquery to get id from waitlists with the user's email, and get the names of these books
        String sql2 = "select title from books where id in (select id from waitlists where email ='"+uemail+"')";//get names of books they are on a waitlist for
        ResultSet list2 = getResultSet(sql2);//should be every title and author  
		while (list2.next()) {
            info += "| | ";//new line
            info += list2.getString(1);//titles of books that the user is on a waitlist for
            info += "\n";//new line
        } 
        return info;
    }
}