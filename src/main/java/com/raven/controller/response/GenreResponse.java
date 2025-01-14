package com.raven.controller.response;

import lombok.Builder;

@Builder
public record GenreResponse(Long id, String name) {
}
