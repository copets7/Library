package by.itstep.controllers.impl;

import by.itstep.controllers.TypeGenreController;
import by.itstep.models.TypeGenre;
import by.itstep.service.impl.TypeGenreServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TypeGenreControllerImpl implements TypeGenreController {

   private final TypeGenreServiceImpl typeGenreService;

    public TypeGenreControllerImpl(TypeGenreServiceImpl typeGenreService) {
        this.typeGenreService = typeGenreService;
    }

    @Override
    public List<TypeGenre> findAll() {
        return typeGenreService.findAll();
    }

    @Override
    public TypeGenre findById(int id) {
        return typeGenreService.findById(id);
    }

    @Override
    public TypeGenre save(TypeGenre typeGenre) {
        return typeGenreService.save(typeGenre);
    }

    @Override
    public TypeGenre update(TypeGenre typeGenre) {
        return typeGenreService.update(typeGenre);
    }

    @Override
    public void delete(TypeGenre typeGenre) {
        typeGenreService.delete(typeGenre);
    }

    @Override
    public void deleteById(int id) {
        typeGenreService.deleteById(id);
    }
}
