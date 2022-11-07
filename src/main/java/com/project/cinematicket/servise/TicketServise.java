package com.project.cinematicket.servise;

import com.project.cinematicket.dto.TicketDTO;

import java.util.List;

public interface TicketServise {

    List<TicketDTO> createTickets(Long sessionId);

}
