package com.example.cinema.controllers;

import com.example.cinema.services.ScreeningRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class ScreeningRoomController {

    private final ScreeningRoomService screeningRoomService;


    @GetMapping("/count/{movieId}")
    public ResponseEntity<Long> getRoomCountByMovieId(@PathVariable Long movieId) {
        return ResponseEntity.ok(screeningRoomService.getRoomCountByMovieId(movieId));
    }
}
