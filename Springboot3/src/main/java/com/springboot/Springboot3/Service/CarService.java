package com.springboot.Springboot3.Service;

import com.springboot.Springboot3.Dto.CarDto;
import com.springboot.Springboot3.Entity.CarEntity;
import com.springboot.Springboot3.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class CarService implements ImplService {
    @Autowired
    private Repo CarRepositary;

    @Override
    public CarEntity savecar(CarDto carDto) {
        CarEntity car = new CarEntity(
                carDto.getId(),
                carDto.getName(),
                carDto.getState(),
                carDto.getModel()
        );



        CarEntity savedCarEntity = CarRepositary.save(car);

        CarDto savedCarDto = new CarDto(
                savedCarEntity.getId(),
                savedCarEntity.getState(),
                savedCarEntity.getModel(),
                savedCarEntity.getName()

        );
        return savedCarEntity;
    }
    @Override
    public CarDto getById(long id) {
        CarEntity getCar = CarRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("car not found id:" + id));

        CarDto carDto = new CarDto(
               getCar.getId(),
        getCar.getName(),
        getCar.getModel(),
        getCar.getState());
        return carDto;
    }

    @Override
    public CarDto updateCar(long id, CarDto carDto) {
        CarEntity existingCarentity = CarRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found by id:" + id));
               existingCarentity.setName(carDto.getName());
               existingCarentity.setModel(carDto.getModel());
               existingCarentity.setState(carDto.getState());

        CarEntity updatecar=CarRepositary.save(existingCarentity);
        return  new CarDto(
                updatecar.getId(),
                updatecar.getName(),
                updatecar.getModel(),
                updatecar.getState()
        );

    }
    @Override
    public CarEntity deleteCar(long id) {
        CarEntity carEntity = CarRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("car not found by id:" + id));
        CarRepositary.deleteById(id);
        return carEntity;
    }


}