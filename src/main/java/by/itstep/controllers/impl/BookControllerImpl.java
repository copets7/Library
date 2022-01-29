package by.itstep.controllers.impl;

import by.itstep.addDataToDataBaseFromFile.AddListOfBooksFromFile;
import by.itstep.controllers.BookController;
import by.itstep.models.Book;
import by.itstep.parser.CsvParser;
import by.itstep.service.BookService;
import by.itstep.service.TypeGenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookControllerImpl implements BookController {

    private final Logger logger = LoggerFactory.getLogger(BookControllerImpl.class);


    private final BookService bookService;
    private final TypeGenreService typeGenreService;
    private final CsvParser csvParser;

    public BookControllerImpl(BookService bookService, TypeGenreService typeGenreService, CsvParser csvParser) {
        this.bookService = bookService;
        this.typeGenreService = typeGenreService;
        this.csvParser = csvParser;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/index";
    }

    @GetMapping(value = "/upload")
    public String uploadForm() {
        return "book/upload";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        csvParser.fromDataBaseToFile(file,"book");
        return "redirect:/book";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book, Model model) {
        model.addAttribute("genres", typeGenreService.findAll());
        return "book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book, @RequestParam("id") int id) {
        book.setTypeGenre(typeGenreService.findById(id));
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/book";
    }

    @GetMapping("edit/{id}")
    public String updateBookForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("genres", typeGenreService.findAll());
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit")
    public String updateBook(Book book, @RequestParam("typeGenre.id") int genreId) {
        book.setTypeGenre(typeGenreService.findById(genreId));
        bookService.save(book);
        return "redirect:/book";
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
