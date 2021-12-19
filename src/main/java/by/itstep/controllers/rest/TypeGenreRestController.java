package by.itstep.controllers.rest;


import by.itstep.models.TypeGenre;
import by.itstep.service.TypeGenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class TypeGenreRestController {

    private final TypeGenreService typeGenreService;

    public TypeGenreRestController(TypeGenreService typeGenreService) {
        this.typeGenreService = typeGenreService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity< List<TypeGenre>> viewAllGenre(){
        List <TypeGenre> typeGenres = typeGenreService.findAll();
        return typeGenres != null &&  !typeGenres.isEmpty()
                ? new ResponseEntity<>(typeGenres, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
