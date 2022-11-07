package com.project.cinematicket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private Long id;

    private Long price;

    private Boolean reserved;

    private Long seatNumber;

    private SessionEntity session;

    private UserEntity user;



}
