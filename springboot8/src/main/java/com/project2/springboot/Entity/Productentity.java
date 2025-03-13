package com.project2.springboot.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name=" ")

public class Productentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  double price;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Productentity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Productentity that = (Productentity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Productentity(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

