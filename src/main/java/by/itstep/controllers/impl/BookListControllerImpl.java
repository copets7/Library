package by.itstep.controllers.impl;

import by.itstep.controllers.BookListController;
import by.itstep.models.BookList;
import by.itstep.service.impl.BookListServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BookListControllerImpl implements BookListController {

    private final BookListServiceImpl bookListService;

    public BookListControllerImpl(BookListServiceImpl bookListService) {
        this.bookListService = bookListService;
    }

    @Override
    public List<BookList> findAll() {
        return bookListService.findAll();
    }

    @Override
    public BookList findById(int id) {
        return bookListService.findById(id);
    }

    @Override
    public BookList save(BookList bookList) {
        return bookListService.save(bookList);
    }

    @Override
    public BookList update(BookList bookList) {
        return bookListService.update(bookList);
    }

    @Override
    public void delete(BookList bookList) {
        bookListService.delete(bookList);
    }

    @Override
    public void deleteById(int id) {
        bookListService.deleteById(id);
    }
}
