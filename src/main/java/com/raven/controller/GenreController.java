package com.raven.controller;

import com.raven.Mapper.GenreMapper;
import com.raven.controller.request.GenreRequest;
import com.raven.controller.response.GenreResponse;
import com.raven.entity.Genre;
import com.raven.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/raven/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping()
    public ResponseEntity<List<GenreResponse>> getAllGenres() {
        List<GenreResponse> genres = genreService.findAll()
                .stream()
                .map(GenreMapper::toGenreResponse)
                .toList();
        return ResponseEntity.ok(genres);
    }

    @PostMapping()
    public ResponseEntity<GenreResponse> saveGenre(@RequestBody GenreRequest request) {
        Genre newGenre = GenreMapper.toGenre(request);
        Genre savedGenre = genreService.save(newGenre);
        return ResponseEntity.status(HttpStatus.CREATED).body(GenreMapper.toGenreResponse(savedGenre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> getGenreById(@PathVariable Long id) {
        return genreService.findById(id)
                .map(genre -> ResponseEntity.ok(GenreMapper.toGenreResponse(genre)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenreById(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
