package com.project.cinematicket.servise;

import com.project.cinematicket.dto.CinemaHallDTO;

import java.util.List;

public interface CinemaHallServise {
CinemaHallDTO saveCinemaHall(CinemaHallDTO cinemaHallDTO);

    CinemaHallDTO updateCinemaHallById(Long id, CinemaHallDTO cinemaHallDTO);

    void deleteCinemaHallById(Long id);

     List<CinemaHallDTO> getAllCinemaHalls();
}
