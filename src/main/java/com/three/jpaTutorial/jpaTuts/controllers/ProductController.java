package com.three.jpaTutorial.jpaTuts.controllers;

import com.three.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.three.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue ="id") String sortBy){
        //return productRepository.findBy(Sort.by(sortBy));
        //return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price","quantity"));
        //say we sort by title if title is same,then it will take price,if price is also same, it will take quantity

        return productRepository.findBy(Sort.by(
                Sort.Order.desc(sortBy),
                Sort.Order.asc("title")//if any tie is there it will sort by title in asc order
        ));
    }
}
