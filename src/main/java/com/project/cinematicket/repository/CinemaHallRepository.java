package com.project.cinematicket.repository;

import com.project.cinematicket.entity.CinemaHallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHallEntity, Long> {

}
