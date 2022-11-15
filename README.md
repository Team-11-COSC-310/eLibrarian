# eLibrarian
This is team 11's software development project. Its a Librarian Assisstant program that will allow users to browse or take out the books of a library with their phones (or anything with access to a web browser). 

Users will need to login in order to have access to the database of the library's books. If they don't have an account, they can create one. Once logged in, they can search through said database to find specific titles or authors, and they can either take out a book, or join the book's waitlist if it's borrowed already. Taking out a book will tell the user they have borrowed it, and how long they have to return the book. Joining the waitlist will tell the user how many people are in front of them on the list, as well as a rough estimate of when the book should be available to rent. Librarian's will have an upgraded user account that will allow them to edit the library's stock in addition to the regular functions. Also, librarian's are the only account with the privilege to promote other accounts to a librarian account. User's should not only be able to see which waitlists they are on, but also which books they have borrowed or are due back on their account page. Here, they should be able to see their information, and edit their password as well.

Run the 'mainapp.java' file to run the program, and use the 'db.sql' file as the database.

The 'connecttodb' Class just sets up the connection to the database.

The 'Welcome' Class prompts the user for input (L, C or sometimes A and Q), and it is used to get the user's choice to login, create an account, login in as an admin, go back or continue on the create account and admin menus, and to go back after looking at thier account's info menu.

The 'Login' Class prompts the user to login with an email and password, and checks the validity of what they have entered.

The 'Create' Class prompts the user to create an account with an email and password, and checks to make sure the account doesn't already exist.

The 'LibrarianAction' Class extends the Login class to check if the user is an admin, and then prompts the user for a choice to Add or Edit a book or Edit or Delete user's account to/in the database (ADMIN functions).

The 'LoggedIn' Class prompts the user for a choice from the main menu once they are logged in (B,S, or U).

The 'Booklist' Class is used to display (or list) all the books inside the database, or the books with a specific title or author that the user searched for.

The 'Book' Class is used to display all the information on a book that is in the database, and also to update its information like availability or its waitlist.

The 'Viewbook' class is used to get the user's input after searching for a book or viewing the entire database (the input will be the id of the book the user wants to look at more closely).

The 'User' Class is used to get and display the currently logged in user's information.

The 'Action' Class is used to get the user's choice of borrowing a book OR joining its waitlist. (B if available, W if there is a wait).

The 'Search' Class is used to get the Title or Author of the book the user is searching for, and it checks if the book exists within the database.

