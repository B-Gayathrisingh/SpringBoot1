package com.Spring6.Springboot6.Service;

import com.Spring6.Springboot6.Dto.LaptopDto;
import com.Spring6.Springboot6.Entity.LaptopEntity;
import com.Spring6.Springboot6.Repositary.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LaptopService implements ImplService {
    @Autowired
    private Repo laptopRepositary;


    @Override
    public LaptopDto saveLaptop(LaptopDto laptopDto) {
        LaptopEntity LaptopEntity = new LaptopEntity(
                laptopDto.getId(),
                laptopDto.getName(),
                laptopDto.getModel(),
                laptopDto.getPrice()
        );
        LaptopEntity laptopEntity1 = laptopRepositary.save(LaptopEntity);
        LaptopDto LaptopDto1 = new LaptopDto(
                laptopEntity1.getId(),
                laptopEntity1.getName(),
                laptopEntity1.getModel(),
                laptopEntity1.getPrice());
        return LaptopDto1;
    }

    @Override
    public LaptopDto getById(long id) {
        LaptopEntity laptopEntity = laptopRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop is not found :" + id));
        LaptopDto LaptopDto = new LaptopDto(
                laptopEntity.getId(),
                laptopEntity.getName(),
                laptopEntity.getModel(),
                laptopEntity.getPrice());

        return LaptopDto;

    }

    @Override
    public LaptopDto updateLaptop(long id, LaptopDto LaptopDto) {
        LaptopEntity laptopEntity = laptopRepositary.findById(id)
                    .orElseThrow(() -> new RuntimeException("Laptop are not found :" + id));
        laptopEntity.setName(LaptopDto.getName());
        laptopEntity.setModel(LaptopDto.getModel());
        laptopEntity.setPrice(LaptopDto.getPrice());
            return new LaptopDto(
                    laptopEntity.getId(),
                    laptopEntity.getName(),
                    laptopEntity.getModel(),
                    laptopEntity.getPrice()
            );
    }

    @Override
    public LaptopEntity deleteLaptop(long id) {
        LaptopEntity  laptopEntity =  laptopRepositary.findById(id)
                    .orElseThrow(() -> new RuntimeException(" Laptop not found: " + id));

        laptopRepositary.delete(laptopEntity);
            return  laptopEntity;

    }


}
