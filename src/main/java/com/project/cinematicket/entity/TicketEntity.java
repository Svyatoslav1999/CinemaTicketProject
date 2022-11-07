package com.project.cinematicket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Tickets")
public class TicketEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private Long price;


private Boolean reserved;

private Long seatNumber;

@OneToOne
private SessionEntity session;

@ManyToOne
private UserEntity user;




}
