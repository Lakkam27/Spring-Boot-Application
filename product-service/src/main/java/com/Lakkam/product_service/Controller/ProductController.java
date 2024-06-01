package com.Lakkam.product_service.Controller;

import com.Lakkam.product_service.Model.Product;
import com.Lakkam.product_service.Service.ProductService;
import com.Lakkam.product_service.dto.ProductRequest;
import com.Lakkam.product_service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;


    @PostMapping()
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return new ResponseEntity<>("New product is created ",HttpStatus.CREATED);

    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
       return productService.getAllProducts();


    }
}
