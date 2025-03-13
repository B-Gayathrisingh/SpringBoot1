package com.spring.springboot11.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table
@Data
public class MallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String area;
    private String state;

    public MallEntity(Long id, String name, String area, String state) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.state = state;
    }
    public MallEntity(){
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MallEntity that = (MallEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(area, that.area) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, area, state);
    }

    @Override
    public String toString() {
        return "MallEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
