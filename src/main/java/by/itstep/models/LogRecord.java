package by.itstep.models;

import javax.persistence.*;

@Entity
@Table(name = "log_record")
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "lib_code")
    private BookList bookList;
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


    public LogRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookList getBookList() {
        return bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
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

    @Override
    public String toString() {
        return "LogRecord{" +
                "id=" + id +
                ", createDate='" + createDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", createBy='" + createBy + '\'' +
                ", bookList=" + bookList +
                ", user=" + user +
                ", status=" + status +
                '}';
    }
}
