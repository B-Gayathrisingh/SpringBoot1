package com.spring.springboot15.Service;


import com.spring.springboot15.Entity.TicketEntity;

import java.util.Optional;

public interface TicketService {

    Optional<TicketEntity> findById(Long id);

}

