package com.spring.Springboot13.Service;

import com.spring.Springboot13.Entity.ZooEntity;
import com.spring.Springboot13.Repository.Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImplService implements ZooService {
    @Autowired
    private Repo zooRepository;

    public ZooEntity saveZoo(MultipartFile file, String name, String Gender) throws SQLException, IOException {
        ZooEntity zooEntity = new ZooEntity();
        zooEntity.setAnimalname(name);
        zooEntity.setGender(Gender);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
         //   Blob photoBlob = new SerialBlob(photoBytes);
            zooEntity.setPhoto(photoBytes);
        }
        return zooRepository.save(zooEntity);
    }

    @Override
    public Optional<ZooEntity> getZooEntity(Long id) {
        return zooRepository.findById(id) ;
    }

    public ZooEntity updateZooEntity(Long id, String animalname, String gender, byte[] photo) {

        ZooEntity zooEntity =zooRepository.findById(id).get();
        if (animalname != null) zooEntity.setAnimalname(animalname);
        if (gender != null) zooEntity.setGender(gender);
        if (photo != null && photo.length > 0) {
            byte[] photo1 = new byte[0];
            zooEntity.setPhoto(photo1);
        }

        return zooRepository.save(zooEntity);
    }
    public void deleteZooEntity(Long id){
        Optional<ZooEntity>theZooEntity=zooRepository.findByid(id);
        if (theZooEntity.isPresent()){
            zooRepository.deleteById(id);
        }
   }
}
