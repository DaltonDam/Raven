package io.github.dam.raven.service;

import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository repository;

    public List<Genre> findAll() {
        return repository.findAll();
    }

}
