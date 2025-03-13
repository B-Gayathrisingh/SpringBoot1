package com.springboot.Springboot5.Entity;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class MaterialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long grams;
    private Long price;

    public MaterialsEntity(Long id, String name, Long grams, Long price) {
        this.id = id;
        this.name = name;
        this.grams = grams;
        this.price = price;
    }
    public MaterialsEntity(){
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

    public Long getGrams() {
        return grams;
    }

    public void setGrams(Long grams) {
        this.grams = grams;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        MaterialsEntity that = (MaterialsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(grams, that.grams) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grams, price);
    }

    @Override
    public String toString() {
        return "MaterialsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grams=" + grams +
                ", price=" + price +
                '}';
    }

}
