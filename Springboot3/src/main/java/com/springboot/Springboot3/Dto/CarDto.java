package com.springboot.Springboot3.Dto;

import java.util.Objects;

public class CarDto {
    private Long id;
    private String name;
    private String model;
    private String state;

    public CarDto(Long id, String name, String model, String state) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return Objects.equals(id, carDto.id) && Objects.equals(name, carDto.name) && Objects.equals(model, carDto.model) && Objects.equals(state, carDto.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, state);
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
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}