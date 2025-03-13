package com.spring.demo.Repository;

import com.spring.demo.Entity.Student;
import com.spring.demo.dto.Student.Studentdto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repos extends JpaRepository<Student,Long> {
    Studentdto findByid(Long id);

}
