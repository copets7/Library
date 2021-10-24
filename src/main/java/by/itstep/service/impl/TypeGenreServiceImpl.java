package by.itstep.service.impl;

import by.itstep.models.TypeGenre;
import by.itstep.repository.TypeGenreRepository;
import by.itstep.service.TypeGenreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeGenreServiceImpl implements TypeGenreService {

  private final TypeGenreRepository typeGenreRepository;

    public TypeGenreServiceImpl(TypeGenreRepository typeGenreRepository) {
        this.typeGenreRepository = typeGenreRepository;
    }

    @Override
    public List<TypeGenre> findAll() {
        return typeGenreRepository.findAll();
    }

    @Override
    public TypeGenre findById(int id) {
        return typeGenreRepository.findById(id).get();
    }

    @Override
    public TypeGenre save(TypeGenre typeGenre) {
        return typeGenreRepository.save(typeGenre);
    }

    @Override
    public TypeGenre update(TypeGenre typeGenre) {
        return typeGenreRepository.saveAndFlush(typeGenre);
    }

    @Override
    public void delete(TypeGenre typeGenre) {
        typeGenreRepository.delete(typeGenre);
    }

    @Override
    public void deleteById(int id) {
        typeGenreRepository.deleteById(id);
    }
}
