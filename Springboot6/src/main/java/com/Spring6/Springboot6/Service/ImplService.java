package com.Spring6.Springboot6.Service;

import com.Spring6.Springboot6.Dto.LaptopDto;
import com.Spring6.Springboot6.Entity.LaptopEntity;

public interface ImplService {
    LaptopDto saveLaptop(LaptopDto laptopDto);
  LaptopDto getById(long id);
    LaptopDto updateLaptop(long id, LaptopDto LaptopDto);
   LaptopEntity deleteLaptop(long id);
}
