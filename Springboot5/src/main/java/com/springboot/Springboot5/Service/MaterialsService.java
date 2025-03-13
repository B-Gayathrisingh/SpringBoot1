package com.springboot.Springboot5.Service;

import com.springboot.Springboot5.Dto.MaterialsDto;
import com.springboot.Springboot5.Entity.MaterialsEntity;
import com.springboot.Springboot5.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MaterialsService implements ImplService {
    @Autowired
    private Repo MaterialRepositary;

    @Override
    public MaterialsEntity saveMaterials(MaterialsDto materialsDto) {
        MaterialsEntity materialsEntity = new MaterialsEntity(
                materialsDto.getId(),
                materialsDto.getName(),
                materialsDto.getGrams(),
                materialsDto.getPrice()
        );
        MaterialsEntity materialsEntity1 = MaterialRepositary.save(materialsEntity);
        MaterialsDto materialsDto1 = new MaterialsDto(
                materialsEntity1.getId(),
                materialsDto.getName(),
                materialsDto.getGrams(),
                materialsDto.getPrice());
        return materialsEntity;
    }

    @Override
    public MaterialsDto getById(long id) {
        MaterialsEntity materialsEntity = MaterialRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Materials is not found :" + id));
        MaterialsDto materialsDto = new MaterialsDto(
                materialsEntity.getId(),
                materialsEntity.getName(),
                materialsEntity.getGrams(),
                materialsEntity.getPrice());

        return materialsDto;
    }

    @Override
    public MaterialsDto updateMaterials(long id, MaterialsDto materialsDto) {
        MaterialsEntity materialsEntity = MaterialRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Materials are not found :" + id));
        materialsEntity.setName(materialsDto.getName());
        materialsEntity.setGrams(materialsDto.getGrams());
        materialsEntity.setPrice(materialsDto.getPrice());
        return new MaterialsDto(
                materialsEntity.getId(),
                materialsEntity.getName(),
                materialsEntity.getGrams(),
                materialsEntity.getPrice()
        );
    }

    @Override
    public MaterialsEntity deleteMaterials(long id) {
        MaterialsEntity materialsEntity = MaterialRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Material not found: " + id));

        MaterialRepositary.delete(materialsEntity);
        return materialsEntity;
    }
}
