package com.spring.springboot15.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table
@Data
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String place;
    private String state;
    private Double cost;
    @Lob
    private byte[] photo;

    public TicketEntity(String place, String state, Double cost, byte[] photo) {
        this.place = place;
        this.state = state;
        this.cost = cost;
        this.photo = photo;
    }

    public TicketEntity(Long id, String place, String state, Double cost, byte[] photo) {
        this.id = id;
        this.place = place;
        this.state = state;
        this.cost = cost;
        this.photo = photo;
    }
    public TicketEntity(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(place, that.place) && Objects.equals(state, that.state) && Objects.equals(cost, that.cost) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, state, cost, photo);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", state='" + state + '\'' +
                ", cost=" + cost +
                ", photo=" + photo +
                '}';
    }

    public TicketEntity save(TicketEntity ticketEntity) {
        return null;
    }
}


