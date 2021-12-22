package by.itstep.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_genre")
public class TypeGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "genre_name")
    private String genreName;

    public TypeGenre() {
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

    @Override
    public String toString() {
        return
                "id " + id +
                " genreName = " + genreName ;
    }
}
