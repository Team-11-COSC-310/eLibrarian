import java.util.Scanner;

public class LoggedIn {
    // 
    private String userChoice="";
    Scanner reader = new Scanner(System.in);

    public LoggedIn(int attempt) {
        if (attempt == 1) {
            System.out.println("What would you like to do? (enter 'B','S' or 'U'): ");
		    setChoice(reader.next());
        }
        
    }
    public String getChoice() {
        return userChoice;
	}
	// set input from user (their choice of what to do)
	public String setChoice(String Eml) {
		return this.userChoice = Eml;
	}
}
