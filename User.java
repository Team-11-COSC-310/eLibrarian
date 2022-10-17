import java.util.*;

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
        return uE + " " + uP;
    }
}
