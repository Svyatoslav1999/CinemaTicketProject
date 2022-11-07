package com.project.cinematicket.entity;


import com.project.cinematicket.enums.Genre;
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
@Table(name = "Films")
public class FilmEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(length = 25, nullable = false)
private String filmName;

@Enumerated(EnumType.STRING)
private Genre filmGenre;



}
