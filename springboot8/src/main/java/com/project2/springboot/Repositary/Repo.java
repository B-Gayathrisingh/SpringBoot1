package com.project2.springboot.Repositary;

import com.project2.springboot.DTO.ProductDto;
import com.project2.springboot.Entity.Productentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Productentity,Long> {
    ProductDto findByid(long id);

}
