CREATE TABLE IF NOT EXISTS message
(
    id   SERIAL PRIMARY KEY,
    text VARCHAR(255) UNIQUE
);

INSERT INTO message(text) values ('Hello World!');
INSERT INTO message(text) values ('Spring Boot!');