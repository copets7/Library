package by.itstep.models;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "status_name")
    private String statusName;
    @OneToOne(mappedBy = "status")
    private LogRecord logRecord;

    public Status(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public Status() {
    }

    public LogRecord getLogRecord() {
        return logRecord;
    }

    public void setLogRecord(LogRecord logRecord) {
        this.logRecord = logRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id = " + id +
                " statusName = " + statusName ;
    }
}
