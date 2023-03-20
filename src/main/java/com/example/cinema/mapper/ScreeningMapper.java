package com.example.cinema.mapper;

import com.example.cinema.dto.ScreeningDto;
import com.example.cinema.model.Screening;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapper {

    public ScreeningDto mapToDto(Screening screening) {
        return ScreeningDto
                .builder()
                .movieName(screening.getMovie().getTitle())
                .roomName(screening.getScreeningRoom().getName())
                .startTime(screening.getStartTime().toString())
                .build();
    }
}
