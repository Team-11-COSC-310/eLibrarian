# eLibrarian
This is team 11's software development project. Its a Librarian Assisstant program that will allow users to browse or take out the books of a library with their phones (or anything with access to a web browser). 

Users will need to login in order to have access to the database of the library's books. If they don't have an account, they can create one. Once logged in, they can search through said database to find specific titles or authors, and they can either take out a book, or join the book's waitlist if it's borrowed already. Taking out a book will tell the user they have borrowed it, and how long they have to return the book. Joining the waitlist will tell the user how many people are in front of them on the list, as well as a rough estimate of when the book should be available to rent. Librarians will have an upgraded user account that will allow them to edit the library's stock, edit other user's passwords, and delete users all together, in addition to the regular user functions. User's should be able to see their info, which waitlists they are on, and also which books they have borrowed or are due back on their account page.

Run the 'mainapp.java' file to run the program, and use the 'db.sql' file as the database.

The 'connecttodb' Class just sets up the connection to the database.

The 'Welcome' Class prompts the user for input (L, C or sometimes A and Q), and it is used to get the user's choice to login, create an account, login in as an admin, go back or continue on the create account and admin menus, and to go back after looking at thier account's info menu.

The 'Login' Class prompts the user to login with an email and password, and checks the validity of what they have entered.

The 'Create' Class prompts the user to create an account with an email and password, and checks to make sure the account doesn't already exist.

The 'LibrarianAction' Class extends the Login class to check if the user is an admin, and then prompts the user for a choice to Add or Delete a book or Edit or Delete user's account to/in the database (ADMIN functions).

The 'LoggedIn' Class prompts the user for a choice from the main menu once they are logged in (B,S, or U).

The 'Booklist' Class is used to display (or list) all the books inside the database, or the books with a specific title or author that the user searched for.

The 'Book' Class is used to display all the information on a book that is in the database, and also to update its information like availability or its waitlist.

The 'Viewbook' class is used to get the user's input after searching for a book or viewing the entire database (the input will be the id of the book the user wants to look at more closely).

The 'User' Class is used to get and display the currently logged in user's information.

The 'Action' Class is used to get the user's choice of borrowing a book OR joining its waitlist. (B if available, W if there is a wait).

The 'Search' Class is used to get the Title or Author of the book the user is searching for, and it checks if the book exists within the database.

We have added several features: Keizo added 2 open-source libraries to the Login.java class, which allow it to encrypt user’s passwords in the database (making it more secure), and also checks to see if the email the user inputted is a valid entry (has a "@something.com" at the end of it). He also added a feature to give users an option for forgetting their password, which prompts the user to enter a new password. This is better than before, as users had no way of getting into their account if they forgot their information. These libraries are import java.util.regex.Matcher, java.util.regex.Pattern, and java.security.MessageDigest; (5)

Brenner updated the functionality of borrowing a book, or joining its waitlist. Now when users do either of these options, a table in the database is updated to actually track when they happen (Before there was no way of knowing an account had borrowed a book after they logged out). This helps calculate when a book is due back, and the Book.java class now checks this table to track the book’s availability and how many people are on its waitlist. The User.java class now displays which books a user is renting or on the waitlist for (instead of just the user's email and password). Additionally, he added a function to return a book, which deletes all of that user’s information from this new table in the database (this feature was needed to test the waitlist functions and simulates the actual thing people will have to do when using this system). (3)

Adrian flushed out the Admin/Librarian page which means updating the menus to display all of the regular options for users at the same time as the admin functions. Before the admin screen had to be separately logged in to which was a pain. Admins can now change user’s passwords, and delete users all together in addition to adding books and deleting books. (1)

Bolu built the Notify user feature. This uses an open-source library to send an unreplyable email to the user’s email that states when a book is due back, or when the book they are waiting for is available to borrow. This is great for making sure users return books on time, and to keep the wait time for the books short. (2)

Keizo and Adrian started writing the GUI that allows the program to run in a window and take alot nicer input then the console did previously.

