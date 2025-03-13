package com.springboot.Springboot5.Service;

import com.springboot.Springboot5.Dto.MaterialsDto;
import com.springboot.Springboot5.Entity.MaterialsEntity;

public interface ImplService {
    MaterialsEntity saveMaterials(MaterialsDto materialsDto);
    MaterialsDto getById(long id);
    MaterialsDto updateMaterials(long id, MaterialsDto materialsDto);
    MaterialsEntity deleteMaterials(long id);

}
