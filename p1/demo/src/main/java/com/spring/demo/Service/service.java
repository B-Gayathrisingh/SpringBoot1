package com.spring.demo.Service;

import com.spring.demo.dto.Student.Studentdto;

public interface service {
    Studentdto savestudent(Studentdto studentDto);

    Studentdto getById(Long id);
}
