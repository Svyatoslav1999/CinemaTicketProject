package com.project.cinematicket.servise.impl;

import com.project.cinematicket.dto.FilmDTO;
import com.project.cinematicket.entity.FilmEntity;
import com.project.cinematicket.mapper.FilmMapper;
import com.project.cinematicket.repository.CinemaHallRepository;
import com.project.cinematicket.repository.FilmRepository;
import com.project.cinematicket.servise.FilmServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FilmServiseImpl implements FilmServise {
    private final FilmMapper filmMapper;
    private final FilmRepository filmRepository;

    private final CinemaHallRepository cinemaHallRepository;

//    private void checkIsCinemaHallExistAndAssignToFilm(FilmDTO filmDTO, FilmEntity filmEntity){
//        if(filmDTO.getCinemaHall()!= null && filmDTO.getCinemaHall().getId()!= null){
//            cinemaHallRepository.findById(filmDTO.getCinemaHall().getId())
//                    .ifPresentOrElse(cinemaHall -> filmEntity.setCinemaHall(cinemaHall),
//                            () ->{throw new ResponseStatusException(HttpStatus.NOT_FOUND);});
//        }
//    }

    @Override
    public FilmDTO saveFilm(FilmDTO filmDTO) {
        FilmEntity filmEntity = filmMapper.mapDTOtoEntity(filmDTO);
 //       checkIsCinemaHallExistAndAssignToFilm(filmDTO, filmEntity);
        filmRepository.saveAndFlush(filmEntity);
        return filmMapper.mapEntityToDTO(filmEntity);

    }

    @Override
    public void deleteFilmById(Long id) {
        FilmEntity filmEntity = filmRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hall not found");
        });
        filmRepository.deleteById(id);
    }

    @Override
    public List<FilmDTO> getAllFilms() {
        List<FilmEntity> filmEntities = filmRepository.findAll();
        List<FilmDTO> filmDTOS = filmMapper.mapToDTOList(filmEntities);
        return filmDTOS;
    }


}
