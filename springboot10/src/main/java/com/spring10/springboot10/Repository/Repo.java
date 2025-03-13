package com.spring10.springboot10.Repository;

import com.spring10.springboot10.Entity.ZomatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<ZomatoEntity, Long> {
    Optional<ZomatoEntity> findById(long id);

}
