package com.spring.demo.Service;

import com.spring.demo.Repository.repos;
import com.spring.demo.dto.Student.Studentdto;
import com.spring.demo.Entity.Student; // Assuming Student is an entity class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class implservice implements service {

    @Autowired
    private repos studentRepository; // Renaming 'student' to 'studentRepository' for clarity

    @Override
    public Studentdto savestudent(Studentdto studentDto) {
        // Convert studentdto to entity
        Student stud = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getMarks(),
                studentDto.getBranch());

        // Save entity to the repository
        Student savedStudent = studentRepository.save(stud);

        // Convert the saved entity back to DTO
        Studentdto savedStudentDto = new Studentdto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getMarks(),
                savedStudent.getBranch());

        return savedStudentDto;
    }

    @Override
    public Studentdto getById(Long id) {
        Studentdto getstudent = studentRepository.findByid(id);


        Studentdto student = new Studentdto(
                getstudent.getId(),
                getstudent.getBranch(),
                getstudent.getMarks(),
                getstudent.getName());

        return student;
    }
}
