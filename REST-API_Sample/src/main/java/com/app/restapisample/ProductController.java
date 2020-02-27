package com.app.restapisample.controllers;

import com.app.products.models.Product;
import com.app.products.repository.IProductRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.event.RelationalEventWithIdAndEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("api")
public class ProductController {
    @Autowired
    private IProductRepository productRepository;

    @GetMapping("/")
    public String welcome(){
        return "it works";
    }
    @GetMapping("products")
    public List<Product> getProducts(@RequestParam(defaultValue = "-1",required = false) Long productsId){
        List<Product> products=new ArrayList<>();
        if(productsId==-1)
            products= productRepository.findAll();
        else
            products.add(productRepository.getOne(productsId));
        return  products;
    }
    @PostMapping("products")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @PutMapping("products")
    public Product updateProduct(Product product){
        long rid=product.getReleaseNotesId();
        Product rn=(Product)productRepository.getOne(rid);

        return productRepository.save(product);
    }
    @DeleteMapping("products")
    public Product deleteProduct(Long productId){
        Product rn=productRepository.getOne(productId);

         productRepository.delete(rn);
         return  rn;
    }

}
