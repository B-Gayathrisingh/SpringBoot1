package com.spring.Springboot1.Repositary;

import com.spring.Springboot1.Dto.ProductDto;
import com.spring.Springboot1.Entity.Productentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository <Productentity,Long>{
    ProductDto findByid(long id);
}
