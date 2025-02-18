package book_service.service;

import book_service.dao.BookRepo;
import book_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Optional<Book> getBookByAuthor(String author){
        return bookRepo.findByAuthor(author);
    }

    public void create(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getById(int id) {
        return bookRepo.findById(id);
    }
}
