package com.springboot.Springboot3.Repositary;

import com.springboot.Springboot3.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  Repo extends JpaRepository<CarEntity,Long> {
    Optional<CarEntity> findByid(Long id);
}

