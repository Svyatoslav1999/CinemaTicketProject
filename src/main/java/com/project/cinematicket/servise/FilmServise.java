package com.project.cinematicket.servise;

import com.project.cinematicket.dto.FilmDTO;

import java.util.List;

public interface FilmServise {

    FilmDTO saveFilm (FilmDTO filmDTO);

    void deleteFilmById(Long id);

    List<FilmDTO> getAllFilms();
}
