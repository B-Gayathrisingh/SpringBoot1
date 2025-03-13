package com.spring.springboot15.Repository;

import com.spring.springboot15.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<TicketEntity,Long> {
    Optional<TicketEntity>findById(Long id);

    Optional<TicketEntity> findByid(Long id);
}
