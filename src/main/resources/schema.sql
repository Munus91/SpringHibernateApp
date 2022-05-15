DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS books;

CREATE TABLE authors(
                          author_id SERIAL PRIMARY KEY NOT NULL,
                          author_name CHARACTER VARYING(100) NOT NULL,
                          age INTEGER NOT NULL);

CREATE TABLE genres(
                     genre_id SERIAL PRIMARY KEY NOT NULL,
                     genre_name CHARACTER VARYING(100) NOT NULL
                    );

CREATE TABLE books(
                          book_id SERIAL PRIMARY KEY NOT NULL,
                          book_name CHARACTER VARYING(100) NOT NULL,
                          price DECIMAL NOT NULL);

ALTER TABLE books ADD COLUMN author_id INTEGER;
ALTER TABLE books ADD COLUMN genre_id  INTEGER;

