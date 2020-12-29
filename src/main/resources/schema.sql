create schema books_db;

create table books_db.books (
    id int primary key generated always as identity,
    name varchar,
    author varchar
);

select * from books_db.books
