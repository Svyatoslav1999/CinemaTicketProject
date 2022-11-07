package com.project.cinematicket.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CinemaHall")
public class CinemaHallEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long numberOfSeats;


}
