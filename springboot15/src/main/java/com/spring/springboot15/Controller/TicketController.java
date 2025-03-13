package com.spring.springboot15.Controller;

import com.spring.springboot15.Entity.TicketEntity;
import com.spring.springboot15.Service.ImplService;
import com.spring.springboot15.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private ImplService ticketService;

    @PostMapping("/save")
    public ResponseEntity<TicketEntity> saveTicketEntity(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("place") String place,
            @RequestParam("state") String state,
            @RequestParam("cost") Double cost) throws SQLException, IOException {
        TicketEntity savedTicket = ticketService.saveTicket(photo,place,state,cost);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TicketEntity>>getTicketEntity(@PathVariable Long id) throws SQLException,IOException{
        Optional<TicketEntity> ticketEntity=ticketService.getTicketEntity(id);
        return new ResponseEntity<>(ticketEntity,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TicketEntity> updateTicketEntity(
            @PathVariable Long id,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("place") String place,
            @RequestParam("state") String state,
            @RequestParam("cost") Double cost) throws IOException {

        byte[] photoBytes = (photo != null && !photo.isEmpty()) ? photo.getBytes() : null;

        TicketEntity updateTicketEntity = ticketService.updateTicketEntity(id, place, state, cost,  photoBytes);

        return ResponseEntity.ok(updateTicketEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketEntity(@PathVariable Long id){
        ticketService.deleteTicketEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}