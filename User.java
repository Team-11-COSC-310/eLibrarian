import java.util.*;
/* This is the User class
Used for displaying user info,
adding users to a book's waitlist
create user?*/

public class User {
    private String uE; //User email
    private String uP; //User password

    public User(String uE, String uP) {
        this.uE = uE;
        this.uP = uP;
    }
    public User() {
        uE = "";
        uP = "";
    }
    public String getuE() {
        return uE;
    }
    public String getuP() {
        return uP;
    }
    public void setuE(String uE) {
        this.uE = uE;
    }
    public void setuP(String uP) {
        this.uP = uP;
    }
    //format user info nicely to string
    public String toString( ) {
        return "Email: " + uE + "\nPassword: " + uP;
    }
}
