package com.springboot.Springboot3.Controller;

import com.springboot.Springboot3.Dto.CarDto;
import com.springboot.Springboot3.Entity.CarEntity;
import com.springboot.Springboot3.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/car")
public class CarController {

       @Autowired
        private CarService carService;
        @GetMapping("/{id}")
        public ResponseEntity<CarDto> getCar(@PathVariable long id) {
            CarDto carDto = carService.getById(id);
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        }
        @PostMapping("/save")
        public ResponseEntity<CarEntity> saveCar(@RequestBody CarDto carDto) {
            CarEntity savedCar = carService.savecar(carDto);
            return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
        }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable long id,
                                            @RequestBody CarDto carDto) {
        CarDto updatedCar = carService.updateCar(id, carDto);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<CarEntity>deleteCar(@PathVariable long id){
            CarEntity Car=carService.deleteCar(id);
            return new ResponseEntity<>(Car, HttpStatus.OK);
        }
    }


