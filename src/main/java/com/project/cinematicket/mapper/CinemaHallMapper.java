package com.project.cinematicket.mapper;

import com.project.cinematicket.dto.CinemaHallDTO;
import com.project.cinematicket.entity.CinemaHallEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CinemaHallMapper {
    CinemaHallDTO mapEntityToDTO(CinemaHallEntity cinemaHallEntity);

    CinemaHallEntity mapDTOtoEntity(CinemaHallDTO cinemaHallDTO);

    @Mapping(target = "id", ignore = true)
    void updateCinemaHall(@MappingTarget CinemaHallEntity cinemaHallEntity, CinemaHallDTO cinemaHallDTO);

    List<CinemaHallDTO> mapToDTOList(List<CinemaHallEntity> cinemaHallEntities);
}
