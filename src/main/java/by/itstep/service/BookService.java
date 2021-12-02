package by.itstep.service;

import by.itstep.models.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);

    Book save(Book book);

    Book update (Book book);

    void delete(Book book);

    void deleteById(int id);
}
