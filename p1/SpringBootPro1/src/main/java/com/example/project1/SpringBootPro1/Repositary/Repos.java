package com.example.project1.SpringBootPro1.Repositary;

import com.example.project1.SpringBootPro1.DTO.StudentDto;
import com.example.project1.SpringBootPro1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface Repos extends JpaRepository<Student,Long>{
   StudentDto findByid(long id);
    }





