package by.itstep.service;

import by.itstep.models.Book;
import by.itstep.models.BookList;

import java.util.List;

public interface BookListService {

    List<BookList> findAll();

    BookList findById(int id);

    BookList save(BookList bookList);

    BookList update (BookList bookList);

    void delete(BookList bookList);

    void deleteById(int id);
}
