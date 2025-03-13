package com.Springboot.Springboot2.Controller;

import com.Springboot.Springboot2.Dto.CompanyDto;
import com.Springboot.Springboot2.Entity.CompanyEntity;
import com.Springboot.Springboot2.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/company")
    public class CompanyController {
        @Autowired
        private CompanyService companyService;
        @GetMapping("/{id}")
        public ResponseEntity<CompanyDto> getCompany(@PathVariable long id) {
            CompanyDto companyDto = companyService.getById(id);
            return new ResponseEntity<>(companyDto, HttpStatus.OK);
        }
        @PostMapping("/save")
        public ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto companyDto) {
            CompanyDto savedCompany = companyService.savecompany(companyDto);
            return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CompanyDto>updateCompany(
                @PathVariable long id,
                @RequestBody CompanyDto companyDto) {
            CompanyDto company = companyService.updateCompany(id, companyDto);
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<CompanyEntity>deletecompany(@PathVariable long id){
            CompanyEntity Company=companyService.deletecompany(id);
            return new ResponseEntity<>(Company, HttpStatus.OK);
        }
    }
