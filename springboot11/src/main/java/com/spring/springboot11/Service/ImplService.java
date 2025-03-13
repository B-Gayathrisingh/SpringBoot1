package com.spring.springboot11.Service;

import com.spring.springboot11.Dto.MallDto;
import com.spring.springboot11.Entity.MallEntity;

public interface ImplService {
    MallEntity savemall(MallDto malldto);
    MallDto getById(long id);
    MallDto updateMall(long id, MallDto mallDto);
    MallEntity deleteMall(long id);
}
