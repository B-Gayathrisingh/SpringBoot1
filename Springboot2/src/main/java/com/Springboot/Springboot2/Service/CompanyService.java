package com.Springboot.Springboot2.Service;

import com.Springboot.Springboot2.Dto.CompanyDto;
import com.Springboot.Springboot2.Entity.CompanyEntity;
import com.Springboot.Springboot2.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CompanyService implements ImplService {

    @Autowired
    private Repo CompanyRepositary;

    @Override
    public CompanyDto savecompany(CompanyDto companydto) {
        CompanyEntity company = new CompanyEntity(
                companydto.getId(),
                companydto.getName(),
                companydto.getEmployees(),
                companydto.getDomain()
        );


        CompanyEntity savedCompanyEntity = CompanyRepositary.save(company);

        CompanyDto savedCompanyDto = new CompanyDto(
                savedCompanyEntity.getId(),
                savedCompanyEntity.getName(),
                savedCompanyEntity.getEmployees(),
                savedCompanyEntity.getDomain()
        );
        return savedCompanyDto;
    }
    @Override
    public CompanyDto getById(long id) {
        CompanyEntity getCompany = CompanyRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("company not found id:" + id));

        CompanyDto companyDto = new CompanyDto(
                getCompany.getId(),
                getCompany.getName(),
                getCompany.getEmployees(),
                getCompany.getDomain());
        return companyDto;
    }
    @Override
    public CompanyDto updateCompany(long id, CompanyDto companyDto) {
        CompanyEntity existingCompanyentity = CompanyRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found by id:" + id));
        CompanyDto companydto = new CompanyDto(
                existingCompanyentity.getId(),
                existingCompanyentity.getName(),
                existingCompanyentity.getEmployees(),
                existingCompanyentity.getDomain());
        return companyDto;

    }

    @Override
    public CompanyEntity deletecompany(long id) {
        CompanyEntity companyEntity = CompanyRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found by id:" + id));
        CompanyRepositary.deleteById(id);
        return companyEntity;
    }



}









