package com.spring.Springboot13.Repository;

import com.spring.Springboot13.Entity.ZooEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<ZooEntity,Long> {
    Optional<ZooEntity> findByid(Long id);
}
