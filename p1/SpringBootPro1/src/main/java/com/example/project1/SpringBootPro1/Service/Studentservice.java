package com.example.project1.SpringBootPro1.Service;

import com.example.project1.SpringBootPro1.DTO.StudentDto;
import com.example.project1.SpringBootPro1.Entity.Student;
import com.example.project1.SpringBootPro1.Repositary.Repos;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;




@org.springframework.stereotype.Service
@AllArgsConstructor


public class Studentservice  implements implservice {
    @Autowired
    private Repos studentRepositary;

    @Override
    public StudentDto savestudent(StudentDto studentdto) {
        Student student = new Student(
                studentdto.getId(),
                studentdto.getName(),
                studentdto.getMarks(),
                studentdto.getBranch()
        );
        Student savedstudent = studentRepositary.save(student);

        StudentDto savedStudentDto = new StudentDto(
                savedstudent.getId(),
                savedstudent.getName(),
                savedstudent.getMarks(),
                savedstudent.getBranch()
        );

        return savedStudentDto;
    }

    @Override
    public StudentDto getById(Long id) {
        StudentDto getstudent = studentRepositary.findByid(id);

        StudentDto student = new StudentDto(
                getstudent.getId(),
                getstudent.getBranch(),
                getstudent.getMarks(),
                getstudent.getName());

        return student;
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id:" + id));
        existingStudent.setName(studentDto.getName());
        existingStudent.setBranch(studentDto.getBranch());
        existingStudent.setMarks(studentDto.getMarks());


        Student updatedStudent = studentRepositary.save(existingStudent);

        return new StudentDto(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getMarks(),
                updatedStudent.getBranch());

    }

    public Student deleteStudent(Long id) {
        Student existingStudent = studentRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepositary.deleteById(id);

        return existingStudent;

    }
}


