package com.example.cinema.mapper;

import com.example.cinema.dto.ScreeningRoomDto;
import com.example.cinema.model.ScreeningRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScreeningRoomMapper {

    private final ScreeningMapper screeningMapper;

    public ScreeningRoomDto mapToDto(ScreeningRoom screeningRoom) {
        return ScreeningRoomDto
                .builder()
                .name(screeningRoom.getName())
                .screenings(screeningRoom
                        .getScreenings()
                        .stream()
                        .map(screeningMapper::mapToDto)
                        .toList())
                .build();
    }
}
