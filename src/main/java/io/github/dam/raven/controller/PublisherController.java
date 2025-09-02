package io.github.dam.raven.controller;


import io.github.dam.raven.controller.request.PublisherRequest;
import io.github.dam.raven.controller.response.PublisherResponse;
import io.github.dam.raven.entity.Publisher;
import io.github.dam.raven.mapper.PublisherMapper;
import io.github.dam.raven.service.PublisherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raven/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping()
    public ResponseEntity<List<PublisherResponse>> findAll() {
        List<PublisherResponse> publishers = publisherService.findAll().stream()
                .map(PublisherMapper::toPublisherResponse)
                .toList();

        return ResponseEntity.ok(publishers);
    }

    @PostMapping
    public ResponseEntity<PublisherResponse> createPublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher newPublisher = PublisherMapper.toPublisher(publisherRequest);
        Publisher savedPublisher = publisherService.save(newPublisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(PublisherMapper.toPublisherResponse(newPublisher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> find(@PathVariable Long id) {
        return publisherService.findById(id)
                .map(publisher -> ResponseEntity.ok(PublisherMapper.toPublisherResponse(publisher)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteByPublisherId(@PathVariable Long id) {
        publisherService.delete(id);
    }

}
