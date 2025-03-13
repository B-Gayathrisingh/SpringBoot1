package com.Spring7.Springboot7.Controller;

import com.Spring7.Springboot7.Dto.CourseDto;
import com.Spring7.Springboot7.Entity.CourseEntity;
import com.Spring7.Springboot7.Service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/courses")
    public class CourseController {

        private final CourseService courseService;

        public CourseController(CourseService courseService) {
            this.courseService = courseService;
        }

        @PostMapping("/savecourses")
        public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto) {
            CourseDto savedCourse = courseService.saveCourse(courseDto);
            return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CourseDto> getCourseById(@PathVariable long id) {
            CourseDto courseDto = courseService.getById(id);
            return ResponseEntity.ok(courseDto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CourseDto> updateCourse(@PathVariable long id, @RequestBody CourseDto courseDto) {
            CourseDto updatedCourse = courseService.updateCourse(id, courseDto);
            return ResponseEntity.ok(updatedCourse);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<CourseDto> deleteCourse(@PathVariable long id) {
            CourseEntity deletedCourse = courseService.deleteCourse(id);

            CourseDto deletedCourseDto = new CourseDto(
                    deletedCourse.getId(),
                    deletedCourse.getStudentname(),
                    deletedCourse.getCoursename(),
                    deletedCourse.getFee()
            );

            return ResponseEntity.ok(deletedCourseDto);
        }
    }


