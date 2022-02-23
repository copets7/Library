package by.itstep.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Genre
 * @author Andrey Yarosh <andreyarosh7@gmail.com>
 * @version 1.0
 */

@Entity
@Table(name = "type_genre")
public class TypeGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Идентификатор первичного ключа")
    private int id;
    @Column(name = "genre_name")
    @ApiModelProperty(value = "Жанр книги")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeGenre)) return false;
        TypeGenre genre = (TypeGenre) o;
        return id == genre.id && Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreName);
    }
}
