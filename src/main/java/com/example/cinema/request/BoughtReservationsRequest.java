package com.example.cinema.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoughtReservationsRequest {

    @NotNull
    private LocalDateTime fromDate;

    @NotNull
    private LocalDateTime endDate;
}
