package io.github.dam.raven.controller;

import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/raven/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping()
    public List<Genre> getAllGenres() {
        return genreService.findAll();
    }


}
