package by.itstep.dto;



public class TypeGenreDto {

    private int id;
    private String genreName;

    public TypeGenreDto(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public TypeGenreDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
