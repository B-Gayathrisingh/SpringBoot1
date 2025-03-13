package com.Spring6.Springboot6.Repositary;

import com.Spring6.Springboot6.Entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<LaptopEntity,Long> {
    Optional<LaptopEntity> findById(Long id);
}
