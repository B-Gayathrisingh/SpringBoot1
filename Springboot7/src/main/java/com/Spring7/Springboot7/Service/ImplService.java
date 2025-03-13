package com.Spring7.Springboot7.Service;

import com.Spring7.Springboot7.Dto.CourseDto;
import com.Spring7.Springboot7.Entity.CourseEntity;

public interface ImplService {
    CourseDto saveCourse(CourseDto CourseDto);
    CourseDto getById(long id);
    CourseDto updateCourse(long id, CourseDto CourseDto);
    CourseEntity deleteCourse(long id);
}

