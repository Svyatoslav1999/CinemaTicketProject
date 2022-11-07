package com.project.cinematicket.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SessionDTO {

    private Long id;

    private Long sessionTime;

    private LocalDateTime startSession;

    private LocalDateTime finishSession;

    private Double ticketPrice;

    private FilmEntity film;

    private CinemaHallEntity cinemaHall;
}

