package com.springboot.Springboot4.Service;

import com.springboot.Springboot4.Dto.CollegeDto;
import com.springboot.Springboot4.Entity.CollegeEntity;

public interface ImplService {

    CollegeDto saveCollege(CollegeDto collegeDto);
    CollegeDto getById(long id);
    CollegeDto updateCollege(long id, CollegeDto collegeDto);
    CollegeEntity deleteCollege(long id);
}
