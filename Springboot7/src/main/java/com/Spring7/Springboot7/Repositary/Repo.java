package com.Spring7.Springboot7.Repositary;

import com.Spring7.Springboot7.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<CourseEntity,Long> {
    Optional<CourseEntity> findById(Long id);
}
