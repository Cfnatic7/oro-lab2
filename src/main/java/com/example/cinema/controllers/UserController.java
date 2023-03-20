package com.example.cinema.controllers;

import com.example.cinema.dto.UserDto;
import com.example.cinema.request.BoughtReservationsRequest;
import com.example.cinema.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("screening/{screeningId}")
    public ResponseEntity<List<UserDto>> findUsersByScreeningId(@PathVariable Long screeningId) {
        List<UserDto> movies = userService.findUsersByScreeningId(screeningId);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<List<UserDto>> findUsersByUsername(@PathVariable String username) {
        List<UserDto> movies = userService.findUsersByUsername(username);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/bought-count")
    public ResponseEntity<?> getBoughtReservationsCount(
            @Valid @RequestBody BoughtReservationsRequest boughtReservationsRequest) {
        if (boughtReservationsRequest.getEndDate().isBefore(boughtReservationsRequest.getFromDate())) {
            return ResponseEntity.badRequest().body("End date before from date");
        }
        return ResponseEntity.ok(userService.getBoughtReservationsCount(boughtReservationsRequest.getFromDate(),
                boughtReservationsRequest.getEndDate()));
    }
}
