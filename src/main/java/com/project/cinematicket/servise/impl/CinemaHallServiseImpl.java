package com.project.cinematicket.servise.impl;

import com.project.cinematicket.dto.CinemaHallDTO;
import com.project.cinematicket.entity.CinemaHallEntity;
import com.project.cinematicket.mapper.CinemaHallMapper;
import com.project.cinematicket.repository.CinemaHallRepository;
import com.project.cinematicket.servise.CinemaHallServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallServiseImpl implements CinemaHallServise {

    private final CinemaHallMapper cinemaHallMapper;

    private final CinemaHallRepository cinemaHallRepository;


    @Override
    public CinemaHallDTO saveCinemaHall(CinemaHallDTO cinemaHallDTO) {
        CinemaHallEntity cinemaHallEntity = cinemaHallMapper.mapDTOtoEntity(cinemaHallDTO);
cinemaHallRepository.saveAndFlush(cinemaHallEntity);
        return cinemaHallMapper.mapEntityToDTO(cinemaHallEntity);
    }

    @Override
    public CinemaHallDTO updateCinemaHallById(Long id, CinemaHallDTO cinemaHallDTO) {
                CinemaHallEntity cinemaHallEntity = cinemaHallRepository.findById(id).orElseThrow(()->{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hall not found");
        });
        cinemaHallMapper.updateCinemaHall(cinemaHallEntity, cinemaHallDTO);
        cinemaHallRepository.saveAndFlush(cinemaHallEntity);
        return cinemaHallMapper.mapEntityToDTO(cinemaHallEntity);
    }

    @Override
    public void deleteCinemaHallById(Long id) {
        CinemaHallEntity cinemaHallEntity = cinemaHallRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hall not found");
        });
        cinemaHallRepository.deleteById(id);
    }

    @Override
    public List<CinemaHallDTO> getAllCinemaHalls() {
        List<CinemaHallEntity> cinemaHallEntities = cinemaHallRepository.findAll();
List<CinemaHallDTO> cinemaHallDTOS = cinemaHallMapper.mapToDTOList(cinemaHallEntities);
return cinemaHallDTOS;
    }


}
