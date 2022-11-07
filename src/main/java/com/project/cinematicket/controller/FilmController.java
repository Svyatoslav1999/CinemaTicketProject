package com.project.cinematicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/film")
public class FilmController {
    private final FilmServise filmServise;


    @PostMapping("/save")
    public FilmDTO saveFilm(@RequestBody FilmDTO filmDTO) {
        return filmServise.saveFilm(filmDTO);
    }
    @DeleteMapping("/delete/{filmId}")
    public void deleteFilmById (@PathVariable("filmId") Long filmId){
        filmServise.deleteFilmById(filmId);
    }

    @GetMapping("/getAll")
    public List<FilmDTO> findAllFilms(){
        return filmServise.getAllFilms();
    }
}