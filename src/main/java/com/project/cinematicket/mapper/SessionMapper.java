package com.project.cinematicket.mapper;

import com.project.cinematicket.dto.SessionDTO;
import com.project.cinematicket.entity.SessionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {

    SessionDTO mapEntityToDTO(SessionEntity sessionEntity);

    SessionEntity mapDTOtoEntity(SessionDTO sessionDTO);

    List<SessionDTO> mapToDTOList(List<SessionEntity> sessionEntities);
}
