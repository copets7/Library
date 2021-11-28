package by.itstep.dto;


public class LogRecordDto {

    private int id;
    private String book;
    private String user;
    private String status;
    private String createDate;
    private String closeDate;
    private String createBy;

    public LogRecordDto(int id, String book, String user, String status, String createDate, String closeDate, String createBy) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.status = status;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.createBy = createBy;
    }

    public LogRecordDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
