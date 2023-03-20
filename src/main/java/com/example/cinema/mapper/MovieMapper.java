package com.example.cinema.mapper;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto mapToDto(Movie movie) {
        return MovieDto.builder().title(movie.getTitle()).build();
    }
}
