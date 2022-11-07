package com.project.cinematicket.servise.impl;

import com.project.cinematicket.dto.TicketDTO;
import com.project.cinematicket.entity.*;
import com.project.cinematicket.entity.QSessionEntity;
import com.project.cinematicket.mapper.TicketMapper;
import com.project.cinematicket.repository.SessionRepository;
import com.project.cinematicket.repository.TicketRepository;
import com.project.cinematicket.servise.TicketServise;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class TicketServiseImpl implements TicketServise {


    private final TicketRepository ticketRepository;
    private final SessionRepository sessionRepository;

    private final TicketMapper ticketMapper;

    @PersistenceContext
 private final EntityManager entityManager;

   private Tuple getNumberOfSeats(Long sessionId) {
       JPAQueryFactory queryFactory=new JPAQueryFactory(entityManager);
       QSessionEntity sessionEntity = QSessionEntity.sessionEntity;


       Tuple tuple = queryFactory.select(sessionEntity.cinemaHall.numberOfSeats, sessionEntity)
               .from(sessionEntity)
               .where(sessionEntity.id.eq(sessionId)
                       .and(sessionEntity.cinemaHall.isNotNull()))
               .fetchFirst();

       return tuple;
   }


      public List<TicketDTO> createTickets(Long sessionId) {
          Tuple tuple = getNumberOfSeats(sessionId);
          SessionEntity sessionEntity = (SessionEntity) tuple.toArray()[1];
          Long numberOfSeats = (Long) tuple.toArray()[0];
          if (numberOfSeats == null || numberOfSeats == 0){
              throw new UnsupportedOperationException();
          }
          List<TicketEntity> tickets = new ArrayList<TicketEntity>();
       for(int i = 1; i <=numberOfSeats; i++){
           TicketEntity ticket = new TicketEntity();
           ticket.setReserved(false);
           ticket.setSession(sessionEntity);
           ticket.setSeatNumber((long) i);
           tickets.add(ticket);

       }
       ticketRepository.saveAllAndFlush(tickets);

       return ticketMapper.mapToDTOList(tickets);
   }



}
