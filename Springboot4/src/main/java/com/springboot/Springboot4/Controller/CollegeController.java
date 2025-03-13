package com.springboot.Springboot4.Controller;

import com.springboot.Springboot4.Dto.CollegeDto;
import com.springboot.Springboot4.Entity.CollegeEntity;
import com.springboot.Springboot4.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @GetMapping("/{id}")
    public ResponseEntity<CollegeDto> getCollege(@PathVariable long id) {
        CollegeDto collegeDto = collegeService.getById(id);
        return new ResponseEntity<>(collegeDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<CollegeDto> saveCollege(@RequestBody CollegeDto collegeDto) {
        CollegeDto savedCollege = collegeService.saveCollege(collegeDto);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<CollegeDto>updateCollege(@PathVariable long id,
                                               @RequestBody CollegeDto collegeDto){
        CollegeDto updatedCollege = collegeService.updateCollege(id, collegeDto);
        return ResponseEntity.ok(updatedCollege);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<CollegeEntity>deleteCollege(@PathVariable long id){
        CollegeEntity College=collegeService.deleteCollege(id);
        return new ResponseEntity<>(College,HttpStatus.OK);
    }
}
