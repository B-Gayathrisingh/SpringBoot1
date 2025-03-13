package com.spring.springboot11.Service;

import com.spring.springboot11.Dto.MallDto;
import com.spring.springboot11.Entity.MallEntity;
import com.spring.springboot11.Repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MallService implements ImplService {
    @Autowired
    private Repo MallRepository;

    @Override
    public MallEntity savemall(MallDto malldto) {
        MallEntity mall = new MallEntity(
                malldto.getId(),
                malldto.getName(),
                malldto.getArea(),
                malldto.getState()
        );
        MallEntity savedMallEntity = MallRepository.save(mall);

        MallDto savedMallDto = new MallDto(
                savedMallEntity.getId(),
                savedMallEntity.getName(),
                savedMallEntity.getArea(),
                savedMallEntity.getState()

        );
        return savedMallEntity;
    }

    @Override
    public MallDto getById(long id) {
        MallEntity getMall = MallRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("mall not found id:" + id));

        MallDto mallDto = new MallDto(
                getMall.getId(),
                getMall.getName(),
                getMall.getArea(),
                getMall.getState());
        return mallDto;
    }

    @Override
    public MallDto updateMall(long id, MallDto mallDto) {
        MallEntity existingMallentity = MallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mall not found by id:" + id));
        existingMallentity.setName(mallDto.getName());
        existingMallentity.setArea(mallDto.getArea());
        existingMallentity.setState(mallDto.getState());

        MallEntity updatemall=MallRepository.save(existingMallentity);
        return  new MallDto(
                updatemall.getId(),
                updatemall.getName(),
                updatemall.getArea(),
                updatemall.getState()
        );
    }

    @Override
    public MallEntity deleteMall(long id) {
        MallEntity mallEntity = MallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("mall not found by id:" + id));
        MallRepository.deleteById(id);
        return mallEntity;
    }
}

