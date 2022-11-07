package com.project.cinematicket.repository;


import com.project.cinematicket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findBySeatNumber(Long seatNumber);
}
