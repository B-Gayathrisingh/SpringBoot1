package com.spring10.springboot10.Service;

import com.spring10.springboot10.Dto.ZomatoDto;
import com.spring10.springboot10.Entity.ZomatoEntity;

public interface ImplService {
    ZomatoDto saveZomato(ZomatoDto ZomatoDto);
    ZomatoDto getById(long id);
    ZomatoDto updateZomato(long id, ZomatoDto ZomatoDto);
    ZomatoEntity deleteZomato(long id);

}
