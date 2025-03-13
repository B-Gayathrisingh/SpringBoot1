package com.springboot.Springboot3.Service;

import com.springboot.Springboot3.Dto.CarDto;
import com.springboot.Springboot3.Entity.CarEntity;

public interface ImplService {
    CarEntity savecar(CarDto cardto);
    CarDto getById(long id);
    CarDto updateCar(long id, CarDto carDto);
    CarEntity deleteCar(long id);


}

