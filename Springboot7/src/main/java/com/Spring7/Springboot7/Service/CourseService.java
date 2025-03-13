package com.Spring7.Springboot7.Service;

import com.Spring7.Springboot7.Dto.CourseDto;
import com.Spring7.Springboot7.Entity.CourseEntity;
import com.Spring7.Springboot7.Repositary.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class CourseService implements ImplService{
    @Autowired
    private Repo CourseRepositary ;


    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        CourseEntity courseEntity = new CourseEntity(
                courseDto.getId(),
                courseDto.getStudentname(),
                courseDto.getCoursename(),
                courseDto.getFee()
        );
        CourseEntity courseEntity1 = CourseRepositary.save(courseEntity);
        CourseDto CourseDto1 = new CourseDto(
                courseEntity1.getId(),
                courseEntity1.getStudentname(),
                courseEntity1.getCoursename(),
                courseEntity1.getFee()
        );

        return CourseDto1;
    }


    @Override
    public CourseDto getById(long id) {
        CourseEntity courseEntity = CourseRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Course is not found :" + id));
        CourseDto courseDto = new CourseDto(
                courseEntity.getId(),
                courseEntity.getStudentname(),
                courseEntity.getCoursename(),
                courseEntity.getFee());

        return courseDto;
    }

    @Override
    public CourseDto updateCourse(long id, CourseDto CourseDto) {
        CourseEntity courseEntity = CourseRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Course are not found :" + id));
        courseEntity.setStudentname(CourseDto.getStudentname());
        courseEntity.setCoursename(CourseDto.getCoursename());
        courseEntity.setFee(CourseDto.getFee());
        CourseEntity courseEntity1=CourseRepositary.save(courseEntity);
        return new CourseDto(
                courseEntity1.getId(),
                courseEntity1.getStudentname(),
              courseEntity1.getCoursename(),
                courseEntity1.getFee()
        );
    }

    @Override
    public CourseEntity deleteCourse(long id) {
            CourseEntity courseEntity = CourseRepositary.findById(id)
                    .orElseThrow(() -> new RuntimeException("course not found: " + id));

            CourseRepositary.delete(courseEntity);
            return courseEntity;
        }

    }


