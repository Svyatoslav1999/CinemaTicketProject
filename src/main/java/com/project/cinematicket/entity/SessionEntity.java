package com.project.cinematicket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Sessions")
public class SessionEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long sessionTime;

private LocalDateTime startSession;

private LocalDateTime finishSession;

private Double ticketPrice;

@ManyToOne
private FilmEntity film;

@OneToOne
private CinemaHallEntity cinemaHall;
}
