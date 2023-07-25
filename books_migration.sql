CREATE DATABASE IF NOT EXISTS books_example;

USE books_example;

DROP TABLE IF EXISTS books;

CREATE TABLE books (
                       id int UNSIGNED AUTO_INCREMENT,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);

INSERT INTO books(title, author) VALUES ('The Hunchback of Notre Dame', 'Victor Hugo'), ('Green Eggs and Ham', 'Dr. Seuss');