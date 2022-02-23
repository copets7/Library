package by.itstep.models;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Record
 * @author Andrey Yarosh <andreyarosh7@gmail.com>
 * @version 1.0
 * @see Book
 * @see User
 * @see Status
 */

@Entity
@Table(name = "log_record")
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Идентификатор первичного ключа")
    private int id;
    @OneToOne
    @JoinColumn(name = "book_id")
    @ApiModelProperty(value = "Объект класса книга")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(value = "Объект класса пользователь")
    private User user;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @ApiModelProperty(value = "Объект класса статус")
    private Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date")
    @ApiModelProperty(value = "Дата выдачи книги")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "close_date")
    @ApiModelProperty(value = "Дата возврата книги")
    private LocalDate closeDate;
    @Column(name = "create_by")
    @ApiModelProperty(value = "Имя выдающего книгу")
    private String createBy;

    public LogRecord(int id, Book book, User user, Status status, LocalDate createDate, LocalDate closeDate, String createBy) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.status = status;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.createBy = createBy;
    }

    public LogRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogRecord)) return false;
        LogRecord logRecord = (LogRecord) o;
        return id == logRecord.id && Objects.equals(book, logRecord.book) && Objects.equals(user, logRecord.user) && Objects.equals(status, logRecord.status) && Objects.equals(createDate, logRecord.createDate) && Objects.equals(closeDate, logRecord.closeDate) && Objects.equals(createBy, logRecord.createBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, user, status, createDate, closeDate, createBy);
    }
}
