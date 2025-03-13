package com.spring.springboot15.Service;

import com.spring.springboot15.Entity.TicketEntity;
import com.spring.springboot15.Repository.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImplService implements TicketService {
    @Autowired
    private Repo ticketRepository;

    public TicketEntity saveTicket(MultipartFile file, String place, String state, double cost) throws SQLException, IOException {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCost(cost);
        ticketEntity.setPlace(place);
        ticketEntity.setState(state);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
           // byte[] photoBlob = new SerialBlob(photoBytes);
            ticketEntity.setPhoto(photoBytes);
        }
        return ticketRepository.save(ticketEntity);
    }
    public Optional<TicketEntity> getTicketEntity(Long id) {
        return ticketRepository.findById(id) ;
    }

    public TicketEntity updateTicketEntity(Long id, String place, String state,Double cost, byte[] photobytes) {

        TicketEntity ticketEntity =ticketRepository.findById(id).get();
        if (place != null) ticketEntity.setPlace(place);
        if (state != null) ticketEntity.setState(state);
        if (cost != null) ticketEntity.setCost(cost);
        if (photobytes != null && photobytes.length > 0) {
            byte[] photobytes1 = new byte[0];
            ticketEntity.setPhoto(photobytes1);
        }

        return ticketRepository.save(ticketEntity);
    }
    public void deleteTicketEntity(Long id){
        Optional<TicketEntity>theTicketEntity=ticketRepository.findByid(id);
        if (theTicketEntity.isPresent()){
            ticketRepository.deleteById(id);
        }
    }

    @Override
    public Optional<TicketEntity> findById(Long id) {
        return Optional.empty();
    }
}


