import java.util.Scanner;

public class Welcome {
	Scanner reader = new Scanner(System.in);
    private String answer;

	//need to get L or C from user
	public Welcome(int purpose) {
		// Ask input from user
		if (purpose == 1) {//Reg
            System.out.println("What would you like to do? (enter 'L','C' or 'A'): ");
		    setInput(reader.next());
        } else if (purpose == 2) {//User Info
            System.out.println("What would you like to do? (enter 'C' or 'Q'): ");
		    setInput(reader.next());
        } else if (purpose == 3) {//Admin
            System.out.println("What would you like to do? (enter 'L' or 'C'): ");
		    setInput(reader.next());
        } 
	}

    // set the input
	public String setInput(String Eml) {
		return this.answer = Eml;//store user input in answer
	}
    // get the input
	public String getInput() {
		return answer;//return the user's input
	}
}