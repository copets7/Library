package by.itstep.models;

import com.opencsv.bean.CsvBindByName;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Book
 * @author Andrey Yarosh "andreyarosh7@gmail.com"
 * @version 1.0
 * @see TypeGenre
 */

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName
    @ApiModelProperty(value = "Идентификатор первичного ключа")
    private int id;
    @Column(name = "bookName")
    @CsvBindByName
    @ApiModelProperty(value = "Название книги")
    private String bookName;
    @Column(name = "author")
    @CsvBindByName
    @ApiModelProperty(value = "Автор книги")
    private String bookAuthor;
    @Column(name = "ISBN")
    @CsvBindByName
    @ApiModelProperty(value = "Уникальный номер книжного издания")
    private String ISBN;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    @CsvBindByName
    @ApiModelProperty(value = "Жанр книги")
    private TypeGenre typeGenre;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(bookName, book.bookName) && Objects.equals(bookAuthor, book.bookAuthor) && Objects.equals(ISBN, book.ISBN) && Objects.equals(typeGenre, book.typeGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookAuthor, ISBN, typeGenre);
    }
}
