package by.itstep.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "status_name")
    private String statusName;
//    @OneToMany(mappedBy = "status")
//    private List<LogRecord> logRecord;

    public Status() {
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

//    public List<LogRecord> getLogRecord() {
//        return logRecord;
//    }
//
//    public void setLogRecord(List<LogRecord> logRecord) {
//        this.logRecord = logRecord;
//    }
}
