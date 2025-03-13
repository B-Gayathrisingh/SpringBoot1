package com.springboot.Springboot5.Controller;

import com.springboot.Springboot5.Dto.MaterialsDto;
import com.springboot.Springboot5.Entity.MaterialsEntity;
import com.springboot.Springboot5.Service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Materials")
public class MaterialsController {
    @Autowired
    private MaterialsService materialsservice;

    @GetMapping("/{id}")
    public ResponseEntity<MaterialsDto> getMaterials(@PathVariable long id) {
        MaterialsDto Materials = materialsservice.getById(id);
        return new ResponseEntity<>(Materials, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<MaterialsDto>updateMaterials(@PathVariable long id,
                                                   @RequestBody MaterialsDto materialsDto){
        MaterialsDto updatedMaterials = materialsservice.updateMaterials(id, materialsDto);
        return ResponseEntity.ok(updatedMaterials);
    }
    @PostMapping("/save")
    public ResponseEntity<MaterialsEntity>saveMaterials(@RequestBody MaterialsDto materialsDto){
        MaterialsEntity saveMaterials=materialsservice.saveMaterials(materialsDto);
        return new ResponseEntity<>(saveMaterials,HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<MaterialsEntity>deleteMaterials(@PathVariable long id){
        MaterialsEntity Materials=materialsservice.deleteMaterials(id);
        return new ResponseEntity<>(Materials,HttpStatus.OK);
    }
}
