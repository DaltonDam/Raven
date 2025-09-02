package io.github.dam.raven.service;

import io.github.dam.raven.entity.Genre;
import io.github.dam.raven.entity.Publisher;
import io.github.dam.raven.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository repository;

    public List<Publisher> findAll() {
        return repository.findAll();
    }

    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }

    public Optional<Publisher> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
