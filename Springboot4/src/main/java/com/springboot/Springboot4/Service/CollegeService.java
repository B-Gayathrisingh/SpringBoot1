package com.springboot.Springboot4.Service;

import com.springboot.Springboot4.Dto.CollegeDto;
import com.springboot.Springboot4.Entity.CollegeEntity;
import com.springboot.Springboot4.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class CollegeService implements ImplService {
    @Autowired
    private Repo CollegeRepositary;


    @Override
    public CollegeDto saveCollege(CollegeDto collegeDto) {
        CollegeEntity collegeEntity = new CollegeEntity(
                collegeDto.getId(),
                collegeDto.getName(),
                collegeDto.getStudents(),
                collegeDto.getLecturers(),
                collegeDto.getBuses()
        );
        CollegeEntity collegeEntity1 = CollegeRepositary.save(collegeEntity);
        CollegeDto collegeDto1 = new CollegeDto(
                collegeEntity1.getId(),
                collegeDto.getName(),
                collegeDto.getStudents(),
                collegeDto.getLecturers(),
                collegeDto.getBuses()
        );
        return collegeDto1;
    }

    @Override
    public CollegeDto getById(long id) {
        CollegeEntity collegeEntity = CollegeRepositary.findByid(id)
                .orElseThrow(() -> new RuntimeException("The College is not found :" + id));
        CollegeDto collegeDto = new CollegeDto(
                collegeEntity.getId(),
                collegeEntity.getName(),
                collegeEntity.getStudents(),
                collegeEntity.getLecturers(),
                collegeEntity.getBuses()
        );
        return collegeDto;
    }

    @Override
    public CollegeDto updateCollege(long id, CollegeDto collegeDto) {
        CollegeEntity collegeEntity = CollegeRepositary.findByid(id)
                .orElseThrow(() -> new RuntimeException("The College is not found :" + id));
        collegeEntity.setName(collegeDto.getName());
        collegeEntity.setStudents(collegeDto.getStudents());
        collegeEntity.setLecturers(collegeDto.getLecturers());
        collegeEntity.setBuses(collegeDto.getBuses());
        CollegeEntity collegeEntity1 = CollegeRepositary.save(collegeEntity);
        return new CollegeDto(
                collegeEntity1.getId(),
                collegeEntity1.getName(),
                collegeEntity1.getStudents(),
                collegeEntity1.getLecturers(),
                collegeEntity1.getBuses()
        );
    }

    @Override
    public CollegeEntity deleteCollege(long id) {
        CollegeEntity collegeEntity = CollegeRepositary.findByid(id)
                .orElseThrow(() -> new RuntimeException("The College is not found :" + id));
        CollegeRepositary.deleteById(id);
        return collegeEntity;
    }

}
