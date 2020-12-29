package ge.tsu.books.book;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookServiceImpl;

    public BookController(BookService bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookServiceImpl.addBook(book);
    }

    @GetMapping("/{name}")
    public Book getBook(@PathVariable(value = "name") String name) {
        return bookServiceImpl.getBook(name);
    }

    @DeleteMapping("/{name}")
    public void deleteBook(@PathVariable(value = "name") String name) {
        bookServiceImpl.deleteBook(name);
    }

}
