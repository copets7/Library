package by.itstep.models;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "log_record")
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "close_date")
    private String closeDate;
    @Column(name = "create_by")
    private String createBy;

    public LogRecord(int id, Book book, User user, Status status, String createDate, String closeDate, String createBy) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
