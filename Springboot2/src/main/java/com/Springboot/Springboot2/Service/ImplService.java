package com.Springboot.Springboot2.Service;

import com.Springboot.Springboot2.Dto.CompanyDto;
import com.Springboot.Springboot2.Entity.CompanyEntity;

public interface ImplService {
    CompanyDto savecompany(CompanyDto companydto);
    CompanyDto getById(long id);
    CompanyEntity deletecompany(long id);
    CompanyDto updateCompany(long id, CompanyDto companyDto);
}
