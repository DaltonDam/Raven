package com.raven.Mapper;

import com.raven.controller.request.PublisherRequest;
import com.raven.controller.response.PublisherResponse;
import com.raven.entity.Publisher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PublisherMapper {

    public static Publisher toPublisher(PublisherRequest request) {
        return Publisher
                .builder()
                .name(request.name())
                .build();
    }

    public static PublisherResponse toPublisherResponse(Publisher publisher) {
        return PublisherResponse
                .builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .build();
    }
}
