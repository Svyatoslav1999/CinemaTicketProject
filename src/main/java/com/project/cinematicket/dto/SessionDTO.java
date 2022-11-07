package com.project.cinematicket.dto;

import com.project.cinematicket.entity.CinemaHallEntity;
import com.project.cinematicket.entity.FilmEntity;
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

