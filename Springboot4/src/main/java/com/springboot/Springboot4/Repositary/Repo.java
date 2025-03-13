package com.springboot.Springboot4.Repositary;

import com.springboot.Springboot4.Entity.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<CollegeEntity,Long> {
    Optional<CollegeEntity> findByid(Long id);
}