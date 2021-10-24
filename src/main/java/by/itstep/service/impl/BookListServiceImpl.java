package by.itstep.service.impl;

import by.itstep.models.BookList;
import by.itstep.repository.BookListRepository;
import by.itstep.service.BookListService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookListServiceImpl implements BookListService {

    private final BookListRepository bookListRepository;

    public BookListServiceImpl(BookListRepository bookListRepository) {
        this.bookListRepository = bookListRepository;
    }

    @Override
    public List<BookList> findAll() {
        return bookListRepository.findAll();
    }

    @Override
    public BookList findById(int id) {
        return bookListRepository.findById(id).get();
    }

    @Override
    public BookList save(BookList bookList) {
        return bookListRepository.save(bookList);
    }

    @Override
    public BookList update(BookList bookList) {
        return bookListRepository.saveAndFlush(bookList);
    }

    @Override
    public void delete(BookList bookList) {
        bookListRepository.delete(bookList);
    }

    @Override
    public void deleteById(int id) {
        bookListRepository.deleteById(id);
    }
}
