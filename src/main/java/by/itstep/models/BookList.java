package by.itstep.models;

import javax.persistence.*;

@Entity
@Table(name = "book_list")
public class BookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    @OneToOne(mappedBy = "bookList", cascade = CascadeType.ALL)
    LogRecord logRecord;

    public BookList(int book_id, LogRecord logRecord) {
        this.book_id = book_id;
        this.logRecord = logRecord;
    }

    public BookList() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }



    public LogRecord getLogRecord() {
        return logRecord;
    }

    public void setLogRecord(LogRecord logRecord) {
        this.logRecord = logRecord;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "book_id=" + book_id ;
    }
}
