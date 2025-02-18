package book_service.controller;

import book_service.model.Book;
import book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        System.out.println("inside");
        return bookService.getAllBooks();
    }

    @GetMapping("/author")
    public Optional<Book> getBookByAutor(@RequestParam String author){
         return bookService.getBookByAuthor(author);
    }

    @GetMapping("/id")
    public Optional<Book> getBookById(@RequestParam int id){
       return bookService.getById(id);
    }

    @PostMapping("/create")
    public void createBook(@RequestBody Book book){
       bookService.create(book);
    }
}
