package com.spring10.springboot10.Service;

import com.spring10.springboot10.Dto.ZomatoDto;
import com.spring10.springboot10.Entity.ZomatoEntity;
import com.spring10.springboot10.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZomatoService implements ImplService {
    @Autowired
    private Repo zomatoRepository;

    @Override
    public ZomatoDto saveZomato(ZomatoDto ZomatoDto) {
        ZomatoEntity zomatoEntity = new ZomatoEntity(
                ZomatoDto.getId(),
                ZomatoDto.getProduct(),
                ZomatoDto.getCustomername(),
                ZomatoDto.getPhnnum(),
                ZomatoDto.getArea(),
                ZomatoDto.getPrice()
        );

        ZomatoEntity savedEntity = zomatoRepository.save(zomatoEntity);
        ZomatoDto zomatoDto=new ZomatoDto(
                savedEntity.getId(),
                savedEntity.getProduct(),
                savedEntity.getCustomername(),
                savedEntity.getPhnnum(),
                savedEntity.getArea(),
                savedEntity.getPrice()
        );

        return zomatoDto;
    }

    @Override
    public ZomatoDto getById(long id) {
        ZomatoEntity zomatoEntity = zomatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zomato entity not found for ID: " + id));

        return new ZomatoDto(
                zomatoEntity.getId(),
                zomatoEntity.getProduct(),
                zomatoEntity.getCustomername(),
                zomatoEntity.getPhnnum(),
                zomatoEntity.getArea(),
                zomatoEntity.getPrice()
        );
    }

    @Override
    public  ZomatoDto updateZomato(long id, ZomatoDto zomatoDto) {
        ZomatoEntity existingZomato = zomatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zomato not found: " + id));

        existingZomato.setProduct(zomatoDto.getProduct());
        existingZomato.setCustomername(zomatoDto.getCustomername());
        existingZomato.setPhnnum(zomatoDto.getPhnnum());
        existingZomato.setArea(zomatoDto.getArea());
        existingZomato.setPrice(zomatoDto.getPrice());

        ZomatoEntity updatedEntity = zomatoRepository.save(existingZomato);

        return new ZomatoDto(
                updatedEntity.getId(),
                updatedEntity.getProduct(),
                updatedEntity.getCustomername(),
                updatedEntity.getPhnnum(),
                updatedEntity.getArea(),
                updatedEntity.getPrice()
        );
    }

    @Override
    public ZomatoEntity deleteZomato(long id) {
       ZomatoEntity zomatoEntity = zomatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Zomato not found: " + id));

        zomatoRepository.delete(zomatoEntity);
        return zomatoEntity;

    }

}


