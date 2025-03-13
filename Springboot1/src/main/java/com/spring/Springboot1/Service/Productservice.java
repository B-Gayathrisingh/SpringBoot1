package com.spring.Springboot1.Service;

import com.spring.Springboot1.Dto.ProductDto;
import com.spring.Springboot1.Entity.Productentity;

public interface Productservice {
    ProductDto saveproduct(ProductDto productdto);
    ProductDto getById(long id);
   ProductDto updateProduct(long id,ProductDto productdto);
   Productentity deleteProduct(long id);

}
