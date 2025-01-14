package com.raven.service;

import com.raven.entity.Genre;
import com.raven.repository.GenreRepository;
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

    public Genre save(Genre genre) {
        return repository.save(genre);
    }

    public Optional<Genre> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
