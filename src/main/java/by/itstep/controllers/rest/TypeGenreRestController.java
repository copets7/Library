package by.itstep.controllers.rest;

import by.itstep.models.TypeGenre;
import by.itstep.service.TypeGenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@Api(value = "/genres")
public class TypeGenreRestController {

    private final TypeGenreService typeGenreService;

    public TypeGenreRestController(TypeGenreService typeGenreService) {
        this.typeGenreService = typeGenreService;
    }

    @ApiOperation(value = "Метод находит все жанры книг")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity< List<TypeGenre>> viewAllGenre(){
        List <TypeGenre> typeGenres = typeGenreService.findAll();
        return typeGenres != null &&  !typeGenres.isEmpty()
                ? new ResponseEntity<>(typeGenres, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод добавляет новый жанр книги")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveGenre(@RequestBody TypeGenre genre) {
        typeGenreService.save(genre);
        return  genre!= null
                ? new ResponseEntity<>(genre , HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ApiOperation(value = "Метод находит один жанр книги")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeGenre> getOneGenre(@PathVariable("id") int genreId) {
        final TypeGenre genre = this.typeGenreService.findById(genreId);

        return genre != null
                ? new ResponseEntity<>(genre, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод редактирует жанр книги")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<TypeGenre> updateGenre(@RequestBody TypeGenre genre){
        typeGenreService.save(genre);
        return genre != null
                ? new ResponseEntity<>(genre , HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Метод удаляет жанр книги")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TypeGenre> deleteGenre(@PathVariable int id){
        final TypeGenre genre = this.typeGenreService.findById(id);
        typeGenreService.delete(genre);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
