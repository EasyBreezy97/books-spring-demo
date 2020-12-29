package ge.tsu.books.book;

public interface BookService {
    void addBook(Book book);
    Book getBook(String name);
    void deleteBook(String name);
}
