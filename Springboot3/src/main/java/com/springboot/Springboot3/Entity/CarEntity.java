package com.springboot.Springboot3.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String model;
    private String state;

    public CarEntity(Long id, String name, String model, String state) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.state = state;
    }
    public CarEntity(){
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(id, carEntity.id) && Objects.equals(name, carEntity.name) && Objects.equals(model, carEntity.model) && Objects.equals(state, carEntity.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, state);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}