package com.spring.Springboot1.Controller;

import com.spring.Springboot1.Dto.ProductDto;
import com.spring.Springboot1.Entity.Productentity;
import com.spring.Springboot1.Service.ImplProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ImplProductService implProduct;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProduct(@PathVariable long id) {
        ImplProductService productservice;
        ProductDto ProductDto =implProduct.getById(id);
        return new ResponseEntity<>(ProductDto, HttpStatus.OK);
    }
    @PostMapping("/saveproduct")
    public ResponseEntity<ProductDto>saveproduct(@RequestBody ProductDto productDto){
        ProductDto saveproduct=implProduct.saveproduct((productDto));
        return new ResponseEntity<>(saveproduct,HttpStatus.CREATED);
    }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto>updateProduct(
          @PathVariable long id,
  @RequestBody ProductDto productDto) {
      ProductDto product = implProduct.updateProduct(id, productDto);
      return new ResponseEntity<>(product, HttpStatus.CREATED);
  }
      @DeleteMapping("/{id}")
              public ResponseEntity<Productentity>deleteProducts(@PathVariable long id){
          Productentity products=implProduct.deleteProduct(id);
          return new ResponseEntity<>(products,HttpStatus.OK);
      }

  }



