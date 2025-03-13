package com.spring.demo.Controller;


import com.spring.demo.Service.service;
import com.spring.demo.dto.Student.Studentdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private service student;

    @PostMapping("/savestudent")
    public ResponseEntity<Studentdto> saveStudent(@RequestBody Studentdto studentDto){
        Studentdto postStudent=student.savestudent(studentDto);
        return new ResponseEntity<>(postStudent, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudent(@PathVariable Long id){
        Studentdto students= student.getById(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
}

}


