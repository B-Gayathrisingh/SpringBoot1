package com.spring.Springboot13.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class ZooEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String animalname;
    private String gender;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] photo;

    public ZooEntity(String animalname, String gender, Byte photo) {
        this.animalname = animalname;
        this.gender = gender;
        this.photo = new byte[0];
    }

    public ZooEntity(Long id, String animalname, String gender, Byte photo) {
        this.id = id;
        this.animalname = animalname;
        this.gender = gender;
        this.photo = new byte[0];
    }
    public ZooEntity(){
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ZooEntity zooEntity = (ZooEntity) o;
        return Objects.equals(id, zooEntity.id) && Objects.equals(animalname, zooEntity.animalname) && Objects.equals(gender, zooEntity.gender) && Objects.equals(photo, zooEntity.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalname, gender, photo);
    }

    @Override
    public String toString() {
        return "ZooEntity{" +
                "id=" + id +
                ", animalname='" + animalname + '\'' +
                ", gender='" + gender + '\'' +
                ", photo=" + photo +
                '}';
    }
}
