package com.springboot.Springboot4.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class CollegeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String name;
        private Long students;
        private Long lecturers;
        private Long buses;

    public CollegeEntity(Long id, String name, Long students, Long lecturers, Long buses) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.lecturers = lecturers;
        this.buses = buses;
    }
    public CollegeEntity(){
        super();
    }

    public Long getId() {
        return id;
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

    public Long getStudents() {
        return students;
    }

    public void setStudents(Long students) {
        this.students = students;
    }

    public Long getLecturers() {
        return lecturers;
    }

    public void setLecturers(Long lecturers) {
        this.lecturers = lecturers;
    }

    public Long getBuses() {
        return buses;
    }

    public void setBuses(Long buses) {
        this.buses = buses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CollegeEntity that = (CollegeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(students, that.students) && Objects.equals(lecturers, that.lecturers) && Objects.equals(buses, that.buses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, students, lecturers, buses);
    }

    @Override
    public String toString() {
        return "CollegeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", lecturers=" + lecturers +
                ", buses=" + buses +
                '}';
    }
}
