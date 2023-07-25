USE adlister_db;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL
);


CREATE TABLE ads (
                     id SERIAL PRIMARY KEY,
                     user_id INTEGER REFERENCES users(id),
                     title VARCHAR(100) NOT NULL,
                     description TEXT NOT NULL
);

INSERT into users (username, email, password) VALUES (
                    'user1', '12345@mail.com', 'password'
);

INSERT into ads (user_id, title, description) VALUES (
                    1, 'Apt for rent in Austin', '$1700 weekly'
);

INSERT into ads (user_id, title, description) VALUES (
                    1, '2006 BMW 325i busted', '$800'
);