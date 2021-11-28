package by.itstep.service.impl;

import by.itstep.models.Book;
import by.itstep.models.LogRecord;
import by.itstep.repository.BookRepository;
import by.itstep.repository.LogRecordRepository;
import by.itstep.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final LogRecordRepository logRecordRepository;

    public BookServiceImpl(BookRepository bookRepository, LogRecordRepository logRecordRepository) {
        this.bookRepository = bookRepository;
        this.logRecordRepository = logRecordRepository;
    }

    // ????????????
    @Override
    public List<Book> findAll() {
//        List <LogRecord> logRecords = logRecordRepository.findAll();
//        List <Book> bookList = bookRepository.findAll().stream()
//                .filter(book -> !book.getLogRecord().equals(logRecords))
//                .collect(Collectors.toList());
//        return bookList;
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
