import java.util.*;
/* This is going check if logged in,
    to display the user's:
    Email
    Password
    Waitlists they're on
    Currently Borrowed books?
If not logged in, Prompt to 
*/

// check login info and display info or get them to login in
public static void main(){ 
		if(this.authentication) { //if logged in
            String disinfo = User.toString(); //take user's info (FROM User class) and stick it in string variable
			System.out.println("User: \n" + disinfo); //display info

            //need to get book's info of waitlists the user is on
            /*
            String wlnames;
            for (int i=0; i<BookList.size(); i++){
                //if the looged in user appears on any waitlists in the database, 
                //then add that book's name to string
                if (user = Booklist user) {
                    wlnames += getBookTitle();
            }
        
            System.out.println("User is currently on wailtists for: " +wlnames); //display book titles
            */

            //need to get books currently rented

            //Ask user to edit password
            System.out.println("Do you want to edit your password? Y or N");
		    if (reader.next() == "Y") { //if input it yes, prompt for new password
                System.out.println("Enter New Password");
		        setPassword(reader.next()); //set password to new input
            }
            else if (reader.next() == "N"){ //if input is no, stop asking
                System.out.println("You did not edit your Password.");
                break;
            }
            else { //if invalid entry, break 
                System.out.println("Please enter valid response (Y or N).");
                break;
            }
		}else {
			System.out.println("Please login to view your account information."); //prompt to login
            //Login(); 
		}
}
