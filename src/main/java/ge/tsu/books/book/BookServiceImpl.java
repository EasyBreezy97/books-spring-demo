package ge.tsu.books.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final JdbcTemplate jdbcTemplate;

    public BookServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update("insert into books_db.books (name, author) values (?, ?)", book.getName(), book.getAuthor());

    }

    @Override
    public Book getBook(String name) {
        RowMapper<Book> mapper =
                (rs, rowNum) -> new Book(rs.getInt(1), rs.getString(2), rs.getString(3));
        List<Book> books = jdbcTemplate.query("select * from books_db.books where name = ?", mapper, name);

        return books.get(0);
    }

    @Override
    public void deleteBook(String name) {
        jdbcTemplate.update("delete from books_db.books where name=?", name);
    }
}
