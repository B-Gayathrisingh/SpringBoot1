package com.project2.springboot.Service;

import com.project2.springboot.DTO.ProductDto;
import com.project2.springboot.Entity.Productentity;

public interface Serviceproduct {
    ProductDto saveproduct(ProductDto productdto);
    ProductDto getById(long id);
    ProductDto updateProduct(long id, ProductDto productDto);
    Productentity deleteProduct(long id);
}


