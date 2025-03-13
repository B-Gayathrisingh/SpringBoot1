package com.spring.Springboot1.Service;

import com.spring.Springboot1.Dto.ProductDto;
import com.spring.Springboot1.Entity.Productentity;
import com.spring.Springboot1.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor

public class ImplProductService implements Productservice {

    @Autowired
    private Repo ProductRepositary;

    @Override
    public ProductDto saveproduct(ProductDto productdto) {
        Productentity product = new Productentity(
                productdto.getId(),
                productdto.getName(),
                productdto.getPrice(),
                productdto.getDiscount()
        );

        Productentity savedProductentity = ProductRepositary.save(product);

        ProductDto savedProductDto = new ProductDto(
                savedProductentity.getId(),
                savedProductentity.getName(),
                savedProductentity.getPrice(),
                savedProductentity.getDiscount()
        );
        return savedProductDto;
    }


    @Override
    public ProductDto getById(long id) {
        Productentity getProduct = ProductRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found id:" + id));

        ProductDto productDto = new ProductDto(
                getProduct.getId(),
                getProduct.getName(),
                getProduct.getPrice(),
                getProduct.getDiscount());
        return productDto;
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productdto) {
        Productentity existingProductentity = ProductRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id:" + id));
        ProductDto productDto = new ProductDto(
                existingProductentity.getId(),
                existingProductentity.getName(),
                existingProductentity.getPrice(),
                existingProductentity.getDiscount());
        return productDto;
    }

    @Override
    public Productentity deleteProduct(long id) {
        Productentity productentity = ProductRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id:" + id));
        ProductRepositary.deleteById(id);
        return productentity;
    }


}



