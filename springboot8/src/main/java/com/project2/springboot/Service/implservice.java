package com.project2.springboot.Service;

import com.project2.springboot.DTO.ProductDto;
import com.project2.springboot.Entity.Productentity;
import com.project2.springboot.Repositary.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class implservice implements Serviceproduct {
    @Autowired
    private Repo productrepo;

    @Override
    public ProductDto saveproduct(ProductDto productdto){
        Productentity s1=new Productentity(
                productdto.getId(),
                productdto.getName(),
                productdto.getPrice()

        );
        Productentity A= productrepo.save(s1);

        Productentity savedProduct = productrepo.save(s1);
        ProductDto savedProductDto = new ProductDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice());

        return savedProductDto;
    }
    @Override
    public ProductDto getById(long id) {
        Productentity getProduct = productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found id:" + id));

        ProductDto productDto = new ProductDto(
                getProduct.getId(),
                getProduct.getName(),
                getProduct.getPrice());

        return productDto;
    }

    @Override
    public ProductDto updateProduct(long id, ProductDto productDto) {
        Productentity existingProductentity = productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id:" + id));
        existingProductentity.setName(productDto.getName());
        existingProductentity.setPrice(productDto.getPrice());

        Productentity updateproduct=productrepo.save(existingProductentity);
        return  new ProductDto(
                updateproduct.getId(),
                updateproduct.getName(),
                updateproduct.getPrice()
        );
    }

    @Override
    public Productentity deleteProduct(long id) {
        Productentity productentity = productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found by id:" + id));
        productrepo.deleteById(id);
        return productentity;
    }

}

