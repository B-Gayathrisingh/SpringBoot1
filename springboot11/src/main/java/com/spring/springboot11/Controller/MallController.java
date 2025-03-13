package com.spring.springboot11.Controller;

import com.spring.springboot11.Dto.MallDto;
import com.spring.springboot11.Entity.MallEntity;
import com.spring.springboot11.Service.ImplService;
import com.spring.springboot11.Service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mall")
public class MallController  {
    @Autowired
    private MallService mallService;
    @GetMapping("/{id}")
    public ResponseEntity<MallDto> getMall(@PathVariable long id) {
        MallDto mallDto = mallService.getById(id);
        return new ResponseEntity<>(mallDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<MallEntity> saveMall(@RequestBody MallDto mallDto) {
        MallEntity savedMall = mallService.savemall(mallDto);
        return new ResponseEntity<>(savedMall, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MallDto> updateMall(@PathVariable long id,
                                            @RequestBody MallDto mallDto) {
        MallDto updatedMall = mallService.updateMall(id, mallDto);
        return ResponseEntity.ok(updatedMall);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MallEntity>deleteMall(@PathVariable long id){
        MallEntity Mall=mallService.deleteMall(id);
        return new ResponseEntity<>(Mall, HttpStatus.OK);
    }

}
