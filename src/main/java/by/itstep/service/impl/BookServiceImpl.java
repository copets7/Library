package by.itstep.service.impl;

import by.itstep.models.Book;
import by.itstep.repository.BookRepository;
import by.itstep.repository.LogRecordRepository;
import by.itstep.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final LogRecordRepository logRecordRepository;

    public BookServiceImpl(BookRepository bookRepository, LogRecordRepository logRecordRepository) {
        this.bookRepository = bookRepository;
        this.logRecordRepository = logRecordRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
