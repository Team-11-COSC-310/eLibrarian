CREATE TABLE `users` (
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `session` VARCHAR(255),
    `reset_token` VARCHAR(6),
    `reset_token_timestamp` DATETIME,
    `enable` BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`email`)
); 
CREATE TABLE `librarians` (
    `email` varchar(50) Not null,
    FOREIGN KEY (`email`) REFERENCES `users`(`email`) ON DELETE CASCADE
);

CREATE TABLE `books` (
   `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `availability` tinyint(1) DEFAULT '1',
  `wl` int NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
); 
CREATE TABLE `waitlists` (
  `email` varchar(50) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`,`id`),
  FOREIGN KEY (`email`) REFERENCES `users` (`email`) ON DELETE CASCADE,
  FOREIGN KEY (`id`) REFERENCES `books` (`id`) ON DELETE CASCADE
);


INSERT INTO users (email, password, enable) VALUES ("johnbooks@book.com", "imthelibrarian", 1);
INSERT INTO users (email, password, enable) VALUES ("iheartbooks@book.com", "ilovebooks14", 1);

INSERT INTO librarians (email) VALUES ("johnbooks@book.com");

INSERT INTO books (title, author, summary) VALUES ("Harry Potter and the Philosopher's Stone","J.K. Rowling", "This is the first of 7 in J.K. Rowling's epic wizard saga!");
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
