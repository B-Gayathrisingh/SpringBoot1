package com.example.project1.SpringBootPro1.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Student_details")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double marks;
    private  String branch;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", branch='" + branch + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(marks, student.marks) && Objects.equals(branch, student.branch);
    }

    public Student(){
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks, branch);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Student(Long id, String name, Double marks, String branch) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.branch = branch;
    }
}
