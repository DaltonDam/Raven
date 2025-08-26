package io.github.dam.raven.mapper;

import io.github.dam.raven.controller.request.GenreRequest;
import io.github.dam.raven.controller.response.GenreResponse;
import io.github.dam.raven.entity.Genre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GenreMapper {

    public static Genre toGenre(GenreRequest genreRequest) {
        return Genre
                .builder()
                .name(genreRequest.name())
                .build();
    }

    public static GenreResponse toGenreResponse(Genre genre) {
        return GenreResponse
                .builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

}
