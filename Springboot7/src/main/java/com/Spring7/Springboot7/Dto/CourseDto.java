package com.Spring7.Springboot7.Dto;

import java.util.Objects;

public class CourseDto {
    private Long id;
    private String coursename;
    private String studentname;
    private Double Fee;

    public CourseDto(Long id, String coursename, String studentname, Double fee) {
        this.id = id;
        this.coursename = coursename;
        this.studentname = studentname;
        Fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        Fee = fee;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Objects.equals(id, courseDto.id) && Objects.equals(coursename, courseDto.coursename) && Objects.equals(studentname, courseDto.studentname) && Objects.equals(Fee, courseDto.Fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coursename, studentname, Fee);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", studentname='" + studentname + '\'' +
                ", Fee=" + Fee +
                '}';
    }
}
