package com.raven.controller.response;

import lombok.Builder;

@Builder
public record PublisherResponse(Long id, String name) {
}
