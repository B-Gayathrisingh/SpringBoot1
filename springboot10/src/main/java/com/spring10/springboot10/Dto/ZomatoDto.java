package com.spring10.springboot10.Dto;

import java.util.Objects;

public class ZomatoDto {
    private Long id;
    private String product;
    private String customername;
    private String area;
    private Long phnnum;
    private Double price;
//
//    public ZomatoDto(Long id, String product, String customername, String area, Long phnnum, Double price) {
//        this.id = id;
//        this.product = product;
//        this.customername = customername;
//        this.area = area;
//        this.phnnum = phnnum;
//        this.price = price;
//    }

    public ZomatoDto(){
        super();
    }

    public ZomatoDto(Long id, String product, String customername, Long phnnum, String area, Double price) {
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
        ZomatoDto zomatoDto = (ZomatoDto) o;
        return Objects.equals(id, zomatoDto.id) && Objects.equals(product, zomatoDto.product) && Objects.equals(customername, zomatoDto.customername) && Objects.equals(area, zomatoDto.area) && Objects.equals(phnnum, zomatoDto.phnnum) && Objects.equals(price, zomatoDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, customername, area, phnnum, price);
    }

    @Override
    public String toString() {
        return "ZomatoDto{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", customername='" + customername + '\'' +
                ", area='" + area + '\'' +
                ", phnnum=" + phnnum +
                ", price=" + price +
                '}';
    }
}