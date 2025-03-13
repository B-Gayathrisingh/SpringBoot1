package com.example.project1.SpringBootPro1.Controller;

import com.example.project1.SpringBootPro1.DTO.StudentDto;
import com.example.project1.SpringBootPro1.Entity.Student;
import com.example.project1.SpringBootPro1.Service.Studentservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Studentcontroller {
    @Autowired
    private Studentservice studentservice;
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>getStudent(@PathVariable long id ){
        StudentDto student = studentservice.getById(id);
        return  new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PostMapping("savestudent")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody  StudentDto studentDto){
      StudentDto saveStudent=studentservice.savestudent(studentDto);
      return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDto studentDto) {

        StudentDto updatedStudent = studentservice.updateStudent(id, studentDto);

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){

        Student Student = studentservice.deleteStudent(id);

        return new ResponseEntity<>(Student, HttpStatus.OK);
    }
}

