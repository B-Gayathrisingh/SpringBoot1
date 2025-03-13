package com.spring.springboot11.Dto;

import java.util.Objects;

public class MallDto {
    private Long id;
    private String name;
    private String area;
    private String state;

    public MallDto(Long id, String name, String area, String state) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.state = state;
    }
    public MallDto(){
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
        MallDto mallDto = (MallDto) o;
        return Objects.equals(id, mallDto.id) && Objects.equals(name, mallDto.name) && Objects.equals(area, mallDto.area) && Objects.equals(state, mallDto.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, area, state);
    }

    @Override
    public String toString() {
        return "MallDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
