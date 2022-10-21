import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User extends connecttodb {
    private int ID;
    private String Email;
    private String Password;
    Scanner reader = new Scanner(System.in);

    public User(int ID, String email, String password) {
        this.ID = ID;
        this.Email = email;
        this.Password = password;
    }
    public User() {
        ID = 0;
        Email = "";
        Password = "";
    }
    public int getID() {
        return ID;
    }
    public String getEmail() {
        return Email;
    }
    public String getPasword() {
        return Password;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String info(String uemail) throws SQLException, ClassNotFoundException {
        String sql = "select * from books where id ='"+uemail+"'";
        String info="";
        ResultSet list = getResultSet(sql);//should be every title and author  
		while (list.next()) {
            info += "| | ";//new line               
			info += list.getString(1);//id
            info += " ---- ";//space
            info += list.getString(2);//email
            info += " ---- ";//space
            info += list.getString(3);//pass
            info += "\n";//new line
        } 
        return info;
    }
}

