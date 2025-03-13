package com.Springboot.Springboot2.Repositary;

import com.Springboot.Springboot2.Dto.CompanyDto;
import com.Springboot.Springboot2.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  Repo extends JpaRepository<CompanyEntity,Long> {
    Optional <CompanyEntity>findByid(Long id);
}
