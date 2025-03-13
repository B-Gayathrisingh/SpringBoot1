package com.springboot.Springboot5.Repositary;

import com.springboot.Springboot5.Entity.MaterialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Repo extends JpaRepository<MaterialsEntity,Long> {
    Optional<MaterialsEntity>findById(Long id);


}
