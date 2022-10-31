/*We need a table for the Users. They login using an email (which will serve as a username) and a password, and need the reset tokens to help
them reset their password incase they forget*/
CREATE TABLE `users` (
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `session` VARCHAR(255),
    `reset_token` VARCHAR(6),
    `reset_token_timestamp` DATETIME,
    `enable` BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`email`)
); 

/*We need a table for the admin users --the librarians of the library. They inherit everything the users have*/
CREATE TABLE `librarians` (
    `email` varchar(50) Not null,
    FOREIGN KEY (`email`) REFERENCES `users`(`email`)
);

/*We need to a table to hold the book's info like name, author, and a brief despcription.*/
CREATE TABLE `books` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,    
    `author` VARCHAR(255) NOT NULL,
    `summary` VARCHAR(255) NOT NULL, 
    `availability` BOOLEAN DEFAULT TRUE,
    `wl` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
); 
/*We need to hardcode a few users for testing purposes--they could be admins later as well*/
INSERT INTO users (email, password, enable) VALUES ("johnbooks@book.com", "imthelibrarian", 1);
INSERT INTO users (email, password, enable) VALUES ("iheartbooks@book.com", "ilovebooks14", 1);
/*Add books*/
INSERT INTO books (title, author, summary, availability, wl) VALUES ("Harry Potter and the Philosopher's Stone","J.K. Rowling", "This is the first of 7 in J.K. Rowling's epic wizard saga!", FALSE, 3);
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Chamber of Secrets","J.K. Rowling", "This is the second of 7 in J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Prisoner of Azkaban","J.K. Rowling", "This is the third of 7 in J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Goblet of Fire","J.K. Rowling", "This is the fourth of 7 in J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Order of the Phoenix","J.K. Rowling", "This is the fifth of 7 in J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Half Blood Prince","J.K. Rowling", "This is the sixth of 7 in J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Deathly Hallows","J.K. Rowling", "This is the finale of J.K. Rowling's epic wizard saga!");
INSERT INTO books (title, author, summary) VALUES ("The Hobbit","J.R.R. Tolkien", "This is Tolkien's most popular work aside from LOTR");
INSERT INTO books (title, author, summary) VALUES ("The Lord of the Rings: The Fellowship of the Ring","J.R.R. Tolkien", "This is the first of 3 in Tolkien's epic fanatasy trilogy!");
INSERT INTO books (title, author, summary) VALUES ("The Lord of the Rings: The Tale of Two Towers","J.R.R. Tolkien", "This is the second of 3 in Tolkien's epic fanatasy trilogy!");
INSERT INTO books (title, author, summary) VALUES ("The Lord of the Rings: The Return of the King","J.R.R. Tolkien", "This is the finale of Tolkien's epic fanatasy trilogy!");

/*Librarians -- Admin*/
INSERT INTO librarians (email) VALUES ("johnbooks@book.com"); /*SHOULD make johnbooks into an admin
