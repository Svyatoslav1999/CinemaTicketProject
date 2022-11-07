package com.project.cinematicket.dto;

import com.project.cinematicket.enums.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDTO {
    private Long id;

    private String filmName;

    private Genre filmGenre;

}
