package com.spring10.springboot10.Controller;

import com.spring10.springboot10.Dto.ZomatoDto;
import com.spring10.springboot10.Entity.ZomatoEntity;
import com.spring10.springboot10.Service.ZomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zomato")
public class ZomatoController {
    @Autowired
    private ZomatoService zomatoService;

    @GetMapping("/{id}")
    public ResponseEntity<ZomatoDto> getZomato(@PathVariable long id) {
        ZomatoDto ZomatoDto =zomatoService .getById(id);
        return new ResponseEntity<>(ZomatoDto, HttpStatus.OK);
    }
    @PostMapping("/savezomato")
    public ResponseEntity<ZomatoDto> saveZomato(@RequestBody ZomatoDto ZomatoDto) {
        ZomatoDto savedZomato = zomatoService.saveZomato(ZomatoDto);
        return new ResponseEntity<>(savedZomato,HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<ZomatoDto>updateZomato(@PathVariable long id,
                                                   @RequestBody ZomatoDto ZomatoDto){
        ZomatoDto updatedZomato = zomatoService.updateZomato(id, ZomatoDto);
        return ResponseEntity.ok(updatedZomato);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ZomatoEntity>deleteZomato(@PathVariable long id){
        ZomatoEntity Zomato=zomatoService.deleteZomato(id);
        return new ResponseEntity<>(Zomato,HttpStatus.OK);
    }
}

