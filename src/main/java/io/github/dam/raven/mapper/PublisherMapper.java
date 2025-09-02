package io.github.dam.raven.mapper;

import io.github.dam.raven.controller.request.PublisherRequest;
import io.github.dam.raven.controller.response.PublisherResponse;
import io.github.dam.raven.entity.Publisher;

public class PublisherMapper {

    public static Publisher toPublisher(PublisherRequest publisherRequest) {
        return Publisher
                .builder()
                .name(publisherRequest.name())
                .build();
    }

    public static PublisherResponse toPublisherResponse(Publisher genre) {
        return PublisherResponse
                .builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
