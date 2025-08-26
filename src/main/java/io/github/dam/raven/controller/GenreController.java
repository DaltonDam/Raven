package io.github.dam.raven.controller;

import io.github.dam.raven.controller.request.GenreRequest;
import io.github.dam.raven.controller.response.GenreResponse;
import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.mapper.GenreMapper;
import io.github.dam.raven.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/raven/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping()
    public ResponseEntity<List<GenreResponse>> findAll() {
        List<GenreResponse> genres = genreService.findAll().stream()
                .map(GenreMapper::toGenreResponse)
                .toList();

        return ResponseEntity.ok(genres);
    }

    @PostMapping
    public ResponseEntity<GenreResponse> createGenre(@Valid @RequestBody GenreRequest genreRequest) {
        Genre newGenre = GenreMapper.toGenre(genreRequest);
        Genre savedGenre = genreService.saveGenre(newGenre);
        return ResponseEntity.status(HttpStatus.CREATED).body(GenreMapper.toGenreResponse(newGenre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> find(@PathVariable Long id) {
        return genreService.findById(id)
                .map(genre -> ResponseEntity.ok(GenreMapper.toGenreResponse(genre)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteByGenreId(@PathVariable Long id) {
        genreService.deleteById(id);
    }

}
