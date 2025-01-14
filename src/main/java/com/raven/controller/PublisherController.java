package com.raven.controller;

import com.raven.Mapper.PublisherMapper;
import com.raven.controller.request.PublisherRequest;
import com.raven.controller.response.PublisherResponse;
import com.raven.entity.Publisher;
import com.raven.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raven/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping()
    public ResponseEntity<List<PublisherResponse>> getAllPublisher() {
        List<PublisherResponse> publishers = publisherService.findAll()
                .stream()
                .map(PublisherMapper::toPublisherResponse)
                .toList();

        return ResponseEntity.ok(publishers);
    }

    @PostMapping
    public ResponseEntity<PublisherResponse> savePublisher(@RequestBody PublisherRequest request) {
        Publisher savedPublisher = publisherService.save(PublisherMapper.toPublisher(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(PublisherMapper.toPublisherResponse(savedPublisher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getByPublisherId(@PathVariable Long id) {
        return publisherService.findById(id)
                .map(publisher -> ResponseEntity.ok(PublisherMapper.toPublisherResponse(publisher)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteByPublisherId(@PathVariable Long id) {
        publisherService.findById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
