package com.spring.springboot15.Dto;

import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

public class TicketDto {
    private Long id;
    private String place;
    private String state;
    private Double cost;
    @Lob
    private byte[] photo;

    public TicketDto(Long id, String place, String state, Double cost, byte[] photo) {
        this.id = id;
        this.place = place;
        this.state = state;
        this.cost = cost;
        this.photo = photo;
    }

    public TicketDto(String place, String state, Double cost, byte[] photo) {
        this.place = place;
        this.state = state;
        this.cost = cost;
        this.photo = photo;
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
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) && Objects.equals(place, ticketDto.place) && Objects.equals(state, ticketDto.state) && Objects.equals(cost, ticketDto.cost) && Objects.deepEquals(photo, ticketDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, state, cost, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", state='" + state + '\'' +
                ", cost=" + cost +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}

