package com.spring.Springboot13.Service;

import com.spring.Springboot13.Entity.ZooEntity;

import java.util.Optional;

public interface ZooService {
    Optional<ZooEntity> getZooEntity(Long id);
}
