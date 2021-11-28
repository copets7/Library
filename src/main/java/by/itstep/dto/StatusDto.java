package by.itstep.dto;



public class StatusDto {

    private int id;
    private String statusName;

    public StatusDto(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public StatusDto() {
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
}
