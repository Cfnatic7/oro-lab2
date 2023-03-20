package com.example.cinema.controllers;

import com.example.cinema.dto.UserDto;
import com.example.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
