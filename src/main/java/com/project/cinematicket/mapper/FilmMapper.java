package com.project.cinematicket.mapper;

import com.project.cinematicket.dto.FilmDTO;
import com.project.cinematicket.entity.FilmEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper {
    FilmDTO mapEntityToDTO(FilmEntity filmEntity);

    FilmEntity mapDTOtoEntity(FilmDTO filmDTO);

    List<FilmDTO> mapToDTOList(List<FilmEntity> filmEntities);
}
