package com.spring.springboot11.Repository;

import com.spring.springboot11.Entity.MallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<MallEntity,Long> {
    Optional<MallEntity> findByid(Long id);

}
