package com.spring.Springboot12.Dto;

import java.util.Objects;

public class MovieDto {
    private Long id;
    private String name;
    private String area;
    private Double price;

    public MovieDto(Long id, String name, String area, Double price) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public MovieDto(){
        super();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(id, movieDto.id) && Objects.equals(name, movieDto.name) && Objects.equals(area, movieDto.area) && Objects.equals(price, movieDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, area, price);
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", price=" + price +
                '}';
    }
}
