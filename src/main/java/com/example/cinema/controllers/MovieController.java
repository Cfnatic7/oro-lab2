package com.example.cinema.controllers;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/screening-room/{roomId}")
    public ResponseEntity<List<MovieDto>> findMoviesByScreeningRoomId(@PathVariable Long roomId) {
        List<MovieDto> movies = movieService.findMoviesByScreeningRoomId(roomId);
        return ResponseEntity.ok(movies);
    }
}
