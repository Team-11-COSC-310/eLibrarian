import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create extends Login {
    private String userEmail;
    private String userPassword;
    private int cAttempt;

    public Create(int cattempt, int user) throws SQLException, ClassNotFoundException {
        super(cattempt, null);// call to login function with blank slate

        userEmail = super.getEmail();
        userPassword = super.getPassword();
        if (super.HasEmail()) { // if the entered email matches one in databse already, dont add user and prompt
                                // to retry
            System.out.println("That email is already being used by an account.");
            cattempt = 3;
            setAttempt(cattempt);// store construct attempt # in variable to be seen by main app
        } else if (super.HasEmail() == false && user == 0) { // if the email doesn't match, then make new user. DON'T
                                                             // care about repeat passwords
            Register(userEmail, userPassword);// get login info and put it in database
            cattempt = 1; // reset create input
            setAttempt(cattempt);// store construct attempt # in variable to be seen by main app
        } else {
            Register(userEmail, userPassword);
            RegisterLibrarian(userEmail, userPassword);
            cattempt = 2; // reset create input
            setAttempt(cattempt);// store construct attempt # in variable to be seen by main app
        }
    }

    // get the attempt number from the super
    public int getAttempt() {
        return cAttempt;
    }

    // set attempt from constructor
    public int setAttempt(int Eml) {
        return this.cAttempt = Eml;
    }

    public void Register(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "insert into users(email, password)" + "values (?, ?)";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, super.PasswordEncryption(password));
        stmt.executeUpdate();

    }

    public void RegisterLibrarian(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "insert into librarians(email, password)" + "values (?, ?)";
        PreparedStatement stmt = getConnect().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, super.PasswordEncryption(password));
        stmt.executeUpdate();
    }
}
