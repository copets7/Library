package by.itstep.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "author")
    private String bookAuthor;
    @Column(name = "ISBN")
    private String ISBN;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private TypeGenre typeGenre;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private LogRecord logRecord;

    public Book(int id, String bookName, String bookAuthor, String ISBN, TypeGenre typeGenre, LogRecord logRecord) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.ISBN = ISBN;
        this.typeGenre = typeGenre;
        this.logRecord = logRecord;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public TypeGenre getTypeGenre() {
        return typeGenre;
    }

    public void setTypeGenre(TypeGenre typeGenre) {
        this.typeGenre = typeGenre;
    }

    public LogRecord getLogRecord() {
        return logRecord;
    }

    public void setLogRecord(LogRecord logRecord) {
        this.logRecord = logRecord;
    }
}
