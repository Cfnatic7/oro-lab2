package com.example.cinema.controllers;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.dto.ScreeningDto;
import com.example.cinema.services.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("room/{roomId}")
    public ResponseEntity<List<ScreeningDto>> findMoviesByScreeningRoomId(@PathVariable Long roomId) {
        List<ScreeningDto> movies = screeningService.findScreeningsByRoomId(roomId);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("movie-name/{title}")
    public ResponseEntity<List<ScreeningDto>> findMoviesByScreeningRoomId(@PathVariable String title) {
        List<ScreeningDto> movies = screeningService.findScreeningsByMovieTitle(title);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("movie-id/{id}")
    public ResponseEntity<List<ScreeningDto>> findMoviesByMovieId(@PathVariable Long id) {
        List<ScreeningDto> movies = screeningService.findScreeningsByMovieId(id);
        return ResponseEntity.ok(movies);
    }
}
