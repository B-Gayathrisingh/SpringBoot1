package com.example.project1.SpringBootPro1.Service;

import com.example.project1.SpringBootPro1.DTO.StudentDto;

public interface implservice {
    StudentDto savestudent(StudentDto studentdto);
    StudentDto getById(Long id);
    StudentDto updateStudent(Long id,StudentDto studentDto);



}
