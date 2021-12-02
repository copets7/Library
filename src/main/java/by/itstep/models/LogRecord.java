package by.itstep.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "log_record")
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "close_date")
    private LocalDate closeDate;
    @Column(name = "create_by")
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
    public String toString() {
        return "LogRecord{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", status=" + status +
                ", createDate='" + createDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
