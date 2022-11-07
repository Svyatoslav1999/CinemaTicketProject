package com.project.cinematicket.controller;

import com.project.cinematicket.dto.CinemaHallDTO;
import com.project.cinematicket.servise.CinemaHallServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cinemaHall")
public class CinemaHallController {

    private final CinemaHallServise cinemaHallServise;

    @PostMapping("/save")
    public CinemaHallDTO saveCinemaHall(@RequestBody CinemaHallDTO cinemaHallDTO){
        return cinemaHallServise.saveCinemaHall(cinemaHallDTO);
    }

    @PutMapping("/update/{cinemaHallId}")
    public CinemaHallDTO updateCinemaHallById(@PathVariable("cinemaHallId") Long cinemaHallId, @RequestBody CinemaHallDTO cinemaHallDTO){
        return cinemaHallServise.updateCinemaHallById(cinemaHallId, cinemaHallDTO);
    }


    @DeleteMapping("/delete/{cinemaHallId}")
    public void deleteCinemaHallById (@PathVariable("cinemaHallId") Long cinemaHallId){
        cinemaHallServise.deleteCinemaHallById(cinemaHallId);
    }

    @GetMapping("/getAll")
    public List<CinemaHallDTO> findAllCinemaHalls(){

        return cinemaHallServise.getAllCinemaHalls();
    }
}
