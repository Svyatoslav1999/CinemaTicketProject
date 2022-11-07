package com.project.cinematicket.servise.impl;

import com.project.cinematicket.dto.SessionDTO;
import com.project.cinematicket.entity.SessionEntity;
import com.project.cinematicket.mapper.SessionMapper;
import com.project.cinematicket.repository.FilmRepository;
import com.project.cinematicket.repository.SessionRepository;
import com.project.cinematicket.servise.SessionServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SessionServiseImpl implements SessionServise {

    private final SessionMapper sessionMapper;

    private final SessionRepository sessionRepository;

    private final FilmRepository filmRepository;

   private void checkIsFilmExistAndAssignToSession(SessionDTO sessionDTO, SessionEntity sessionEntity){
        if(sessionDTO.getFilm()!= null && sessionDTO.getFilm().getId()!= null){
            filmRepository.findById(sessionDTO.getFilm().getId())
                    .ifPresentOrElse(film -> sessionEntity.setFilm(film),
                            () ->{throw new ResponseStatusException(HttpStatus.NOT_FOUND);});
        }
    }
    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = sessionMapper.mapDTOtoEntity(sessionDTO);
        checkIsFilmExistAndAssignToSession(sessionDTO, sessionEntity);
        sessionRepository.saveAndFlush(sessionEntity);
       return sessionMapper.mapEntityToDTO(sessionEntity);
    }
}
