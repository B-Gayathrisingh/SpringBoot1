package com.spring10.springboot10.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class ZomatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private String customername;
    private String area;
    private Long phnnum;
    private Double price;




//    public ZomatoEntity(Long id, String product, String customername, Long phnnum, String area, Double price) {
//    }

    public ZomatoEntity(Long id, String product, String customername, Long phnnum, String area, Double price) {
        this.id = id;
        this.product = product;
        this.customername = customername;
        this.area = area;
        this.phnnum = phnnum;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(Long phnnum) {
        this.phnnum = phnnum;
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
        ZomatoEntity that = (ZomatoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(customername, that.customername) && Objects.equals(area, that.area) && Objects.equals(phnnum, that.phnnum) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, customername, area, phnnum, price);
    }

    @Override
    public String toString() {
        return "ZomatoEntity{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", customername='" + customername + '\'' +
                ", area='" + area + '\'' +
                ", phnnum=" + phnnum +
                ", price=" + price +
                '}';
    }
}