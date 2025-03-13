package com.spring.Springboot12.Repository;

import com.spring.Springboot12.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<MovieEntity,Long > {
    Optional<MovieEntity>findById(Long id);
}
