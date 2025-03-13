package com.spring.Springboot13.Dto;

import org.apache.tomcat.util.codec.binary.Base64;
import java.util.Objects;

public class ZooDto {
    private Long id;
    private String animalname;
    private String gender;
    private String photo;

    public ZooDto(Long id, String animalname, String gender, byte[] photoBytes) {
        this.id = id;
        this.animalname = animalname;
        this.gender = gender;
        this.photo = (photoBytes != null) ? Base64.encodeBase64String(photoBytes) : null;
    }

    public ZooDto(String animalname, String gender, String photo) {
        this.animalname = animalname;
        this.gender = gender;
        this.photo = photo;
    }

    public ZooDto(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ZooDto zooDto = (ZooDto) o;
        return Objects.equals(id, zooDto.id) && Objects.equals(animalname, zooDto.animalname) && Objects.equals(gender, zooDto.gender) && Objects.equals(photo, zooDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalname, gender, photo);
    }

    @Override
    public String toString() {
        return "ZooDto{" +
                "id=" + id +
                ", animalname='" + animalname + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}

