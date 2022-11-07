package com.project.cinematicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketServise ticketServise;

    @PostMapping("/create/{sessionId}")
    public List<TicketDTO> createTicket (@PathVariable("sessionId") Long sessionId) {
        return ticketServise.createTickets(sessionId);

    }

}