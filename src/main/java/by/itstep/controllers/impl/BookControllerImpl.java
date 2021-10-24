package by.itstep.controllers.impl;

import by.itstep.controllers.BookController;
import by.itstep.models.Book;
import by.itstep.service.BookService;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BookControllerImpl implements BookController {

   private final BookService bookService;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookService.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookService.update(book);
    }

    @Override
    public void delete(Book book) {
        bookService.delete(book);
    }

    @Override
    public void deleteById(int id) {
        bookService.deleteById(id);
    }
}
