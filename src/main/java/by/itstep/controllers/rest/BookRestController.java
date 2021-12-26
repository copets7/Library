package by.itstep.controllers.rest;

import by.itstep.models.Book;
import by.itstep.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(value = "/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Метод находит все книги")
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> bookList = bookService.findAll();

        return bookList != null &&  !bookList.isEmpty()
                ? new ResponseEntity<>(bookList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет новую книгу")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        bookService.save(book);
        return  book!= null
                ? new ResponseEntity<>(book, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит одну книгу")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getOneBook(@PathVariable("id") int bookId) {
        final Book book = this.bookService.findById(bookId);
        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует книгу")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        bookService.save(book);
        return book != null
                ? new ResponseEntity<>(book , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет книгу")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        final Book book = this.bookService.findById(id);
        bookService.delete(book);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
