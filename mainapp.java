import java.sql.*;

public class mainapp {
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		boolean run = true;//main loop
		boolean cwrun = true;//create welcome loop;
		boolean crun = true;//create loop
		boolean mmrun = true;//show main menu loop
		boolean dbrun = true;//show database of books loop
		boolean urun = true;//show user info loop
		boolean uirun = true;//user INPUT info loop
		boolean brun = true;//book view loop
		boolean arun = true;//action INPUT loop
		
		

		//need these to eval the user's input
		String l = new String("L"); //<--/ Login
		String c = new String("C"); //<--/ Create user
		String q = new String("Q"); //<--/ QUIT program
		String listbooks = new String("B"); //<--/ List library of books
		String s = new String("S"); //<--/ Search for specific book
		String u = new String("U"); //<--/ View User Account's info
		String wait = new String("W"); //<--/ Join waitlist for book

		int a = 1; //need to keep track of attempts to login
		int createattempts = 1; //need to keep track of attempts to create a profile
		int a2 = 1; //need to keep track of attempts from main menu.
		String uname = "";//keep track of username

		while (run) { //Start up loop
			//run welcome display
			System.out.println("________________________________________________________________________\n"+
						       "| |------------------------------------------------------------------| |\n"+
							   "| |                                                                  | |\n"+
						       "| |                      Welcome to eLibrarian.                      | |\n"+
						       "| |                   Please login (ENTER 'L' KEY),                  | |\n"+
						       "| |               OR create an account (ENTER 'C' KEY)               | |\n"+
						       "| |                    (Input IS case sensitive).                    | |\n"+
						       "| |                                                     'Q' to quit. | |\n"+
						       "|_|__________________________________________________________________|_|\n");
			Welcome w = new Welcome(1);//run START welcome to get input
			
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
					                   "| |                                                     'Q' to quit. | |\n"+
					                   "|_|__________________________________________________________________|_|\n");
					while (mmrun) { //MAIN MENU LOOP asks user for B, S or U
						LoggedIn li = new LoggedIn(a2);//get user's choice to look at books, search for specific book, or view account info
						if(li.getChoice().equals(listbooks)) {
							a2 = 1;//resets attempt number incase had to re-enter input
							String bookinfo ="";
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
										run = false;//quit main loop
									} 
									else if (vb.HasID()) { //if the id matches a book in the database
										Book userBook = new Book();//start book display view
										userBook.binfo(vb.getInput());
										//send view input id to iterate database. Should fill values accordingly
										System.out.println("________________________________________________________________________\n"+
									                   "| |                                                                  | |\n"+
									                   "| | "+userBook.getBookTitle()+"                     \n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | By: "+userBook.getBookAuthor()+"                             \n"+
													   "| |------------------------------------------------------------------| |\n"+
						                       	       "| | "+userBook.getBookSum()+"\n"+
													   "| |                                                                  | |\n"+
													   "| | "+userBook.IsBookAvailable()+" | |\n"+
													   "| | Current Waitlist: "+userBook.getWL()+" user(s)                   | |\n"+
													   "| |                                                                  | |\n"+
													   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
						                       	       "|_|__________________________________________________________________|_|\n");
										while (arun) {//ACTION LOOP asks user for W or B
											Action action = new Action(userBook.getAvailability());//start action prompt

											//IF book UNAVAILABLE AND they enter W
											if (!userBook.getAvailability() && action.getInput().equals(wait)) {
												int wtime = userBook.getWL() *21;// wait time = 3 weeks times amount of people on list
												userBook.changeWL(userBook.getWL()+1, vb.getInput());//update waitlist to include user BEFORE finding wtime
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |       Thank you for joining the waitlist. You are number "+userBook.getWL()+".      | |\n"+
						                       	       "| |               The estimated wait time is "+wtime+" day(s).              | |\n"+
													   "|_|__________________________________________________________________|_|\n");

												wait(1000);//wait 10 seconds to print database
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
											//IF book IS AVAILABLE AND they enter B
											else if (userBook.getAvailability() && action.getInput().equals(listbooks)) {
												System.out.println("________________________________________________________________________\n"+
						                       	   	   "| |------------------------------------------------------------------| |\n"+
						                       	       "| |                         Enjoy the book!                          | |\n"+
						                       	       "| |                  It is due back in: 21 day(s).                   | |\n"+
													   "|_|__________________________________________________________________|_|\n");
												userBook.changeAvailability(false, vb.getInput());//close book's availablity
												userBook.setWL(userBook.getWL()+1, vb.getInput());//update waitlist

												wait(1000);//wait 10 seconds to print database

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
											else if ((!userBook.getAvailability() || !userBook.getAvailability()) && action.getInput().equals(c)) {
												wait(1000);//wait 10 seconds to print database

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
														"| |                                                     'Q' to quit. | |\n"+
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
										wait(500);//wait 5 seconds to prompt
							    	}
								}
							}
						//if user selects Search from Main Menu
						} else if(li.getChoice().equals(s)) { 
							a2 = 1;//resets attempt number incase had to reenter input
						//if user selects User from Main Menu
						} else if(li.getChoice().equals(u)) { //if they entered the wrong password but right email, prompt them for password again.
							while (urun) {//USER INFO loop
								String userinfo = "";
								User user = new User();//run booklist to list database of books
								userinfo = user.info(log0.getEmail());//get string form of user's info user
								System.out.println("________________________________________________________________________\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| |                           Your Account:                          | |\n"+
										       "| |------------------------------------------------------------------| |\n"+
										       "| |Book Name, Author, ID:                                            | |\n"+
										       "| |------------------------------------------------------------------| |\n"
								                +userinfo+
											   "| |                                                                  | |\n"+
											   "| | 'C' to cancel.                                      'Q' to quit. | |\n"+
										       "|_|__________________________________________________________________|_|\n");
								while(uirun) {
									Welcome w1 = new Welcome(2);//run START welcome to get input
								}
							}
						} else if (li.getChoice().equals(q)){ 
							//quit from main menu
							System.out.println("Quitting...Goodbye!");
							mmrun = false;//exit main menu loop
							run = false;//exit everything
						}
						else {
							System.out.println("________________________________________________________________________\n"+
										   "| |------------------------------------------------------------------| |\n"+
										   "| |                          Invalid input.                          | |\n"+
										   "|_|__________________________________________________________________|_|\n");
							a2=2;
						}
				//BookList b = new BookList();//run booklist to list database of books
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
					Welcome createwelcome = new Welcome(1);//run CREATE WELCOME
				
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
											   "| | User Email: "+ca.getEmail()+"                                    | |\n"+
											   "| | Password: "+ca.getPassword()+"                                   | |\n"+
											   "|_|__________________________________________________________________| |\n");
								crun = false;//take user back to create welcome screen to login		   	
							} else { //if email is already in use, prompt for new input
								createattempts = 3; //prompt to enter different email.
							}	
						
						}
	
					}//QUIT	
					else if (createwelcome.getInput().equals(q)){ 
						//quit from welcome screen
						System.out.println("Quitting...Goodbye!");
						run = false;//exit create welcome loop
					}
					else { //catches bad input
						System.out.println("________________________________________________________________________\n"+
									   	   "| |------------------------------------------------------------------| |\n"+
									       "| |             Invalid input. Please enter 'L' or 'C'.              | |\n"+
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
							       "| |             Invalid input. Please enter 'L' or 'C'.              | |\n"+
								   "| |                                                     'Q' to quit. | |\n"+
							       "|_|__________________________________________________________________|_|\n");
			}
		}	
	}
	
	public Connection dbc() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db";
		String username = "root";
		String password ="cosc310_T11";
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