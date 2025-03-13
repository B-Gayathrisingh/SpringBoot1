package com.Spring6.Springboot6.Dto;

import java.util.Objects;

public class LaptopDto {
    private Long id;
    private String name;
    private String model;
    private Double price;

    public LaptopDto(Long id, String name, String model, Double price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        LaptopDto laptopDto = (LaptopDto) o;
        return Objects.equals(id, laptopDto.id) && Objects.equals(name, laptopDto.name) && Objects.equals(model, laptopDto.model) && Objects.equals(price, laptopDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, price);
    }

    @Override
    public String toString() {
        return "LaptopDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
