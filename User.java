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
        String sql = "select * from users where email ='"+uemail+"'";
        String info="";
        ResultSet list = getResultSet(sql);//should be every title and author  
		while (list.next()) {
            info += "| | ";//new line
            info += list.getString(1);//email
            info += " ---- ";//space
            info += list.getString(2);//pass
            info += "\n";//new line
        } 
        return info;
    }
}

