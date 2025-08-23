package io.github.dam.raven.service;

import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository repository;

    public List<Genre> findAll() {
        return repository.findAll();
    }

    public Genre saveGenre(Genre genre) {
        return repository.save(genre);
    }

    public Optional<Genre> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
