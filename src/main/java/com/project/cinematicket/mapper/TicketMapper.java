package com.project.cinematicket.mapper;


import com.project.cinematicket.dto.TicketDTO;
import com.project.cinematicket.entity.TicketEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TicketMapper {
    TicketDTO mapEntityToDTO(TicketEntity ticketEntity);

    TicketEntity mapDTOtoEntity(TicketDTO ticketDTO);

    List<TicketDTO> mapToDTOList(List<TicketEntity> ticketEntities);
}
