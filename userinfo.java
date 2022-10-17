import java.util.*;
/* This is going check if logged in,
    to display the user's:
    Email
    Password
    Waitlists they're on
    Borrow History?
If not logged in, Prompt to 
*/

// check login info and display info or get them to login in
public static void main(){ 
		if(this.authentication) {
            String disinfo = User.toString(); //take user's info and stick it in string variable
			System.out.println("User: \n" + disinfo); //display info
		}else {
			System.out.println("Please login to view your account information."); //prompt to login
            //Login(); 
		}
}