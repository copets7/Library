package by.itstep.service;
import by.itstep.models.TypeGenre;

import java.util.List;

public interface TypeGenreService {
    List<TypeGenre> findAll();

    TypeGenre findById(int id);

    TypeGenre save(TypeGenre typeGenre);

    TypeGenre update (TypeGenre typeGenre);

    void delete(TypeGenre typeGenre);

    void deleteById(int id);
}
