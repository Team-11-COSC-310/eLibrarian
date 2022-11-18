//import java.sql.*;
//
//public class mainapp {
	
//	public static void main (String[] args) throws SQLException, ClassNotFoundException {
//		boolean run = true;//main loop
//		boolean cwrun = true;//create welcome loop;
//		boolean crun = true;//create loop
//		boolean mmrun = true;//show main menu loop
//		boolean dbrun = true;//show DATABASE of books loop
//		boolean urun = true;//show user INFO loop
//		boolean arun2 = true;//search action INPUT loop
//		boolean srun = true;//show book SEARCH loop
//		boolean sbrun = true;//show search results and view selected book
//		boolean uirun = true;//user INPUT info loop
//		boolean brun = true;//book view loop
//		boolean arun = true;//action INPUT loop
//		boolean librun = true;//show LIBRARIAN SCREEN loop
//		boolean larun = true;//show ADD or EDIT BOOK loop
//		
//		
//
//		//need these to eval the user's input
//		String l = new String("L"); //<--/ Login
//		String c = new String("C"); //<--/ Create user
//		String r = new String("R"); //<--/ Librarian login function as regular user (ADMINS)
//		String ru = new String("RU"); //<--/ Create regular user acccount
//		String lu = new String("LU"); //<--/ Create librarian account
//		String admin = new String("A"); //<--/ Librarian login function (ADMINS)
//		String addBooks = new String("AddBooks"); //<--/ Librarian login function (ADMINS)
//		String editBooks = new String("EditBooks"); //<--/ Librarian login function (ADMINS)
//		String deleteUsers = new String("DeleteUsers"); //<--/ Librarian login function (ADMINS)
//		String updateUsers = new String("UpdateUsers"); //<--/ Librarian login function (ADMINS)
//		String q = new String("Q"); //<--/ QUIT program
//		String listbooks = new String("B"); //<--/ List library of books
//		String s = new String("S"); //<--/ Search for specific book
//		String u = new String("U"); //<--/ View User Account's info
//		String wait = new String("W"); //<--/ Join waitlist for book
//
//		int a = 1; //need to keep track of attempts to login
//		int createattempts = 1; //need to keep track of attempts to create a profile
//		int a2 = 1; //need to keep track of attempts from main menu.
//		String uname = "";//keep track of username
//		int status = 1;//trackss if user already on waitlist
//		int wtime = 0;//waitime for book in days = wlist users * 21 days
//		int searchwaitliststatus = 1;//need status to check waitlist status in the search for book loop
//		int wtime2 = 0;//waitime for book in days = wlist users * 21 days in SEARCH LOOP

//		while (run) { //Start up loop
//			//run welcome display
//			System.out.println("________________________________________________________________________\n"+
//						       "| |------------------------------------------------------------------| |\n"+
//							   "| |                                                                  | |\n"+
//						       "| |                      Welcome to eLibrarian.                      | |\n"+
//						       "| |                   Please login (ENTER 'L' KEY),                  | |\n"+
//						       "| |               OR create an account (ENTER 'C' KEY)               | |\n"+
//						       "| |                    (Input IS case sensitive).                    | |\n"+
//						       "| |                                                     'Q' to quit. | |\n"+
//						       "|_|__________________________________________________________________|_|\n");
//			Welcome w = new Welcome(1);//run START welcome to get input L,C or A
//			mmrun = true;//resets main menu loop in case you back out from admin
//			librun = true;//resets admin page if you have visited it already and try go into it again.
//			
//			//if they enter L, then go to login
//			if (w.getInput().equals(l)) { 
//				//prompt for login info and keep track of which attempt it is
//				Login log0 = new Login(a, uname);
//				//if info correct, login! If not, tell user, and prompt again
//				if(log0.HasAdminEmail()) {
//					while (librun) {//librarian admin screen loop
//						larun = true;
//						mmrun = true;//resets main menu loop in case you back out from main screen
//						System.out.println("________________________________________________________________________\n"+
//											   "| |------------------------------------------------------------------| |\n"+
//											   "| |                   Welcome to the Admin Screen.                   | |\n"+
//											  "| |      Only registered Librarians may access these functions.      | |\n"+
//											  "| |                     ENTER 'L' key to go back.                    | |\n"+
//											  "| |            ENTER 'R' key to continue as a regular user.          | |\n"+
//											   "| |            	ENTER 'C' key to continue as a librarian.            | |\n"+
//											   "| |                                                     'Q' to quit. | |\n"+
//											   "|_|__________________________________________________________________|_|\n");
//						Welcome libwelcome = new Welcome(3);//run Admin login WELCOME
//						
//						//BACK to login
//						if (libwelcome.getInput().equals(l)) { 
//							//exit libwelcome and go to main loop.
//							librun = false;
//							
//						} 
//						else if (libwelcome.getInput().equals(r)){
//							a = 1;//resets attempt number incase had to reenter password
//							System.out.println("________________________________________________________________________\n"+
//											"| |------------------------------------------------------------------| |\n"+
//											"| |                      Welcome to the Main Menu.                   | |\n"+
//											"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//											"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//											"| |                ENTER 'U' to view your account info.              | |\n"+
//											"| |                                                                  | |\n"+
//											"| | 'C' to go back to Admin.                            'Q' to quit. | |\n"+
//											"|_|__________________________________________________________________|_|\n");
//							while (mmrun) { //MAIN MENU LOOP asks user for B, S or U
//								LoggedIn li = new LoggedIn(a2);//get user's choice to look at books, search for specific book, or view account info
//								
//								if(li.getChoice().equals(listbooks)) {
//									a2 = 1;//resets attempt number incase had to re-enter input
//									String bookinfo ="";
//									dbrun = true;
//									brun = true;
//									arun = true;
//									while (dbrun) { //DATABASE LOOP gets books from database
//										BookList b = new BookList();//run booklist to list database of books
//										bookinfo = b.inventory();//get string form of list from booklist.java
//										System.out.println("________________________________________________________________________\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| |                            Database:                             | |\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| |Book Name, Author, ID:                                            | |\n"+
//													"| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													"| |                                                                  | |\n"+
//													"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													"|_|__________________________________________________________________|_|\n");
//										status = 1;//resets the user's status on if they've rented a book or joined its waitlist
//										while (brun) { //BOOK LOOP asks user for book id
//											ViewBook vb = new ViewBook();//ask user to select a book by id
//											if (vb.getInput().equals(q)) { //if they press Q to quit
//												System.out.println("Quitting...Goodbye!");
//												brun = false;//quit view book loop
//												dbrun = false;//quit db loop
//												mmrun = false;//quit mm loop
//												librun = false;//close lib loop
//												run = false;//quit main loop
//											} 
//											else if (vb.HasID()) { //if the id matches a book in the database
//												Book userBook = new Book();//start book display view
//												userBook.binfo(vb.getInput());
//												//send view input id to iterate database. Should fill values accordingly
//												System.out.println("________________________________________________________________________\n"+
//															"| |                                                                  | |\n"+
//															"| | "+userBook.getBookTitle()+"                     \n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | By: "+userBook.getBookAuthor()+"                             \n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | "+userBook.getBookSum()+"\n"+
//															"| |                                                                  | |\n"+
//															"| | "+userBook.IsBookAvailable()+"   | |\n"+
//															"| | Current Waitlist: "+userBook.getWL()+" user(s)                   \n"+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//												arun = true;//
//												while (arun) {//ACTION LOOP asks user for W or B
//													Action action = new Action(userBook.getAvailability(), userBook.borrowedBook(log0.getEmail(),vb.getInput()), userBook.inWaitlist(log0.getEmail(),vb.getInput()));//start action prompt
//
//													//IF book UNAVAILABLE AND they enter W and FIRST TRY
//													if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 1) {
//														wtime = userBook.getWL() *21;// wait time = 3 weeks times amount of people on list
//														userBook.changeWL(userBook.getWL()+1, vb.getInput());//update waitlist to include user BEFORE finding wtime
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |       Thank you for joining the waitlist. You are number "+userBook.getWL()+".      | |\n"+
//															"| |               The estimated wait time is "+wtime+" day(s).              | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														status = 2;//can't join waitlist again
//
//														wait(2000);//wait 2 seconds to print database
//														//reprint db and prompt book id again
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                            Database:                             | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |Book Name, Author, ID:                                            | |\n"+
//															"| |------------------------------------------------------------------| |\n"
//																+bookinfo+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														arun = false;//exit action loop
//														//GO BACK TO DATABASE
//													}
//													//IF book UNAVAILABLE AND they are ALREADY ON waitlist
//													else if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 2) {
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |       You are already on the waitlist. You are number "+userBook.getWL()+".      \n"+
//															"| |              The estimated wait time is "+wtime+" day(s).              \n"+
//															"|_|__________________________________________________________________|_|\n");
//
//														wait(2000);//wait 2 seconds to print database
//														//reprint db and prompt book id again
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                            Database:                             | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |Book Name, Author, ID:                                            | |\n"+
//															"| |------------------------------------------------------------------| |\n"
//																+bookinfo+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														arun = false;//exit action loop
//														//GO BACK TO DATABASE
//													}//IF book UNAVAILABLE AND they are ALREADY BORROWED BOOK
//													else if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 3) {
//														System.out.println("________________________________________________________________________\n"+
//																				"| |------------------------------------------------------------------| |\n"+
//																			"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
//																			"| |                    It is due back in 21 day(s).                  | |\n"+
//																		"|_|__________________________________________________________________|_|\n");
//														
//														wait(2000);//wait 2 seconds to print database
//														//reprint results and prompt book id again
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                            Database:                             | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |Book Name, Author, ID:                                            | |\n"+
//															"| |------------------------------------------------------------------| |\n"
//																+bookinfo+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														arun = false;//exit action loop
//														//GO BACK TO DATABASE
//													}
//													//IF book IS AVAILABLE AND they enter B
//													else if (userBook.getAvailability() && action.getInput().equals(listbooks)) {
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                         Enjoy the book!                          | |\n"+
//															"| |                  It is due back in: 21 day(s).                   | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														userBook.changeAvailability(false, vb.getInput());//close book's availablity
//														userBook.changeWL(userBook.getWL()+1, vb.getInput());//update waitlist
//														status = 3;//change the status to borrowed
//														
//														/*update book's list to inlcude user's name
//														//turn email to array in order to change array in database
//														String[] strArray = new String[] {log0.getEmail()};
//														userBook.changeNamelist(strArray, userBook.getWL(), vb.getInput());
//														System.out.println(userBook.getNamelist());*/
//
//														wait(2000);//wait 2 seconds to print database
//
//														//reprint db and prompt book id again
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                            Database:                             | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |Book Name, Author, ID:                                            | |\n"+
//															"| |------------------------------------------------------------------| |\n"
//																+bookinfo+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														arun = false;//quit action
//														//GO BACK TO DATABASE
//
//													}
//													//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to database
//													else if ((!userBook.getAvailability() || userBook.getAvailability()) && action.getInput().equals(c)) {
//														wait(2000);//wait 2 seconds to print database
//
//														//reprint db and prompt book id again
//														System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                            Database:                             | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |Book Name, Author, ID:                                            | |\n"+
//															"| |------------------------------------------------------------------| |\n"
//																+bookinfo+
//															"| |                                                                  | |\n"+
//															"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//														arun = false;//quit action
//														//GO BACK TO DATABASE
//
//													}
//													else if (action.getInput().equals(q)) {
//														//if they press Q to quit
//														System.out.println("Quitting...Goodbye!");
//														arun = false;//quit action loop
//														brun = false;//quit view book loop
//														dbrun = false;//quit db loop
//														mmrun=false;//quit main loop
//														librun = false;//close lib loop
//														run = false;//quit main loop
//													}
//												}
//											}
//											//IF viewing DB (entering id) and press C, then go back to MM
//											else if (vb.getInput().equals(c)) {
//												//run welcome display
//												System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                                                                  | |\n"+
//																"| |                      Welcome to the Main Menu.                   | |\n"+
//																"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//																"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//																"| |                ENTER 'U' to view your account info.              | |\n"+
//																"| |                                                                  | |\n"+
//																"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//												arun = false;
//												brun = false;//quit book view loop
//												dbrun = false;//go back
//												//GO BACK TO MAIN MENU
//					
//											}
//											else {
//												System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |     Invalid input. Please re-enter a book's id from the list.    | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//												wait(5000);//wait 5 seconds to prompt
//											}
//										}
//									}
//								//if user selects Search from Main Menu
//								} else if(li.getChoice().equals(s)) { 
//									srun = true;
//									System.out.println("________________________________________________________________________\n"+
//													"| |                           Book Search                            | |\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| |  Please enter the book's title OR author you would like to find. | |\n"+
//													"| |                    ONLY enter Title OR Author!                   | |\n"+
//													"| |                  Note that it IS case sensitive.                 | |\n"+
//													"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													"|_|__________________________________________________________________|_|\n");
//									while (srun) {
//										Search bs = new Search(); //new book search input needed
//										
//										if (bs.getSInput().equals(q)) { //if they press Q to quit
//											System.out.println("Quitting...Goodbye!");
//											srun = false;//quit db loop
//											mmrun = false;//quit mm loop
//											librun = false;//close lib loop
//											run = false;//quit main loop
//										}
//										//If inputted C to go BACK TO MM
//										else if (bs.getSInput().equals(c)) { //
//											System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                                                                  | |\n"+
//																"| |                      Welcome to the Main Menu.                   | |\n"+
//																"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//																"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//																"| |                ENTER 'U' to view your account info.              | |\n"+
//																"| |                                                                  | |\n"+
//																"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//											srun = false;//quit search input loop
//										}
//										//If info matches book title OR author in system
//										else if (bs.IsValid()) {
//											//display book info and what to do
//											String searchinfo = "";
//											BookList searchlist = new BookList();//run booklist to list books MATCHING INPUT
//											searchinfo = searchlist.searchInventory(bs.getSInput());//get string form of list from booklist.java
//											System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| | Book Name, Author, ID:                                           | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//											sbrun = true;
//											searchwaitliststatus = 1;//reset search action status
//											while (sbrun) { //Search BOOK LOOP asks user for book id
//												ViewBook vb2 = new ViewBook();//ask user to select a book by id FROM SEARCH RESULTS
//												if (vb2.getInput().equals(q)) { //if they press Q to quit
//													System.out.println("Quitting...Goodbye!");
//													sbrun = false;//quit view book loop
//													srun = false;//quit db loop
//													mmrun = false;//quit mm loop
//													librun = false;//close lib loop
//													run = false;//quit main loop
//												} 
//												else if (vb2.getInput().equals(c)) { //if they press C to go back to SEARCH
//													System.out.println("________________________________________________________________________\n"+
//																		"| |                           Book Search                            | |\n"+
//																		"| |------------------------------------------------------------------| |\n"+
//																		"| |  Please enter the book's title OR author you would like to find. | |\n"+
//																		"| |                    ONLY enter Title OR Author!                   | |\n"+
//																		"| |                  Note that it IS case sensitive.                 | |\n"+
//																		"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																		"|_|__________________________________________________________________|_|\n");
//													sbrun = false;//quit view book loop
//												} 
//												else if (vb2.HasID()) { //if the id matches a book in the results
//													Book userBook2 = new Book();//start book display view
//													userBook2.binfo(vb2.getInput());//get info for book matching the entered ID
//													//send view input id to iterate database. Should fill values accordingly
//													System.out.println("________________________________________________________________________\n"+
//																	"| |                                                                  | |\n"+
//																	"| | "+userBook2.getBookTitle()+"                     \n"+
//																	"| |------------------------------------------------------------------| |\n"+
//																	"| | By: "+userBook2.getBookAuthor()+"                             \n"+
//																	"| |------------------------------------------------------------------| |\n"+
//																	"| | "+userBook2.getBookSum()+"\n"+
//																	"| |                                                                  | |\n"+
//																	"| | "+userBook2.IsBookAvailable()+"   | |\n"+
//																	"| | Current Waitlist: "+userBook2.getWL()+" user(s)                   \n"+
//																	"| |                                                                  | |\n"+
//																	"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																	"|_|__________________________________________________________________|_|\n");
//													arun2 = true;
//													while (arun2) {//ACTION LOOP asks user for W or B
//														Action action2 = new Action(userBook2.getAvailability(), userBook2.borrowedBook(log0.getEmail(),vb2.getInput()), userBook2.inWaitlist(log0.getEmail(),vb2.getInput()));//start action prompt
//								
//														//IF book UNAVAILABLE AND they HAVENT borrowed it ANYWHERE, and they enter W
//														if (!userBook2.getAvailability() && action2.getInput().equals(wait) && searchwaitliststatus == 1) {
//															wtime2 = userBook2.getWL() *21;// wait time = 3 weeks times amount of people on list
//															userBook2.changeWL(userBook2.getWL()+1, vb2.getInput());//update waitlist to include user BEFORE finding wtime
//															System.out.println("________________________________________________________________________\n"+
//																		"| |------------------------------------------------------------------| |\n"+
//																		"| |       Thank you for joining the waitlist. You are number "+userBook2.getWL()+".      \n"+
//																		"| |               The estimated wait time is "+wtime2+" day(s).              \n"+
//																		"|_|__________________________________________________________________|_|\n");
//															searchwaitliststatus = 2;//can't join waitlist again
//								
//															wait(2000);//wait 2 seconds to print database
//															//reprint results and prompt book id again
//															System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |Book Name, Author, ID:                                            | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//															arun2 = false;//exit action loop
//															//sbrun = false;//exit book view loop
//															//GO BACK TO SEARCH RESULTS
//														}
//														//IF book UNAVAILABLE AND they are ALREADY ON waitlist from joining in search or database
//														else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && (searchwaitliststatus == 2 || status == 2)) {
//															System.out.println("________________________________________________________________________\n"+
//																			"| |------------------------------------------------------------------| |\n"+
//																			"| |       You are already on the waitlist. You are number "+userBook2.getWL()+".      \n"+
//																			"| |              The estimated wait time is "+wtime2+" day(s).              \n"+
//																			"|_|__________________________________________________________________|_|\n");
//															
//															wait(2000);//wait 2 seconds to print database
//															//reprint results and prompt book id again
//															System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |Book Name, Author, ID:                                            | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//															arun2 = false;//exit action loop
//															//sbrun = false;//exit book view loop
//															//GO BACK TO SEARCH RESULTS
//														}//IF book UNAVAILABLE AND they are ALREADY BORROWED BOOK in search OR database
//														else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && (searchwaitliststatus == 3)) {
//															System.out.println("________________________________________________________________________\n"+
//																			"| |------------------------------------------------------------------| |\n"+
//																			"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
//																			"| |                    It is due back in 21 day(s).                  | |\n"+
//																			"|_|__________________________________________________________________|_|\n");
//															
//															wait(2000);//wait 2 seconds to print database
//															//reprint results and prompt book id again
//															System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |Book Name, Author, ID:                                            | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//															arun2 = false;//exit action loop
//															//sbrun = false;//exit book view loop
//															//GO BACK TO SEARCH RESULTS
//														}//IF book IS AVAILABLE AND they enter B for BORROW
//														else if (userBook2.getAvailability() && action2.getInput().equals(listbooks)) {
//															System.out.println("________________________________________________________________________\n"+
//																			"| |------------------------------------------------------------------| |\n"+
//																			"| |                         Enjoy the book!                          | |\n"+
//																			"| |                  It is due back in: 21 day(s).                   | |\n"+
//																			"|_|__________________________________________________________________|_|\n");
//															userBook2.changeAvailability(false, vb2.getInput());//close book's availablity
//															userBook2.changeWL(userBook2.getWL()+1, vb2.getInput());//update waitlist
//															searchwaitliststatus = 3;//creates new waitlist output if you borrowed first and tried to join wl instead of join wl first and try again
//								
//															wait(2000);//wait 2 seconds to print database
//								
//															//reprint search results and prompt book id again
//															System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |Book Name, Author, ID:                                            | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//															arun2 = false;//quit action
//															//GO BACK TO SEARCH RESULTS
//								
//														}
//														//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to search results
//														else if ((!userBook2.getAvailability() || userBook2.getAvailability()) && action2.getInput().equals(c)) {
//															wait(2000);//wait 2 seconds to print database
//								
//															//reprint search results and prompt book id again
//															System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                          Search Results:                         | |\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |Book Name, Author, ID:                                            | |\n"+
//																"| |------------------------------------------------------------------| |\n"
//																	+searchinfo+
//																"| |                                                                  | |\n"+
//																"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//															arun2 = false;//quit action
//															//GO BACK TO SEARCH RESULTS
//								
//														}
//														else if (action2.getInput().equals(q)) {
//															//if they press Q to quit
//															System.out.println("Quitting...Goodbye!");
//															arun2 = false;//quit action loop
//															sbrun = false;//quit search view book loop
//															srun = false;//quit search results loop
//															mmrun = false;//quit main menu loop
//															librun = false;//close lib loop
//															run = false;//quit who;e program
//														}
//													
//													}//closes arun2 loop
//												//IF viewing Search results (entering id) and press C, then go back to SEARCH
//												}else if (vb2.getInput().equals(c)) {
//													//run search
//													System.out.println("________________________________________________________________________\n"+
//																		"| |                           Book Search                            | |\n"+
//																		"| |------------------------------------------------------------------| |\n"+
//																		"| |  Please enter the book's title OR author you would like to find. | |\n"+
//																		"| |                    ONLY enter Title OR Author!                   | |\n"+
//																		"| |                  Note that it IS case sensitive.                 | |\n"+
//																		"|_|__________________________________________________________________|_|\n");
//													sbrun = false;//quit search results book veiw loop
//													//GO BACK TO MAIN MENU SEARCH
//												}
//												else {
//													System.out.println("________________________________________________________________________\n"+
//																	"| |------------------------------------------------------------------| |\n"+
//																	"| |   Invalid input. Please re-enter a book's id from the results.   | |\n"+
//																	"|_|__________________________________________________________________|_|\n");
//													wait(500);//wait 5 seconds to prompt
//												}
//											}//close sbrun 
//										}
//										//If info DOESNT MATCH book titles OR authors in system
//										else if (!bs.IsValid()) {
//											System.out.println("\n________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |        We do not have any books matching "+bs.getSInput()+" \n"+
//															"| |                    Please retry in a moment.                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//											wait(5000);//wait 5 seconds to prompt search again
//										}//close ifs to check search input
//									}//close srun loop
//								//if user selects User from Main Menu
//								} else if(li.getChoice().equals(u)) { //if they entered the wrong password but right email, prompt them for password again.
//									urun = true;
//									uirun = true;
//									while (urun) {//USER INFO loop
//										String userinfo = "";
//										User user = new User();//run user to list database of users
//										userinfo = user.info(log0.getEmail());//get string form of user's info from the user table
//										System.out.println("________________________________________________________________________\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| |                           Your Account:                          | |\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| | Email, Password:                                                 | |\n"+
//													"| |------------------------------------------------------------------| |\n"
//														+userinfo+
//													"| |                                                                  | |\n"+
//													"| | 'C' to go back.                                     'Q' to quit. | |\n"+
//													"|_|__________________________________________________________________|_|\n");
//										while(uirun) {
//											Welcome w1 = new Welcome(2);//run START welcome to get input again C OR Q
//											if (w1.getInput().equals(c)) {
//												//go back to MM
//												System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |                                                                  | |\n"+
//																"| |                      Welcome to the Main Menu.                   | |\n"+
//																"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//																"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//																"| |                ENTER 'U' to view your account info.              | |\n"+
//																"| |                                                                  | |\n"+
//																"| | 'C' to go back to Admin.                            'Q' to quit. | |\n"+
//																"|_|__________________________________________________________________|_|\n");
//												uirun = false;//quit user input loop
//												urun = false;//quit account info display
//											}
//											else if (w1.getInput().equals(q)) {
//												//Quit program from user page
//												System.out.println("Quitting...Goodbye!");
//												uirun = false;//quit user input loop
//												urun = false;//quit account info display
//												mmrun = false;//exit main menu loop
//												librun = false;//close lib loop
//												run = false;//exit everything
//											}
//										}
//									}
//								} else if (li.getChoice().equals(q)){ 
//									//quit from main menu
//									System.out.println("Quitting...Goodbye!");
//									mmrun = false;//exit main menu loop
//									librun = false;//close lib loop
//									run = false;//exit everything
//
//								} else if (li.getChoice().equals(c)){ //if entering c at main menu GO TO START UP
//									//Back from main menu
//									mmrun = false;//exit main menu loop
//								}
//								else {
//									System.out.println("________________________________________________________________________\n"+
//												"| |------------------------------------------------------------------| |\n"+
//												"| |                          Invalid input.                          | |\n"+
//												"|_|__________________________________________________________________|_|\n");
//									a2=2;
//								}
//							}//CLOSE MAIN MENU
//					
//						}//CONTINUE
//						else if (libwelcome.getInput().equals(c)){ 
//							//run add book
//							while (larun) {//librarian action loop
//								LibrarianAction la = new LibrarianAction(a, uname); //logins AND creates book in DB
//								if(la.HasRegistry() && la.in.equals(addBooks)) { //if admin exists, login as librarian AND ADD then add book
//									Book adminBook = new Book();//start book display view of CREATED book
//									adminBook.binfo(la.getId());//get info for book matching the entered ID
//									//send newest id to iterate database. Should fill values accordingly with NEW BOOK
//									System.out.println("________________________________________________________________________\n"+
//															"| |                 You Book was Successfully Added!                 | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                                                                  | |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									//System.out.println("________________________________________________________________________\n"+
//										// 					"| |                 You Book was Successfully Added!                 | |\n"+
//										// 					"| |------------------------------------------------------------------| |\n"+
//										// 					"| | "+adminBook.getBookTitle()+"                     \n"+
//										// 					"| |------------------------------------------------------------------| |\n"+
//										// 					"| | By: "+adminBook.getBookAuthor()+"                             \n"+
//										// 					"| |------------------------------------------------------------------| |\n"+
//										// 					"| | "+adminBook.getBookSum()+"\n"+
//										// 					"| |                                                                  | |\n"+
//										// 					"| | It is available now!                                             | |\n"+
//										// 					"| | Current Waitlist: "+adminBook.getWL()+" user(s)                   \n"+
//										// 					"| |                                                                  | |\n"+
//										// 					"| | Returning to Admin screen...                                     | |\n"+
//										// 					"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//													   
//													   
//								} else if (la.HasRegistry() && la.in.equals(editBooks) && la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE BOOK then add book
//									Book adminBook = new Book();//start book display view of DELETED book
//									adminBook.binfo(la.getId());//get info for book matching the entered ID
//									//send newest id to iterate database. Should fill values accordingly with BOOK to delete
//									System.out.println("________________________________________________________________________\n"+
//															"| |                       You Book was Deleted!                      | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//													   
//
//								} else if (la.HasRegistry() && la.in.equals(updateUsers) && la.in2.equals("Librarian")) { //if admin exists, login as librarian AND UPDATE USER then add user
//									User adminUser = new User();//start user display view of UPDATE user
//									adminUser.info(la.getEmail());//get info for user matching the entered email
//									System.out.println("________________________________________________________________________\n"+
//															"| |                     Librarian has been Updated!                  | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//
//
//								} else if (la.HasRegistry() && la.in.equals(updateUsers) && la.in2.equals("User")) { //if admin exists, login as librarian AND UPDATE USER then add user
//									User adminUser = new User();//start user display view of UPDATE user
//									adminUser.info(la.getEmail());//get info for user matching the entered email
//									System.out.println("________________________________________________________________________\n"+
//															"| |                       User has been Updated!                     | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//													   
//													   					   
//								} else if (la.HasRegistry() && la.in.equals(deleteUsers) && la.in2.equals("Librarian")) { //if admin exists, login as librarian AND DELETE USER then add user
//									User adminUser = new User();//start user display view of DELETE user
//									adminUser.info(la.getEmail());//get info for user matching the entered email
//									System.out.println("________________________________________________________________________\n"+
//															"| |                     Librarian has been Deleted!                  | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//
//
//								} else if (la.HasRegistry() && la.in.equals(deleteUsers) && la.in2.equals("User")) { //if admin exists, login as librarian AND DELETE USER then add user
//									User adminUser = new User();//start user display view of DELETE user
//									adminUser.info(la.getEmail());//get info for user matching the entered email
//									System.out.println("________________________________________________________________________\n"+
//															"| |                       User has been Deleted!                     | |\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//
//
//								} else if (la.HasRegistry() && la.in.equals(editBooks) && !la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE then add book
//									//need to enter Delete properly
//									System.out.println("________________________________________________________________________\n"+
//															"| | Command "+la.in2+" not recognized, please retry!\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//													   
//													   
//								} else if(la.HasRegistry() && la.in.equals(updateUsers) && !la.in2.equals("User") && !la.in2.equals("Librarian")) { //if admin exists, but update email name does not exsits
//									System.out.println("________________________________________________________________________\n"+
//															"| | User/Librarian email does not exist in the database, please retry!\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//									
//								
//								} else if(la.HasRegistry() && la.in.equals(deleteUsers) && !la.in2.equals("User") && !la.in2.equals("Librarian")) { //if admin exists, but delete email name does not exsits
//									System.out.println("________________________________________________________________________\n"+
//															"| | User/Librarian email does not exist in the database, please retry!\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| | Returning to Admin screen...                                     | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									wait(2000);//wait 2 before returning 
//									larun = false;//take user back to admin edit or add screen
//									
//								} else if(la.HasEmail()) { //if they entered the wrong password but right email, prompt them for password again.
//									a = 2; uname = la.getEmail(); //send correct email to next login
//								} else if(!la.HasEmail()) { //if they entered an invalid email, prompt them for input again
//									a = 3;
//									System.out.println("\nThat account does not exist. Please Retry.");
//								} else {
//									System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |                    No account matched...Quiting                  | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//									larun = false;//exit lib action run loop
//									librun = false;//exit librarian run loop
//									run = false;//exit main run loop
//								}	
//								
//							}
//			
//						}//QUIT	from librarian loop
//						else if (libwelcome.getInput().equals(q)){ 
//							//quit from librarian welcome screen
//							System.out.println("Quitting...Goodbye!");
//							librun = false;//close lib loop
//							run = false;//exit create welcome loop
//						}
//						else { //catches bad input
//							System.out.println("________________________________________________________________________\n"+
//												   "| |------------------------------------------------------------------| |\n"+
//												"| |            Invalid input. Please enter 'L','R', or 'C'.          | |\n"+
//												"| |                                                     'Q' to quit. | |\n"+
//												"|_|__________________________________________________________________|_|\n");
//						}
//					}
//				}
//				else if(log0.HasRegistry()) {
//					a = 1;//resets attempt number incase had to reenter password
//					System.out.println("________________________________________________________________________\n"+
//					                   "| |------------------------------------------------------------------| |\n"+
//					                   "| |                           Login success.                         | |\n"+
//					                   "| |                      Welcome to the Main Menu.                   | |\n"+
//					                   "| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//					                   "| |         ENTER 'S' to search for a book from the database.        | |\n"+
//					                   "| |                ENTER 'U' to view your account info.              | |\n"+
//									   "| |                                                                  | |\n"+
//					                   "| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//					                   "|_|__________________________________________________________________|_|\n");
//					while (mmrun) { //MAIN MENU LOOP asks user for B, S or U
//						LoggedIn li = new LoggedIn(a2);//get user's choice to look at books, search for specific book, or view account info
//						
//						if(li.getChoice().equals(listbooks)) {
//							a2 = 1;//resets attempt number incase had to re-enter input
//							String bookinfo ="";
//							dbrun = true;
//							brun = true;
//							arun = true;
//							while (dbrun) { //DATABASE LOOP gets books from database
//								BookList b = new BookList();//run booklist to list database of books
//								bookinfo = b.inventory();//get string form of list from booklist.java
//								System.out.println("________________________________________________________________________\n"+
//										       "| |------------------------------------------------------------------| |\n"+
//										       "| |                            Database:                             | |\n"+
//										       "| |------------------------------------------------------------------| |\n"+
//										       "| |Book Name, Author, ID:                                            | |\n"+
//										       "| |------------------------------------------------------------------| |\n"
//								                +bookinfo+
//											   "| |                                                                  | |\n"+
//											   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       "|_|__________________________________________________________________|_|\n");
//								status = 1;//resets the user's status on if they've rented a book or joined its waitlist
//								while (brun) { //BOOK LOOP asks user for book id
//									ViewBook vb = new ViewBook();//ask user to select a book by id
//									if (vb.getInput().equals(q)) { //if they press Q to quit
//										System.out.println("Quitting...Goodbye!");
//										brun = false;//quit view book loop
//										dbrun = false;//quit db loop
//										mmrun = false;//quit mm loop
//										run = false;//quit main loop
//									} 
//									else if (vb.HasID()) { //if the id matches a book in the database
//										Book userBook = new Book();//start book display view
//										userBook.binfo(vb.getInput());
//										//send view input id to iterate database. Should fill values accordingly
//										System.out.println("________________________________________________________________________\n"+
//									                   "| |                                                                  | |\n"+
//									                   "| | "+userBook.getBookTitle()+"                     \n"+
//						                       	   	   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| | By: "+userBook.getBookAuthor()+"                             \n"+
//													   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| | "+userBook.getBookSum()+"\n"+
//													   "| |                                                                  | |\n"+
//													   "| | "+userBook.IsBookAvailable()+"   | |\n"+
//													   "| | Current Waitlist: "+userBook.getWL()+" user(s)                   \n"+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//						                       	       "|_|__________________________________________________________________|_|\n");
//										arun = true;//
//										while (arun) {//ACTION LOOP asks user for W or B
//											Action action = new Action(userBook.getAvailability(),userBook.borrowedBook(log0.getEmail(),vb.getInput()), userBook.inWaitlist(log0.getEmail(),vb.getInput()));//start action prompt
//
//											//IF book UNAVAILABLE AND they enter W and FIRST TRY
//											if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 1) {
//												wtime = userBook.getWL() *21;// wait time = 3 weeks times amount of people on list
//												userBook.changeWL(userBook.getWL()+1, vb.getInput());//update waitlist to include user BEFORE finding wtime
//												System.out.println("________________________________________________________________________\n"+
//						                       	   	   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| |       Thank you for joining the waitlist. You are number "+userBook.getWL()+".      | |\n"+
//						                       	       "| |               The estimated wait time is "+wtime+" day(s).              | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												status = 2;//can't join waitlist again
//
//												wait(2000);//wait 2 seconds to print database
//												//reprint db and prompt book id again
//												System.out.println("________________________________________________________________________\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |                            Database:                             | |\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |Book Name, Author, ID:                                            | |\n"+
//													   "| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												arun = false;//exit action loop
//												//GO BACK TO DATABASE
//											}
//											//IF book UNAVAILABLE AND they are ALREADY ON waitlist
//											else if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 2) {
//												System.out.println("________________________________________________________________________\n"+
//						                       	   	   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| |       You are already on the waitlist. You are number "+userBook.getWL()+".      \n"+
//						                       	       "| |              The estimated wait time is "+wtime+" day(s).              \n"+
//													   "|_|__________________________________________________________________|_|\n");
//
//												wait(2000);//wait 2 seconds to print database
//												//reprint db and prompt book id again
//												System.out.println("________________________________________________________________________\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |                            Database:                             | |\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |Book Name, Author, ID:                                            | |\n"+
//													   "| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												arun = false;//exit action loop
//												//GO BACK TO DATABASE
//											}//IF book UNAVAILABLE AND they are ALREADY BORROWED BOOK
//											else if (!userBook.getAvailability() && action.getInput().equals(wait) && status == 3) {
//												System.out.println("________________________________________________________________________\n"+
//																		 "| |------------------------------------------------------------------| |\n"+
//																	  "| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
//																	  "| |                    It is due back in 21 day(s).                  | |\n"+
//																   "|_|__________________________________________________________________|_|\n");
//												
//												wait(2000);//wait 2 seconds to print database
//												//reprint results and prompt book id again
//												System.out.println("________________________________________________________________________\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |                            Database:                             | |\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |Book Name, Author, ID:                                            | |\n"+
//													   "| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												arun = false;//exit action loop
//												//GO BACK TO DATABASE
//											}
//											//IF book IS AVAILABLE AND they enter B
//											else if (userBook.getAvailability() && action.getInput().equals(listbooks)) {
//												System.out.println("________________________________________________________________________\n"+
//						                       	   	   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| |                         Enjoy the book!                          | |\n"+
//						                       	       "| |                  It is due back in: 21 day(s).                   | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												userBook.changeAvailability(false, vb.getInput());//close book's availablity
//												userBook.changeWL(userBook.getWL()+1, vb.getInput());//update waitlist
//												status = 3;//change the status to borrowed
//												
//												/*update book's list to inlcude user's name
//												//turn email to array in order to change array in database
//												String[] strArray = new String[] {log0.getEmail()};
//												userBook.changeNamelist(strArray, userBook.getWL(), vb.getInput());
//												System.out.println(userBook.getNamelist());*/
//
//												wait(2000);//wait 2 seconds to print database
//
//												//reprint db and prompt book id again
//												System.out.println("________________________________________________________________________\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |                            Database:                             | |\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |Book Name, Author, ID:                                            | |\n"+
//													   "| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												arun = false;//quit action
//												//GO BACK TO DATABASE
//
//											}
//											//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to database
//											else if ((!userBook.getAvailability() || userBook.getAvailability()) && action.getInput().equals(c)) {
//												wait(2000);//wait 2 seconds to print database
//
//												//reprint db and prompt book id again
//												System.out.println("________________________________________________________________________\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |                            Database:                             | |\n"+
//													   "| |------------------------------------------------------------------| |\n"+
//													   "| |Book Name, Author, ID:                                            | |\n"+
//													   "| |------------------------------------------------------------------| |\n"
//														+bookinfo+
//													   "| |                                                                  | |\n"+
//													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//													   "|_|__________________________________________________________________|_|\n");
//												arun = false;//quit action
//												//GO BACK TO DATABASE
//
//											}
//											else if (action.getInput().equals(q)) {
//												//if they press Q to quit
//												System.out.println("Quitting...Goodbye!");
//												arun = false;//quit action loop
//												brun = false;//quit view book loop
//												dbrun = false;//quit db loop
//												mmrun=false;//quit main loop
//												run = false;//quit main loop
//											}
//										}
//									}
//									//IF viewing DB (entering id) and press C, then go back to MM
//									else if (vb.getInput().equals(c)) {
//										//run welcome display
//										System.out.println("________________________________________________________________________\n"+
//														"| |------------------------------------------------------------------| |\n"+
//														"| |                                                                  | |\n"+
//														"| |                      Welcome to the Main Menu.                   | |\n"+
//					                   					"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//					                   					"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//					                   					"| |                ENTER 'U' to view your account info.              | |\n"+
//														"| |                                                                  | |\n"+
//														"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//														"|_|__________________________________________________________________|_|\n");
//										arun = false;
//										brun = false;//quit book view loop
//										dbrun = false;//go back
//										//GO BACK TO MAIN MENU
//			
//									}
//									else {
//										System.out.println("________________________________________________________________________\n"+
//						                       	   	   "| |------------------------------------------------------------------| |\n"+
//						                       	       "| |     Invalid input. Please re-enter a book's id from the list.    | |\n"+
//						                       	       "|_|__________________________________________________________________|_|\n");
//										wait(5000);//wait 5 seconds to prompt
//							    	}
//								}
//							}
//						//if user selects Search from Main Menu
//						} else if(li.getChoice().equals(s)) { 
//							srun = true;
//							System.out.println("________________________________________________________________________\n"+
//							                   "| |                           Book Search                            | |\n"+
//						                       "| |------------------------------------------------------------------| |\n"+
//						                       "| |  Please enter the book's title OR author you would like to find. | |\n"+
//											   "| |                    ONLY enter Title OR Author!                   | |\n"+
//											   "| |                  Note that it IS case sensitive.                 | |\n"+
//											   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//						                       "|_|__________________________________________________________________|_|\n");
//							while (srun) {
//								Search bs = new Search(); //new book search input needed
//								
//								if (bs.getSInput().equals(q)) { //if they press Q to quit
//									System.out.println("Quitting...Goodbye!");
//									srun = false;//quit db loop
//									mmrun = false;//quit mm loop
//									run = false;//quit main loop
//								}
//								//If inputted C to go BACK TO MM
//								else if (bs.getSInput().equals(c)) { //
//									System.out.println("________________________________________________________________________\n"+
//														"| |------------------------------------------------------------------| |\n"+
//														"| |                                                                  | |\n"+
//														"| |                      Welcome to the Main Menu.                   | |\n"+
//					                   					"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//					                   					"| |         ENTER 'S' to search for a book from the database.        | |\n"+
//					                   					"| |                ENTER 'U' to view your account info.              | |\n"+
//														"| |                                                                  | |\n"+
//														"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//														"|_|__________________________________________________________________|_|\n");
//									srun = false;//quit search input loop
//								}
//								//If info matches book title OR author in system
//								else if (bs.IsValid()) {
//									//display book info and what to do
//									String searchinfo = "";
//									BookList searchlist = new BookList();//run booklist to list books MATCHING INPUT
//									searchinfo = searchlist.searchInventory(bs.getSInput());//get string form of list from booklist.java
//									System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| | Book Name, Author, ID:                                           | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//									sbrun = true;
//									searchwaitliststatus = 1;//reset search action status
//									while (sbrun) { //Search BOOK LOOP asks user for book id
//										ViewBook vb2 = new ViewBook();//ask user to select a book by id FROM SEARCH RESULTS
//										if (vb2.getInput().equals(q)) { //if they press Q to quit
//											System.out.println("Quitting...Goodbye!");
//											sbrun = false;//quit view book loop
//											srun = false;//quit db loop
//											mmrun = false;//quit mm loop
//											run = false;//quit main loop
//										} 
//										else if (vb2.getInput().equals(c)) { //if they press C to go back to SEARCH
//											System.out.println("________________________________________________________________________\n"+
//							                   					"| |                           Book Search                            | |\n"+
//						                       					"| |------------------------------------------------------------------| |\n"+
//						                       					"| |  Please enter the book's title OR author you would like to find. | |\n"+
//											   					"| |                    ONLY enter Title OR Author!                   | |\n"+
//											   					"| |                  Note that it IS case sensitive.                 | |\n"+
//											   					"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//						                       					"|_|__________________________________________________________________|_|\n");
//											sbrun = false;//quit view book loop
//										} 
//										else if (vb2.HasID()) { //if the id matches a book in the results
//											Book userBook2 = new Book();//start book display view
//											userBook2.binfo(vb2.getInput());//get info for book matching the entered ID
//											//send view input id to iterate database. Should fill values accordingly
//											System.out.println("________________________________________________________________________\n"+
//															 "| |                                                                  | |\n"+
//															 "| | "+userBook2.getBookTitle()+"                     \n"+
//															 "| |------------------------------------------------------------------| |\n"+
//														     "| | By: "+userBook2.getBookAuthor()+"                             \n"+
//															 "| |------------------------------------------------------------------| |\n"+
//															 "| | "+userBook2.getBookSum()+"\n"+
//															 "| |                                                                  | |\n"+
//															 "| | "+userBook2.IsBookAvailable()+"   | |\n"+
//															 "| | Current Waitlist: "+userBook2.getWL()+" user(s)                   \n"+
//															 "| |                                                                  | |\n"+
//															 "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//															 "|_|__________________________________________________________________|_|\n");
//											arun2 = true;
//											while (arun2) {//ACTION LOOP asks user for W or B
//												Action action2 = new Action(userBook2.getAvailability(), userBook2.borrowedBook(log0.getEmail(),vb2.getInput()), userBook2.inWaitlist(log0.getEmail(),vb2.getInput()));//start action prompt
//						
//												//IF book UNAVAILABLE AND they HAVENT borrowed it ANYWHERE, and they enter W
//												if (!userBook2.getAvailability() && action2.getInput().equals(wait) && searchwaitliststatus == 1) {
//													wtime2 = userBook2.getWL() *21;// wait time = 3 weeks times amount of people on list
//													userBook2.changeWL(userBook2.getWL()+1, vb2.getInput());//update waitlist to include user BEFORE finding wtime
//													System.out.println("________________________________________________________________________\n"+
//																"| |------------------------------------------------------------------| |\n"+
//																"| |       Thank you for joining the waitlist. You are number "+userBook2.getWL()+".      \n"+
//																"| |               The estimated wait time is "+wtime2+" day(s).              \n"+
//																"|_|__________________________________________________________________|_|\n");
//													searchwaitliststatus = 2;//can't join waitlist again
//						
//													wait(2000);//wait 2 seconds to print database
//													//reprint results and prompt book id again
//													System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |Book Name, Author, ID:                                            | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//													arun2 = false;//exit action loop
//													//sbrun = false;//exit book view loop
//													//GO BACK TO SEARCH RESULTS
//												}
//												//IF book UNAVAILABLE AND they are ALREADY ON waitlist from joining in search or database
//												else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && (searchwaitliststatus == 2 || status == 2)) {
//													System.out.println("________________________________________________________________________\n"+
//						                       	   	   				"| |------------------------------------------------------------------| |\n"+
//						                       	       				"| |       You are already on the waitlist. You are number "+userBook2.getWL()+".      \n"+
//						                       	       				"| |              The estimated wait time is "+wtime2+" day(s).              \n"+
//													   				"|_|__________________________________________________________________|_|\n");
//													
//													wait(2000);//wait 2 seconds to print database
//													//reprint results and prompt book id again
//													System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |Book Name, Author, ID:                                            | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//													arun2 = false;//exit action loop
//													//sbrun = false;//exit book view loop
//													//GO BACK TO SEARCH RESULTS
//												}//IF book UNAVAILABLE AND they are ALREADY BORROWED BOOK in search OR database
//												else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && (searchwaitliststatus == 3)) {
//													System.out.println("________________________________________________________________________\n"+
//						                       	   	   				"| |------------------------------------------------------------------| |\n"+
//						                       	       				"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
//						                       	       				"| |                    It is due back in 21 day(s).                  | |\n"+
//													   				"|_|__________________________________________________________________|_|\n");
//													
//													wait(2000);//wait 2 seconds to print database
//													//reprint results and prompt book id again
//													System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |Book Name, Author, ID:                                            | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//													arun2 = false;//exit action loop
//													//sbrun = false;//exit book view loop
//													//GO BACK TO SEARCH RESULTS
//												}//IF book IS AVAILABLE AND they enter B for BORROW
//												else if (userBook2.getAvailability() && action2.getInput().equals(listbooks)) {
//													System.out.println("________________________________________________________________________\n"+
//																	   "| |------------------------------------------------------------------| |\n"+
//																	   "| |                         Enjoy the book!                          | |\n"+
//																	   "| |                  It is due back in: 21 day(s).                   | |\n"+
//																	   "|_|__________________________________________________________________|_|\n");
//													userBook2.changeAvailability(false, vb2.getInput());//close book's availablity
//													userBook2.changeWL(userBook2.getWL()+1, vb2.getInput());//update waitlist
//													searchwaitliststatus = 3;//creates new waitlist output if you borrowed first and tried to join wl instead of join wl first and try again
//						
//													wait(2000);//wait 2 seconds to print database
//						
//													//reprint search results and prompt book id again
//													System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |Book Name, Author, ID:                                            | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//													arun2 = false;//quit action
//													//GO BACK TO SEARCH RESULTS
//						
//												}
//												//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to search results
//												else if ((!userBook2.getAvailability() || userBook2.getAvailability()) && action2.getInput().equals(c)) {
//													wait(2000);//wait 2 seconds to print database
//						
//													//reprint search results and prompt book id again
//													System.out.println("________________________________________________________________________\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |                          Search Results:                         | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"+
//										       			"| |Book Name, Author, ID:                                            | |\n"+
//										       			"| |------------------------------------------------------------------| |\n"
//								                			+searchinfo+
//											   			"| |                                                                  | |\n"+
//											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
//										       			"|_|__________________________________________________________________|_|\n");
//													arun2 = false;//quit action
//													//GO BACK TO SEARCH RESULTS
//						
//												}
//												else if (action2.getInput().equals(q)) {
//													//if they press Q to quit
//													System.out.println("Quitting...Goodbye!");
//													arun2 = false;//quit action loop
//													sbrun = false;//quit search view book loop
//													srun = false;//quit search results loop
//													mmrun = false;//quit main menu loop
//													run = false;//quit who;e program
//												}
//											
//											}//closes arun2 loop
//										//IF viewing Search results (entering id) and press C, then go back to SEARCH
//										}else if (vb2.getInput().equals(c)) {
//											//run search
//											System.out.println("________________________________________________________________________\n"+
//							                   					"| |                           Book Search                            | |\n"+
//						                       					"| |------------------------------------------------------------------| |\n"+
//						                       					"| |  Please enter the book's title OR author you would like to find. | |\n"+
//											   					"| |                    ONLY enter Title OR Author!                   | |\n"+
//											   					"| |                  Note that it IS case sensitive.                 | |\n"+
//						                       					"|_|__________________________________________________________________|_|\n");
//											sbrun = false;//quit search results book veiw loop
//											//GO BACK TO MAIN MENU SEARCH
//										}
//										else {
//											System.out.println("________________________________________________________________________\n"+
//															"| |------------------------------------------------------------------| |\n"+
//															"| |   Invalid input. Please re-enter a book's id from the results.   | |\n"+
//															"|_|__________________________________________________________________|_|\n");
//											wait(500);//wait 5 seconds to prompt
//										}
//									}//close sbrun 
//								}
//								//If info DOESNT MATCH book titles OR authors in system
//								else if (!bs.IsValid()) {
//									System.out.println("\n________________________________________________________________________\n"+
//													"| |------------------------------------------------------------------| |\n"+
//													"| |        We do not have any books matching "+bs.getSInput()+" \n"+
//													"| |                    Please retry in a moment.                     | |\n"+
//													"|_|__________________________________________________________________|_|\n");
//									wait(5000);//wait 5 seconds to prompt search again
//								}//close ifs to check search input
//							}//close srun loop
//						//if user selects User from Main Menu
//						} else if(li.getChoice().equals(u)) { //if they entered the wrong password but right email, prompt them for password again.
//							urun = true;
//							uirun = true;
//							while (urun) {//USER INFO loop
//								String userinfo = "";
//								User user = new User();//run user to list database of users
//								userinfo = user.info(log0.getEmail());//get string form of user's info from the user table
//								System.out.println("________________________________________________________________________\n"+
//										       "| |------------------------------------------------------------------| |\n"+
//										       "| |                           Your Account:                          | |\n"+
//										       "| |------------------------------------------------------------------| |\n"+
//										       "| | Email, Password:                                                 | |\n"+
//										       "| |------------------------------------------------------------------| |\n"
//								                +userinfo+
//											   "| |                                                                  | |\n"+
//											   "| | 'C' to go back.                                     'Q' to quit. | |\n"+
//										       "|_|__________________________________________________________________|_|\n");
//								while(uirun) {
//									Welcome w1 = new Welcome(2);//run START welcome to get input again C OR Q
//									if (w1.getInput().equals(c)) {
//										//go back to MM
//										System.out.println("________________________________________________________________________\n"+
//														   "| |------------------------------------------------------------------| |\n"+
//														   "| |                                                                  | |\n"+
//														   "| |                      Welcome to the Main Menu.                   | |\n"+
//					                   					   "| |       ENTER 'B' to view the list of books from the database.     | |\n"+
//					                   					   "| |         ENTER 'S' to search for a book from the database.        | |\n"+
//					                   					   "| |                ENTER 'U' to view your account info.              | |\n"+
//														   "| |                                                                  | |\n"+
//														   "| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
//														   "|_|__________________________________________________________________|_|\n");
//										uirun = false;//quit user input loop
//										urun = false;//quit account info display
//									}
//									else if (w1.getInput().equals(q)) {
//										//Quit program from user page
//										System.out.println("Quitting...Goodbye!");
//										uirun = false;//quit user input loop
//										urun = false;//quit account info display
//										mmrun = false;//exit main menu loop
//										run = false;//exit everything
//									}
//								}
//							}
//						} else if (li.getChoice().equals(q)){ 
//							//quit from main menu
//							System.out.println("Quitting...Goodbye!");
//							mmrun = false;//exit main menu loop
//							run = false;//exit everything
//
//						} else if (li.getChoice().equals(c)){ //if entering c at main menu GO TO START UP
//							//Back from main menu
//							mmrun = false;//exit main menu loop
//						}
//						else {
//							System.out.println("________________________________________________________________________\n"+
//										   "| |------------------------------------------------------------------| |\n"+
//										   "| |                          Invalid input.                          | |\n"+
//										   "|_|__________________________________________________________________|_|\n");
//							a2=2;
//						}
//					}//CLOSE MAIN MENU
//			} else if(log0.HasEmail()) { //if they entered the wrong password but right email, prompt them for password again.
//				a = 2; uname = log0.getEmail(); //send correct email to next login
//			} else if(!log0.HasEmail()) { //if they entered an invalid email, prompt them for input again
//				a = 3;
//				System.out.println("\nThat account does not exist. Please Retry.");
//			} else {
//				System.out.println("________________________________________________________________________\n"+
//				                   	"| |------------------------------------------------------------------| |\n"+
//								    "| |                    No account matched...Quiting                  | |\n"+
//								    "|_|__________________________________________________________________|_|\n");
//				run = false;//exit main run loop
//			}
//		}//if they press C from START WELCOME, then go to create account
//		else if (w.getInput().equals(c)){ 
//			cwrun = true;
//			//continue to create account
//			while (cwrun) {
//				System.out.println("________________________________________________________________________\n"+
//								   	"| |------------------------------------------------------------------| |\n"+
//			                       	"| |                     Welcome to Create Account.                   | |\n"+
//								  	"| |          Follow the instructions below to make accounts.         | |\n"+
//								  	"| |                ENTER 'L' key to go back and login.               | |\n"+
//								   	"| |           ENTER 'RU' key to create regular user account.         | |\n"+
//									"| |             ENTER 'LU' key to create librarian account.          | |\n"+
//								   	"| |                                                     'Q' to quit. | |\n"+
//			                       	"|_|__________________________________________________________________|_|\n");
//				Welcome createwelcome = new Welcome(4);//run CREATE WELCOME
//				
//				//BACK to login
//				if (createwelcome.getInput().equals(l)) { 
//					//exit createwelcome and go to main loop.
//					cwrun = false;
//					
//				}//CONTINUE
//				else if (createwelcome.getInput().equals(ru)){ 
//					crun = true;
//					//run create
//					while (crun) {
//						Create ca = new Create(createattempts);
//						if(ca.getAttempt() == 1) { //if everything is okay, make account
//							System.out.println("________________________________________________________________________\n"+
//											   "| |------------------------------------------------------------------| |\n"+
//											   "| |                       New User Account made!                     | |\n"+
//											   "| | User Email: "+ca.getEmail()+"                                    \n"+
//											   "| | Password: "+ca.getPassword()+"                                   \n"+
//											   "|_|__________________________________________________________________| |\n");
//							crun = false;//take user back to create welcome screen to login		   	
//						} else { //if email is already in use, prompt for new input
//							createattempts = 3; //prompt to enter different email.
//						}	
//						
//					}
//	
//				}
//				else if (createwelcome.getInput().equals(lu)){
//					crun = true;
//					//run create
//					while (crun) {
//						Create ca = new Create(createattempts);
//						if(ca.getAttempt() == 2) { //if everything is okay, make account
//							System.out.println("________________________________________________________________________\n"+
//												"| |------------------------------------------------------------------| |\n"+
//												"| |                   New Librarian Account made!                    | |\n"+
//												"| | User Email: "+ca.getEmail()+"                                    \n"+
//												"| | Password: "+ca.getPassword()+"                                   \n"+
//												"|_|__________________________________________________________________| |\n");
//							crun = false;//take user back to create welcome screen to login		   	
//						} else { //if email is already in use, prompt for new input
//							createattempts = 3; //prompt to enter different email.
//						}	
//					}
//				}//QUIT	
//				else if (createwelcome.getInput().equals(q)){ 
//					//quit from welcome to CREAT ACCOUNT screen
//					System.out.println("Quitting...Goodbye!");
//					cwrun = false;//exit create loop
//					run = false;//exit program loop
//				}
//				else { //catches bad input
//					System.out.println("________________________________________________________________________\n"+
//									   	   "| |------------------------------------------------------------------| |\n"+
//									       "| |         Invalid input. Please enter 'L', 'RU' or 'LU'.           | |\n"+
//									       "| |                                                     'Q' to quit. | |\n"+
//									       "|_|__________________________________________________________________|_|\n");
//				}
//			}//closes crun	
//
//		}//closes createaccount if	
//		else if (w.getInput().equals(q)){ 
//			//quit from welcome screen
//			System.out.println("Quitting...Goodbye!");
//			run = false;//exit main loop
//		}
//		else { //catches bad input
//			System.out.println("________________________________________________________________________\n"+
//				                "| |------------------------------------------------------------------| |\n"+
//							    "| |            Invalid input. Please enter 'L' or 'C'.          	  | |\n"+
//								"| |                                                     'Q' to quit. | |\n"+
//							    "|_|__________________________________________________________________|_|\n");
//		}
//	}	
//}
//	
//public Connection dbc() throws SQLException, ClassNotFoundException{
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	String url = "jdbc:mysql://localhost:3306/ndbt11";
//	String username = "root";
//	String password ="kkato41496746";
//	Connection con = DriverManager.getConnection(url,username,password);
//	return con;
//}
//public static void wait(int ms) {
//    try
//    {
//        Thread.sleep(ms);
//    }
//    catch(InterruptedException ex)
//    {
//        Thread.currentThread().interrupt();
//    }
//}
//
//}//close entire app


/*
 * else if (w.getInput().equals(admin)){  //A from start up welcome
			//continue to admin page
			while (librun) {//librarian admin screen loop
				larun = true;
				System.out.println("________________________________________________________________________\n"+
								   	"| |------------------------------------------------------------------| |\n"+
			                       	"| |                   Welcome to the Admin Screen.                   | |\n"+
								  	"| |      Only registered Librarians may access these functions.      | |\n"+
								  	"| |                     ENTER 'L' key to go back.                    | |\n"+
								   	"| |            ENTER 'C' key to continue as a librarian.             | |\n"+
								   	"| |                                                     'Q' to quit. | |\n"+
			                       	"|_|__________________________________________________________________|_|\n");
				Welcome libwelcome = new Welcome(3);//run Admin login WELCOME
				
				//BACK to login
				if (libwelcome.getInput().equals(l)) { 
					//exit libwelcome and go to main loop.
					librun = false;
					
				}//CONTINUE
				else if (libwelcome.getInput().equals(c)){ 
					//run add book
					while (larun) {//librarian action loop
						LibrarianAction la = new LibrarianAction(a, uname); //logins AND creates book in DB
						if(la.HasRegistry() && la.in.equals(add)) { //if admin exists, login as librarian AND ADD then add book
							Book adminBook = new Book();//start book display view of CREATED book
							adminBook.binfo(la.getId());//get info for book matching the entered ID
							//send newest id to iterate database. Should fill values accordingly with NEW BOOK
							System.out.println("________________________________________________________________________\n"+
													"| |                 You Book was Successfully Added!                 | |\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| |                                                                  | |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							//System.out.println("________________________________________________________________________\n"+
								// 					"| |                 You Book was Successfully Added!                 | |\n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | "+adminBook.getBookTitle()+"                     \n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | By: "+adminBook.getBookAuthor()+"                             \n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | "+adminBook.getBookSum()+"\n"+
								// 					"| |                                                                  | |\n"+
								// 					"| | It is available now!                                             | |\n"+
								// 					"| | Current Waitlist: "+adminBook.getWL()+" user(s)                   \n"+
								// 					"| |                                                                  | |\n"+
								// 					"| | Returning to Admin screen...                                     | |\n"+
								// 					"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
											   
						} else if (la.HasRegistry() && la.in.equals(edit) && la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE then add book
							Book adminBook = new Book();//start book display view of DELETED book
							adminBook.binfo(la.getId());//get info for book matching the entered ID
							//send newest id to iterate database. Should fill values accordingly with BOOK to delete
							System.out.println("________________________________________________________________________\n"+
													"| |                       You Book was Deleted!                      | |\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
											   
						} else if (la.HasRegistry() && la.in.equals(edit) && !la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE then add book
							//need to enter Delete properly
							System.out.println("________________________________________________________________________\n"+
													"| | Command "+la.in2+" not recognized, please retry!\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
											   
						}else if(la.HasEmail()) { //if they entered the wrong password but right email, prompt them for password again.
							a = 2; uname = la.getEmail(); //send correct email to next login
						} else if(!la.HasEmail()) { //if they entered an invalid email, prompt them for input again
							a = 3;
							System.out.println("\nThat account does not exist. Please Retry.");
						} else {
							System.out.println("________________________________________________________________________\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| |                    No account matched...Quiting                  | |\n"+
													"|_|__________________________________________________________________|_|\n");
							larun = false;//exit lib action run loop
							librun = false;//exit librarian run loop
							run = false;//exit main run loop
						}	
						
					}
	
				}//QUIT	from librarian loop
				else if (libwelcome.getInput().equals(q)){ 
					//quit from librarian welcome screen
					System.out.println("Quitting...Goodbye!");
					librun = false;//close lib loop
					run = false;//exit create welcome loop
				}
				else { //catches bad input
					System.out.println("________________________________________________________________________\n"+
									   	"| |------------------------------------------------------------------| |\n"+
									    "| |            Invalid input. Please enter 'L','C', or 'A'.          | |\n"+
									    "| |                                                     'Q' to quit. | |\n"+
									    "|_|__________________________________________________________________|_|\n");
				}
			}
			
			
			
 */


//
import java.sql.*;

public class mainapp {
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		boolean run = true;//main loop
		boolean cwrun = true;//create welcome loop;
		boolean crun = true;//create loop
		boolean mmrun = true;//show main menu loop
		boolean dbrun = true;//show DATABASE of books loop
		boolean urun = true;//show user INFO loop
		boolean arun2 = true;//search action INPUT loop
		boolean srun = true;//show book SEARCH loop
		boolean sbrun = true;//show search results and view selected book
		boolean uirun = true;//user INPUT info loop
		boolean brun = true;//book view loop
		boolean arun = true;//action INPUT loop
		boolean librun = true;//show LIBRARIAN SCREEN loop
		boolean larun = true;//show ADD or EDIT BOOK loop
		
		

		//need these to eval the user's input
		String l = new String("L"); //<--/ Login
		String c = new String("C"); //<--/ Create user
		String admin = new String("A"); //<--/ Librarian login function (ADMINS)
		String add = new String("AddBooks"); //<--/ Librarian login function (ADMINS)
		String edit = new String("EditBooks"); //<--/ Librarian login function (ADMINS)
		String q = new String("Q"); //<--/ QUIT program
		String listbooks = new String("B"); //<--/ List library of books
		String s = new String("S"); //<--/ Search for specific book
		String u = new String("U"); //<--/ View User Account's info
		String wait = new String("W"); //<--/ Join waitlist for book
		String r = new String("R"); //<--/ RETURN book
		String d = new String("D"); //<--/ DELETE user's name from waitlist

		int a = 1; //need to keep track of attempts to login
		int createattempts = 1; //need to keep track of attempts to create a profile
		int a2 = 1; //need to keep track of attempts from main menu.
		String uname = "";//keep track of username
		long wtime = 21;//waitime for book in days = wlist users * 21 days
		long wtime2 = 0;//waitime for book in days = wlist users * 21 days in SEARCH LOOP

		while (run) { //Start up loop
			//run welcome display
			System.out.println("________________________________________________________________________\n"+
						       "| |------------------------------------------------------------------| |\n"+
							   "| |                                                                  | |\n"+
						       "| |                      Welcome to eLibrarian.                      | |\n"+
						       "| |                   Please login (ENTER 'L' KEY),                  | |\n"+
						       "| |               OR create an account (ENTER 'C' KEY)               | |\n"+
							   "| |                  OR LIBRARIANS (ENTER 'A' KEY)                   | |\n"+
						       "| |                    (Input IS case sensitive).                    | |\n"+
						       "| |                                                     'Q' to quit. | |\n"+
						       "|_|__________________________________________________________________|_|\n");
			Welcome w = new Welcome(1);//run START welcome to get input L,C or A
			mmrun = true;//resets main menu loop in case you back out from admin
			librun = true;//resets admin page if you have visited it already and try go into it again.
			
			//if they enter L, then go to login
			if (w.getInput().equals(l)) { 
				//prompt for login info and keep track of which attempt it is
				Login log0 = new Login(a, uname);
				//if info correct, login! If not, tell user, and prompt again
				if(log0.HasRegistry()) {
					a = 1;//resets attempt number incase had to reenter password
					System.out.println("________________________________________________________________________\n"+
					                   "| |------------------------------------------------------------------| |\n"+
					                   "| |                           Login success.                         | |\n"+
					                   "| |                      Welcome to the Main Menu.                   | |\n"+
					                   "| |       ENTER 'B' to view the list of books from the database.     | |\n"+
					                   "| |         ENTER 'S' to search for a book from the database.        | |\n"+
					                   "| |                ENTER 'U' to view your account info.              | |\n"+
									   "| |                                                                  | |\n"+
					                   "| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
					                   "|_|__________________________________________________________________|_|\n");
					while (mmrun) { //MAIN MENU LOOP asks user for B, S or U
						LoggedIn li = new LoggedIn(a2);//get user's choice to look at books, search for specific book, or view account info
						
						if(li.getChoice().equals(listbooks)) {
							a2 = 1;//resets attempt number incase had to re-enter input
							String bookinfo ="";
							dbrun = true;
							brun = true;
							arun = true;
							while (dbrun) { //DATABASE LOOP gets books from database
								BookList b = new BookList();//run booklist to list database of books
								bookinfo = b.inventory();//get string form of list from booklist.java
								System.out.println("________________________________________________________________________\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| |                            Database:                             | |\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| |Book Name, Author, ID:                                            | |\n"+
										       "| |------------------------------------------------------------------| |\n"
								                +bookinfo+
											   "| |                                                                  | |\n"+
											   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       "|_|__________________________________________________________________|_|\n");
								while (brun) { //BOOK LOOP asks user for book id
									ViewBook vb = new ViewBook();//ask user to select a book by id
									if (vb.getInput().equals(q)) { //if they press Q to quit
										System.out.println("Quitting...Goodbye!");
										brun = false;//quit view book loop
										dbrun = false;//quit db loop
										mmrun = false;//quit mm loop
										run = false;//quit main loop
									} 
									else if (vb.HasID()) { //if the id matches a book in the database
										Book userBook = new Book();//start book display view
										userBook.binfo(vb.getInput());
										//send view input id to iterate database. Should fill values accordingly
										if (userBook.getWL() <= 0){
											System.out.println("________________________________________________________________________\n"+
									                   "| |                                                                  | |\n"+
									                   "| | "+userBook.getBookTitle()+"                     \n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | By: "+userBook.getBookAuthor()+"                             \n"+
													   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | "+userBook.getBookSum()+"\n"+
													   "| |                                                                  | |\n"+
													   "| | "+userBook.IsBookAvailable()+"   | |\n"+
													   "| | Current Waitlist: 0 user(s)                                      | |\n"+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
						                       	       "|_|__________________________________________________________________|_|\n");
										} else if (userBook.getWL() > 0){
											System.out.println("________________________________________________________________________\n"+
									                   "| |                                                                  | |\n"+
									                   "| | "+userBook.getBookTitle()+"                     \n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | By: "+userBook.getBookAuthor()+"                             \n"+
													   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | "+userBook.getBookSum()+"\n"+
													   "| |                                                                  | |\n"+
													   "| | "+userBook.IsBookAvailable()+"   | |\n"+
													   "| | Current Waitlist: "+userBook.getWL()+" user(s)                   \n"+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
						                       	       "|_|__________________________________________________________________|_|\n");
										}
										arun = true;//
										while (arun) {//ACTION LOOP asks user for W, B, R, or D
											Action action = new Action(userBook.getAvailability(), userBook.borrowedBook(log0.getEmail(),vb.getInput()), userBook.inWaitlist(log0.getEmail(),vb.getInput()));//start action prompt

											//IF book UNAVAILABLE AND they enter W and FIRST TRY (they aren't in the waitllist for this book or borrowed it)
											if (!userBook.getAvailability() && action.getInput().equals(wait) && !userBook.inWaitlist(log0.getEmail(),vb.getInput()) && !userBook.borrowedBook(log0.getEmail(),vb.getInput())) {
												Borrow borrowJ = new Borrow();//join waitlist and send info
												String topUser = borrowJ.wlTop(vb.getInput());//read waitlist and grab first username
												// wait time = time left of first person + 3 weeks * amount of people on list, and not including this user
												wtime = borrowJ.checkTime(topUser,vb.getInput()) + (21*(borrowJ.countwl(vb.getInput())-1));

												//add user to list (IN THE DB)
												borrowJ.jWl(log0.getEmail(), vb.getInput());
												//need to count users again now that the user has been added to display their number
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |       Thank you for joining the waitlist. You are number "+(userBook.getWL()+1)+".      | |\n"+
						                       	       "| |               The estimated wait time is "+wtime+" day(s).              | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database
												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//exit action loop
												//GO BACK TO DATABASE
											}
											//IF book UNAVAILABLE AND they are ALREADY ON waitlist NOT BORROWED
											else if (!userBook.getAvailability() && action.getInput().equals(wait) && userBook.inWaitlist(log0.getEmail(),vb.getInput()) && !userBook.borrowedBook(log0.getEmail(),vb.getInput())) {
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |       You are already on the waitlist. You are number "+userBook.getWL()+".      \n"+
						                       	       "| |              The estimated wait time is "+wtime+" day(s).              \n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database
												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//exit action loop
												//GO BACK TO DATABASE
											}//IF book UNAVAILABLE AND they ALREADY BORROWED BOOK
											else if (!userBook.getAvailability() && action.getInput().equals(wait) && userBook.borrowedBook(log0.getEmail(),vb.getInput())) {
												Borrow borrow = new Borrow();//get waitlist
												int remainder = borrow.checkTime(log0.getEmail(), String.valueOf(userBook.getID()));//check when they rented the book 
												if (remainder <= 21) {//if its not overdue, display this
													System.out.println("________________________________________________________________________\n"+
						                       	   	   				"| |------------------------------------------------------------------| |\n"+
						                       	       				"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
						                       	       				"| |                    It is due back in "+remainder+" day(s).                  | |\n"+
													   				"|_|__________________________________________________________________|_|\n");
													
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+bookinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
												//GO BACK TO SEARCH RESULTS
												}
												else if (remainder > 21) {//if it IS overdue, display this
													System.out.println("________________________________________________________________________\n"+
						                       	   	   				"| |------------------------------------------------------------------| |\n"+
						                       	       				"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
						                       	       				"| |   The book is OVERDUE!! Please return it as soon as possible.    | |\n"+
													   				"|_|__________________________________________________________________|_|\n");
													
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+bookinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
												//GO BACK TO SEARCH RESULTS
												}
											}
											//IF book IS AVAILABLE AND they enter B
											else if (userBook.getAvailability() && action.getInput().equals(listbooks)) {
												Borrow borrowB = new Borrow();//get waitlist
												borrowB.rbook(log0.getEmail(), vb.getInput());
												//create waitlist by renting this book
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |                         Enjoy the book!                          | |\n"+
						                       	       "| |                  It is due back in: 21 day(s).                   | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//quit action
												//GO BACK TO DATABASE

											}
											//IF book IS UNAVAILABLE AND they BORROWED IT, AND they enter R
											else if (!userBook.getAvailability() && action.getInput().equals(r) && userBook.borrowedBook(log0.getEmail(),vb.getInput())) {
												Borrow borrowR = new Borrow();//get waitlist
												borrowR.editwl(log0.getEmail(), vb.getInput()); //delete entry from waitlist table
												//take user's name off the waitlist database
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |                 Thank you for returning the book!                | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//quit action
												//GO BACK TO DATABASE

											}
											//IF book IS UNAVAILABLE AND they are ON WAITLIST, AND they enter D
											else if (!userBook.getAvailability() && action.getInput().equals(d) && !userBook.borrowedBook(log0.getEmail(),vb.getInput()) && userBook.inWaitlist(log0.getEmail(),vb.getInput())) {
												Borrow borrowD = new Borrow();//get waitlist
												borrowD.editwl(log0.getEmail(), vb.getInput()); //delete entry from waitlist table
												//take user's name off the waitlist database
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |          Your name has been removed from the waitlist!           | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//quit action
												//GO BACK TO DATABASE

											}
											//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to database
											else if ((!userBook.getAvailability() || userBook.getAvailability()) && action.getInput().equals(c)) {
												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+bookinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun = false;//quit action
												//GO BACK TO DATABASE

											}
											else if (action.getInput().equals(q)) {
												//if they press Q to quit
												System.out.println("Quitting...Goodbye!");
												arun = false;//quit action loop
												brun = false;//quit view book loop
												dbrun = false;//quit db loop
												mmrun=false;//quit main loop
												run = false;//quit main loop
											}
										}
									}
									//IF viewing DB (entering id) and press C, then go back to MM
									else if (vb.getInput().equals(c)) {
										//run welcome display
										System.out.println("________________________________________________________________________\n"+
														"| |------------------------------------------------------------------| |\n"+
														"| |                                                                  | |\n"+
														"| |                      Welcome to the Main Menu.                   | |\n"+
					                   					"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
					                   					"| |         ENTER 'S' to search for a book from the database.        | |\n"+
					                   					"| |                ENTER 'U' to view your account info.              | |\n"+
														"| |                                                                  | |\n"+
														"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
														"|_|__________________________________________________________________|_|\n");
										arun = false;
										brun = false;//quit book veiw loop
										dbrun = false;//go back
										//GO BACK TO MAIN MENU
			
									}
									else {
										System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |     Invalid input. Please re-enter a book's id from the list.    | |\n"+
						                       	       "|_|__________________________________________________________________|_|\n");
										wait(5000);//wait 5 seconds to prompt
							    	}
								}
							}
						//if user selects Search from Main Menu
						} else if(li.getChoice().equals(s)) { 
							srun = true;
							System.out.println("________________________________________________________________________\n"+
							                   "| |                           Book Search                            | |\n"+
						                       "| |------------------------------------------------------------------| |\n"+
						                       "| |  Please enter the book's title OR author you would like to find. | |\n"+
											   "| |                    ONLY enter Title OR Author!                   | |\n"+
											   "| |                  Note that it IS case sensitive.                 | |\n"+
											   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
						                       "|_|__________________________________________________________________|_|\n");
							while (srun) {
								Search bs = new Search(); //new book search input needed
								
								if (bs.getSInput().equals(q)) { //if they press Q to quit
									System.out.println("Quitting...Goodbye!");
									srun = false;//quit db loop
									mmrun = false;//quit mm loop
									run = false;//quit main loop
								}
								//If inputted C to go BACK TO MM
								else if (bs.getSInput().equals(c)) { //
									System.out.println("________________________________________________________________________\n"+
														"| |------------------------------------------------------------------| |\n"+
														"| |                                                                  | |\n"+
														"| |                      Welcome to the Main Menu.                   | |\n"+
					                   					"| |       ENTER 'B' to view the list of books from the database.     | |\n"+
					                   					"| |         ENTER 'S' to search for a book from the database.        | |\n"+
					                   					"| |                ENTER 'U' to view your account info.              | |\n"+
														"| |                                                                  | |\n"+
														"| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
														"|_|__________________________________________________________________|_|\n");
									srun = false;//quit search input loop
								}
								//If info matches book title OR author in system
								else if (bs.IsValid()) {
									//display book info and what to do
									String searchinfo = "";
									BookList searchlist = new BookList();//run booklist to list books MATCHING INPUT
									searchinfo = searchlist.searchInventory(bs.getSInput());//get string form of list from booklist.java
									System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| | Book Name, Author, ID:                                           | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
									sbrun = true;
									while (sbrun) { //Search BOOK LOOP asks user for book id
										ViewBook vb2 = new ViewBook();//ask user to select a book by id FROM SEARCH RESULTS
										if (vb2.getInput().equals(q)) { //if they press Q to quit
											System.out.println("Quitting...Goodbye!");
											sbrun = false;//quit view book loop
											srun = false;//quit db loop
											mmrun = false;//quit mm loop
											run = false;//quit main loop
										} 
										else if (vb2.getInput().equals(c)) { //if they press C to go back to SEARCH
											System.out.println("________________________________________________________________________\n"+
							                   					"| |                           Book Search                            | |\n"+
						                       					"| |------------------------------------------------------------------| |\n"+
						                       					"| |  Please enter the book's title OR author you would like to find. | |\n"+
											   					"| |                    ONLY enter Title OR Author!                   | |\n"+
											   					"| |                  Note that it IS case sensitive.                 | |\n"+
											   					"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
						                       					"|_|__________________________________________________________________|_|\n");
											sbrun = false;//quit view book loop
										} 
										else if (vb2.HasID()) { //if the id matches a book in the results
											Book userBook2 = new Book();//start book display view
											userBook2.binfo(vb2.getInput());//get info for book matching the entered ID
											//send view input id to iterate database. Should fill values accordingly
											if (userBook2.getWL() <= 0){
												System.out.println("________________________________________________________________________\n"+
														   "| |                                                                  | |\n"+
														   "| | "+userBook2.getBookTitle()+"                     \n"+
																 "| |------------------------------------------------------------------| |\n"+
															  "| | By: "+userBook2.getBookAuthor()+"                             \n"+
														   "| |------------------------------------------------------------------| |\n"+
															  "| | "+userBook2.getBookSum()+"\n"+
														   "| |                                                                  | |\n"+
														   "| | "+userBook2.IsBookAvailable()+"   | |\n"+
														   "| | Current Waitlist: 0 user(s)                                      | |\n"+
														   "| |                                                                  | |\n"+
														   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
															  "|_|__________________________________________________________________|_|\n");
											} else if (userBook2.getWL() > 0){
												System.out.println("________________________________________________________________________\n"+
														   "| |                                                                  | |\n"+
														   "| | "+userBook2.getBookTitle()+"                     \n"+
																 "| |------------------------------------------------------------------| |\n"+
															  "| | By: "+userBook2.getBookAuthor()+"                             \n"+
														   "| |------------------------------------------------------------------| |\n"+
															  "| | "+userBook2.getBookSum()+"\n"+
														   "| |                                                                  | |\n"+
														   "| | "+userBook2.IsBookAvailable()+"   | |\n"+
														   "| | Current Waitlist: "+userBook2.getWL()+" user(s)                   \n"+
														   "| |                                                                  | |\n"+
														   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
															  "|_|__________________________________________________________________|_|\n");
											}
											arun2 = true;
											while (arun2) {//ACTION LOOP asks user for W,B,R or D
												Action action2 = new Action(userBook2.getAvailability(), userBook2.borrowedBook(log0.getEmail(),vb2.getInput()), userBook2.inWaitlist(log0.getEmail(),vb2.getInput()));//start action prompt
						
												//IF book UNAVAILABLE AND they HAVENT borrowed it ANYWHERE, and they enter W
												if (!userBook2.getAvailability() && action2.getInput().equals(wait) && !userBook2.borrowedBook(log0.getEmail(),vb2.getInput()) && !userBook2.inWaitlist(log0.getEmail(),vb2.getInput())) {
													Borrow borrowS = new Borrow();//get waitlist
													String topUser = borrowS.wlTop(vb2.getInput());//read waitlist and grab first username
													// wait time = time left of first person + 3 weeks * amount of people on list, and not including this user
													wtime2 = borrowS.checkTime(topUser,vb2.getInput()) + (21*(borrowS.countwl(vb2.getInput())-1));

													//add user to list
													borrowS.jWl(log0.getEmail(), vb2.getInput());
													//need to count users again now that the user has been added to display their number
													System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |       Thank you for joining the waitlist. You are number "+(userBook2.getWL()+1)+".      | |\n"+
						                       	       "| |               The estimated wait time is "+wtime2+" day(s).              | |\n"+
													   "|_|__________________________________________________________________|_|\n");
						
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
													//GO BACK TO SEARCH RESULTS
												}
												//IF book UNAVAILABLE AND they are ALREADY ON waitlist from joining in search or database
												else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && userBook2.inWaitlist(log0.getEmail(),vb2.getInput()) && !userBook2.borrowedBook(log0.getEmail(),vb2.getInput())) {
													System.out.println("________________________________________________________________________\n"+
						                       	   	   				"| |------------------------------------------------------------------| |\n"+
						                       	       				"| |       You are already on the waitlist. You are number "+userBook2.getWL()+".      \n"+
						                       	       				"| |              The estimated wait time is "+wtime2+" day(s).              \n"+
													   				"|_|__________________________________________________________________|_|\n");
													
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
													//sbrun = false;//exit book view loop
													//GO BACK TO SEARCH RESULTS
												}//IF book UNAVAILABLE AND they are ALREADY BORROWED BOOK in search OR database
												else if (!userBook2.getAvailability() && action2.getInput().equals(wait) && userBook2.borrowedBook(log0.getEmail(),vb2.getInput())) {
													Borrow borrow2 = new Borrow();//get waitlist
													long remainder2 = borrow2.checkTime(log0.getEmail(), String.valueOf(userBook2.getID()));//check when they rented the book waitlist 
													if (remainder2 <= 21) {
														System.out.println("________________________________________________________________________\n"+
						                       	   	   				"| |------------------------------------------------------------------| |\n"+
						                       	       				"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
						                       	       				"| |                    It is due back in "+remainder2+" day(s).                  | |\n"+
													   				"|_|__________________________________________________________________|_|\n");
													
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
													//GO BACK TO SEARCH RESULTS
													}
													else if (remainder2 > 21) {
														System.out.println("________________________________________________________________________\n"+
						                       	   	   				"| |------------------------------------------------------------------| |\n"+
						                       	       				"| |     You have Rented this book! You cannot join its waitlist.     | |\n"+
						                       	       				"| |   The book is OVERDUE!! Please return it as soon as possible.    | |\n"+
													   				"|_|__________________________________________________________________|_|\n");
													
													wait(2000);//wait 2 seconds to print database
													//reprint results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//exit action loop
													//sbrun = false;//exit book view loop
													//GO BACK TO SEARCH RESULTS
													}
													
												}//IF book IS AVAILABLE AND they enter B for BORROW
												else if (userBook2.getAvailability() && action2.getInput().equals(listbooks)) {
													System.out.println("________________________________________________________________________\n"+
																	   "| |------------------------------------------------------------------| |\n"+
																	   "| |                         Enjoy the book!                          | |\n"+
																	   "| |                  It is due back in: 21 day(s).                   | |\n"+
																	   "|_|__________________________________________________________________|_|\n");
													Borrow borrowB2 = new Borrow();//get waitlist
													borrowB2.rbook(log0.getEmail(), String.valueOf(userBook2.getID()));//add user to waitlist so people can no longer rent the book
						
													wait(2000);//wait 2 seconds to print database
						
													//reprint search results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//quit action
													//GO BACK TO SEARCH RESULTS
						
												}
												//IF book IS UNAVAILABLE AND they BORROWED IT, AND they enter R
											else if (!userBook2.getAvailability() && action2.getInput().equals(r) && userBook2.borrowedBook(log0.getEmail(),vb2.getInput())) {
												Borrow borrowR2 = new Borrow();//get waitlist
												borrowR2.editwl(log0.getEmail(), vb2.getInput()); //delete entry from waitlist table
												//take user's name off the waitlist database
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |                 Thank you for returning the book!                | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+searchinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun2 = false;//quit action
												//GO BACK TO DATABASE

											}
											//IF book IS UNAVAILABLE AND they are ON WAITLIST, AND they enter D
											else if (!userBook2.getAvailability() && action2.getInput().equals(d) && !userBook2.borrowedBook(log0.getEmail(),vb2.getInput()) && userBook2.inWaitlist(log0.getEmail(),vb2.getInput())) {
												Borrow borrowD2 = new Borrow();//get waitlist
												borrowD2.editwl(log0.getEmail(), vb2.getInput()); //delete entry from waitlist table
												//take user's name off the waitlist database
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |          Your name has been removed from the waitlist!           | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(2000);//wait 2 seconds to print database

												//reprint db and prompt book id again
												System.out.println("________________________________________________________________________\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |                            Database:                             | |\n"+
													   "| |------------------------------------------------------------------| |\n"+
													   "| |Book Name, Author, ID:                                            | |\n"+
													   "| |------------------------------------------------------------------| |\n"
														+searchinfo+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												arun2 = false;//quit action
												//GO BACK TO DATABASE

											}
												//If book UNAVAILABLE OR AVAILABLE and they enter C, then cancel or go back to search results
												else if ((!userBook2.getAvailability() || userBook2.getAvailability()) && action2.getInput().equals(c)) {
													wait(2000);//wait 2 seconds to print database
						
													//reprint search results and prompt book id again
													System.out.println("________________________________________________________________________\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |                          Search Results:                         | |\n"+
										       			"| |------------------------------------------------------------------| |\n"+
										       			"| |Book Name, Author, ID:                                            | |\n"+
										       			"| |------------------------------------------------------------------| |\n"
								                			+searchinfo+
											   			"| |                                                                  | |\n"+
											   			"| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       			"|_|__________________________________________________________________|_|\n");
													arun2 = false;//quit action
													//GO BACK TO SEARCH RESULTS
						
												}
												else if (action2.getInput().equals(q)) {
													//if they press Q to quit
													System.out.println("Quitting...Goodbye!");
													arun2 = false;//quit action loop
													sbrun = false;//quit search view book loop
													srun = false;//quit search results loop
													mmrun = false;//quit main menu loop
													run = false;//quit who;e program
												}
											
											}//closes arun2 loop
										//IF viewing Search results (entering id) and press C, then go back to SEARCH
										}else if (vb2.getInput().equals(c)) {
											//run search
											System.out.println("________________________________________________________________________\n"+
							                   					"| |                           Book Search                            | |\n"+
						                       					"| |------------------------------------------------------------------| |\n"+
						                       					"| |  Please enter the book's title OR author you would like to find. | |\n"+
											   					"| |                    ONLY enter Title OR Author!                   | |\n"+
											   					"| |                  Note that it IS case sensitive.                 | |\n"+
						                       					"|_|__________________________________________________________________|_|\n");
											sbrun = false;//quit search results book veiw loop
											//GO BACK TO MAIN MENU SEARCH
										}
										else {
											System.out.println("________________________________________________________________________\n"+
															"| |------------------------------------------------------------------| |\n"+
															"| |   Invalid input. Please re-enter a book's id from the results.   | |\n"+
															"|_|__________________________________________________________________|_|\n");
											wait(500);//wait 5 seconds to prompt
										}
									}//close sbrun 
								}
								//If info DOESNT MATCH book titles OR authors in system
								else if (!bs.IsValid()) {
									System.out.println("\n________________________________________________________________________\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| |        We do not have any books matching "+bs.getSInput()+" \n"+
													"| |                    Please retry in a moment.                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
									wait(5000);//wait 5 seconds to prompt search again
								}//close ifs to check search input
							}//close srun loop
						//if user selects User from Main Menu
						} else if(li.getChoice().equals(u)) { //if they entered the wrong password but right email, prompt them for password again.
							urun = true;
							uirun = true;
							while (urun) {//USER INFO loop
								String userinfo = "";
								User user = new User();//run user to list database of users
								userinfo = user.info(log0.getEmail());//get string form of user's info from the user table
								System.out.println("________________________________________________________________________\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| |                           Your Account:                          | |\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| | Email, Password:                                                 | |\n"+
										       "| |------------------------------------------------------------------| |\n"
								                +userinfo+
											   "| |                                                                  | |\n"+
											   "| | 'C' to go back.                                     'Q' to quit. | |\n"+
										       "|_|__________________________________________________________________|_|\n");
								while(uirun) {
									Welcome w1 = new Welcome(2);//run START welcome to get input again C OR Q
									if (w1.getInput().equals(c)) {
										//go back to MM
										System.out.println("________________________________________________________________________\n"+
														   "| |------------------------------------------------------------------| |\n"+
														   "| |                                                                  | |\n"+
														   "| |                      Welcome to the Main Menu.                   | |\n"+
					                   					   "| |       ENTER 'B' to view the list of books from the database.     | |\n"+
					                   					   "| |         ENTER 'S' to search for a book from the database.        | |\n"+
					                   					   "| |                ENTER 'U' to view your account info.              | |\n"+
														   "| |                                                                  | |\n"+
														   "| | 'C' to log out and go back.                         'Q' to quit. | |\n"+
														   "|_|__________________________________________________________________|_|\n");
										uirun = false;//quit user input loop
										urun = false;//quit account info display
									}
									else if (w1.getInput().equals(q)) {
										//Quit program from user page
										System.out.println("Quitting...Goodbye!");
										uirun = false;//quit user input loop
										urun = false;//quit account info display
										mmrun = false;//exit main menu loop
										run = false;//exit everything
									}
								}
							}
						} else if (li.getChoice().equals(q)){ 
							//quit from main menu
							System.out.println("Quitting...Goodbye!");
							mmrun = false;//exit main menu loop
							run = false;//exit everything

						} else if (li.getChoice().equals(c)){ //if entering c at main menu GO TO START UP
							//Back from main menu
							mmrun = false;//exit main menu loop
						}
						else {
							System.out.println("________________________________________________________________________\n"+
										   "| |------------------------------------------------------------------| |\n"+
										   "| |                          Invalid input.                          | |\n"+
										   "|_|__________________________________________________________________|_|\n");
							a2=2;
						}
					}//CLOSE MAIN MENU
			} else if(log0.HasEmail()) { //if they entered the wrong password but right email, prompt them for password again.
				a = 2; uname = log0.getEmail(); //send correct email to next login
			} else if(!log0.HasEmail()) { //if they entered an invalid email, prompt them for input again
				a = 3;
				System.out.println("\nThat account does not exist. Please Retry.");
			} else {
				System.out.println("________________________________________________________________________\n"+
				                   	"| |------------------------------------------------------------------| |\n"+
								    "| |                    No account matched...Quiting                  | |\n"+
								    "|_|__________________________________________________________________|_|\n");
				run = false;//exit main run loop
			}
		}//if they press C from START WELCOME, then go to create account
		else if (w.getInput().equals(c)){ 
			//continue to create account
			while (cwrun) {
				System.out.println("________________________________________________________________________\n"+
								   	"| |------------------------------------------------------------------| |\n"+
			                       	"| |                     Welcome to Create Account.                   | |\n"+
								  	"| |          Follow the instructions below to make accounts.         | |\n"+
								  	"| |                ENTER 'L' key to go back and login.               | |\n"+
								   	"| |                    ENTER 'C' key to continue.                    | |\n"+
								   	"| |                                                     'Q' to quit. | |\n"+
			                       	"|_|__________________________________________________________________|_|\n");
				Welcome createwelcome = new Welcome(3);//run CREATE WELCOME
				
				//BACK to login
				if (createwelcome.getInput().equals(l)) { 
					//exit createwelcome and go to main loop.
					cwrun = false;
					
				}//CONTINUE
				else if (createwelcome.getInput().equals(c)){ 
					//run create
					while (crun) {
						Create ca = new Create(createattempts);
						if(ca.getAttempt() == 1) { //if everything is okay, make account
							System.out.println("________________________________________________________________________\n"+
											   "| |------------------------------------------------------------------| |\n"+
											   "| |                         New Account made!                        | |\n"+
											   "| | User Email: "+ca.getEmail()+"                                    \n"+
											   "| | Password: "+ca.getPassword()+"                                   \n"+
											   "|_|__________________________________________________________________| |\n");
							crun = false;//take user back to create welcome screen to login		   	
						} else { //if email is already in use, prompt for new input
							createattempts = 3; //prompt to enter different email.
						}	
						
					}
	
				}//QUIT	
				else if (createwelcome.getInput().equals(q)){ 
					//quit from welcome to CREAT ACCOUNT screen
					System.out.println("Quitting...Goodbye!");
					cwrun = false;//exit create loop
					run = false;//exit program loop
				}
				else { //catches bad input
					System.out.println("________________________________________________________________________\n"+
									   	   "| |------------------------------------------------------------------| |\n"+
									       "| |             Invalid input. Please enter 'L' or 'C'.              | |\n"+
									       "| |                                                     'Q' to quit. | |\n"+
									       "|_|__________________________________________________________________|_|\n");
				}
			}//closes crun	

		}//closes createaccount if
		else if (w.getInput().equals(admin)){  //A from start up welcome
			//continue to admin page
			while (librun) {//librarian admin screen loop
				larun = true;
				System.out.println("________________________________________________________________________\n"+
								   	"| |------------------------------------------------------------------| |\n"+
			                       	"| |                   Welcome to the Admin Screen.                   | |\n"+
								  	"| |      Only registered Librarians may access these functions.      | |\n"+
								  	"| |                     ENTER 'L' key to go back.                    | |\n"+
								   	"| |            ENTER 'C' key to continue as a librarian.             | |\n"+
								   	"| |                                                     'Q' to quit. | |\n"+
			                       	"|_|__________________________________________________________________|_|\n");
				Welcome libwelcome = new Welcome(3);//run Admin login WELCOME
				
				//BACK to login
				if (libwelcome.getInput().equals(l)) { 
					//exit libwelcome and go to main loop.
					librun = false;
					
					
				}//CONTINUE
				else if (libwelcome.getInput().equals(c)){ 
					//run add book
					while (larun) {//librarian action loop
						LibrarianAction la = new LibrarianAction(a, uname); //logins AND creates book in DB
						if(la.HasRegistry() && la.in.equals(add)) { //if admin exists, login as librarian AND ADD then add book
							Book adminBook = new Book();//start book display view of CREATED book
							adminBook.binfo(la.getId());//get info for book matching the entered ID
							//send newest id to iterate database. Should fill values accordingly with NEW BOOK
							System.out.println("________________________________________________________________________\n"+
													"| |                 You Book was Successfully Added!                 | |\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| |                                                                  | |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							//System.out.println("________________________________________________________________________\n"+
								// 					"| |                 You Book was Successfully Added!                 | |\n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | "+adminBook.getBookTitle()+"                     \n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | By: "+adminBook.getBookAuthor()+"                             \n"+
								// 					"| |------------------------------------------------------------------| |\n"+
								// 					"| | "+adminBook.getBookSum()+"\n"+
								// 					"| |                                                                  | |\n"+
								// 					"| | It is available now!                                             | |\n"+
								// 					"| | Current Waitlist: "+adminBook.getWL()+" user(s)                   \n"+
								// 					"| |                                                                  | |\n"+
								// 					"| | Returning to Admin screen...                                     | |\n"+
								// 					"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
											   
						} else if (la.HasRegistry() && la.in.equals(edit) && la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE then add book
							Book adminBook = new Book();//start book display view of DELETED book
							adminBook.binfo(la.getId());//get info for book matching the entered ID
							//send newest id to iterate database. Should fill values accordingly with BOOK to delete
							System.out.println("________________________________________________________________________\n"+
													"| |                       You Book was Deleted!                      | |\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
											   
						} else if (la.HasRegistry() && la.in.equals(edit) && !la.in2.equals("Delete")) { //if admin exists, login as librarian AND DELETE then add book
							//need to enter Delete properly
							System.out.println("________________________________________________________________________\n"+
													"| | Command "+la.in2+" not recognized, please retry!\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| | Returning to Admin screen...                                     | |\n"+
													"|_|__________________________________________________________________|_|\n");
							wait(2000);//wait 2 before returning 
							larun = false;//take user back to admin edit or add screen
											   
						}else if(la.HasRegistry()&&la.in.equals("DeleteUsers")){
							System.out.println("Send you to the Main Menu....");
							librun=false;
						}else if(la.HasRegistry()&&la.in.equals("UpdateUsers")) {
							larun=false;
						}else if(la.HasEmail()) { //if they entered the wrong password but right email, prompt them for password again.
							a = 2; uname = la.getEmail(); //send correct email to next login
						} else if(!la.HasEmail()) { //if they entered an invalid email, prompt them for input again
							a = 3;
							System.out.println("\nThat account does not exist. Please Retry.");
						} else {
							System.out.println("________________________________________________________________________\n"+
													"| |------------------------------------------------------------------| |\n"+
													"| |                    No account matched...Quiting                  | |\n"+
													"|_|__________________________________________________________________|_|\n");
							larun = false;//exit lib action run loop
							librun = false;//exit librarian run loop
							run = false;//exit main run loop
						}	
						
					}
	
				}//QUIT	from librarian loop
				else if (libwelcome.getInput().equals(q)){ 
					//quit from librarian welcome screen
					System.out.println("Quitting...Goodbye!");
					librun = false;//close lib loop
					run = false;//exit create welcome loop
				}
				else { //catches bad input
					System.out.println("________________________________________________________________________\n"+
									   	"| |------------------------------------------------------------------| |\n"+
									    "| |            Invalid input. Please enter 'L','C', or 'A'.          | |\n"+
									    "| |                                                     'Q' to quit. | |\n"+
									    "|_|__________________________________________________________________|_|\n");
				}
			}
		}	
		else if (w.getInput().equals(q)){ 
			//quit from welcome screen
			System.out.println("Quitting...Goodbye!");
			run = false;//exit main loop
		}
		else { //catches bad input
			System.out.println("________________________________________________________________________\n"+
				                "| |------------------------------------------------------------------| |\n"+
							    "| |            Invalid input. Please enter 'L','C', or 'A'.          | |\n"+
								"| |                                                     'Q' to quit. | |\n"+
							    "|_|__________________________________________________________________|_|\n");
		}
	}	
}
	
	public Connection dbc() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/ndbt11";
		String username = "root";
		String password ="kkato41496746";
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	public static void wait(int ms) {
    	try
    	{
        	Thread.sleep(ms);
    	}
    	catch(InterruptedException ex)
    	{
        	Thread.currentThread().interrupt();
    	}
	}
}