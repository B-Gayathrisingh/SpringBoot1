package com.Spring6.Springboot6.Controller;


import com.Spring6.Springboot6.Dto.LaptopDto;
import com.Spring6.Springboot6.Entity.LaptopEntity;
import com.Spring6.Springboot6.Service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/laptops")
    @RequiredArgsConstructor
    public class LaptopController {

        private final LaptopService laptopService;


        @PostMapping("/save")
        public ResponseEntity<LaptopDto> saveLaptop(@RequestBody LaptopDto laptopDto) {
            LaptopDto savedLaptop = laptopService.saveLaptop(laptopDto);
            return new ResponseEntity<>(savedLaptop, HttpStatus.CREATED);
        }


        @GetMapping("/{id}")
        public ResponseEntity<LaptopDto> getLaptopById(@PathVariable long id) {
            LaptopDto laptopDto = laptopService.getById(id);
            return ResponseEntity.ok(laptopDto);
        }


        @PutMapping("/{id}")
        public ResponseEntity<LaptopDto> updateLaptop(
                @PathVariable long id,
                @RequestBody LaptopDto laptopDto
        ) {
            LaptopDto updatedLaptop = laptopService.updateLaptop(id, laptopDto);
            return ResponseEntity.ok(updatedLaptop);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<LaptopDto> deleteLaptop(long id) {
            LaptopEntity laptopEntity = laptopRepositary.findById(id)
                    .orElseThrow(() -> new RuntimeException("Laptop not found: " + id));

            laptopRepositary.delete(laptopEntity);
            return laptopEntity;

        }
    }


