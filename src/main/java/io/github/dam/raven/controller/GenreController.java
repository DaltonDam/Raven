package io.github.dam.raven.controller;

import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/raven/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping()
    public List<Genre> getAllGenres() {
        return genreService.findAll();
    }

    @PostMapping
    public Genre saveGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    @GetMapping("/{id}")
    public Genre getByGenreId(@PathVariable Long id) {
        Optional<Genre> optGenre = genreService.findById(id);
        if(optGenre.isPresent()) {
            return optGenre.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteByGenreId(@PathVariable Long id) {
        genreService.deleteById(id);
    }

}
