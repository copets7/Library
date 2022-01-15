package by.itstep.controllers.impl;

import by.itstep.controllers.TypeGenreController;
import by.itstep.models.TypeGenre;
import by.itstep.service.TypeGenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class TypeGenreControllerImpl implements TypeGenreController {

    private final TypeGenreService typeGenreService;

    public TypeGenreControllerImpl(TypeGenreService typeGenreService) {
        this.typeGenreService = typeGenreService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("genre", typeGenreService.findAll());
        return "genre/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", typeGenreService.findById(id));
        return "genre/show";
    }

    @GetMapping("/new")
    public String newGenre(@ModelAttribute("genre") TypeGenre genre) {
        return "genre/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("genre") TypeGenre genre) {
        typeGenreService.save(genre);
        return "redirect:/genre";
    }

    @GetMapping("delete/{id}")
    public String deleteGenre(@PathVariable("id") int id) {
        typeGenreService.deleteById(id);
        return "redirect:/genre";
    }

    @GetMapping("edit/{id}")
    public String updateGenreForm(@PathVariable("id") int id, Model model) {
        TypeGenre genre = typeGenreService.findById(id);
        model.addAttribute("genre", genre);
        return "genre/edit";
    }

    @PostMapping("/edit")
    public String updateGenre(TypeGenre genre) {
        typeGenreService.save(genre);
        return "redirect:/genre";
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
