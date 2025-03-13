package com.spring.Springboot13.Controller;

import com.spring.Springboot13.Entity.ZooEntity;
import com.spring.Springboot13.Service.ImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/zoo")
public class ZooController {
    @Autowired
    private ImplService zooService;

    @PostMapping("/save")
    public ResponseEntity<ZooEntity> saveZooEntity(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("animalname") String animalname,
            @RequestParam("gender") String gender) throws SQLException, IOException {
        ZooEntity savedZoo = zooService.saveZoo(photo,animalname,gender);
        return new ResponseEntity<>(savedZoo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
public ResponseEntity<Optional<ZooEntity>>getZooEntity(@PathVariable Long id) throws SQLException,IOException{
    Optional<ZooEntity> zooEntity=zooService.getZooEntity(id);
    return new ResponseEntity<>(zooEntity,HttpStatus.OK);
}
@PutMapping("/{id}")
public ResponseEntity<ZooEntity> updateZooEntity(
        @PathVariable Long id,
        @RequestParam(value = "photo", required = false) MultipartFile photo,
        @RequestParam("animalname") String animalname,
        @RequestParam("gender") String gender) throws IOException {

    byte[] photoBytes = (photo != null && !photo.isEmpty()) ? photo.getBytes() : null;

    ZooEntity updateZooEntity = zooService.updateZooEntity(id, animalname, gender, photoBytes);

    return ResponseEntity.ok(updateZooEntity);
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZooEntity(@PathVariable Long id){
        zooService.deleteZooEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
  }
}

