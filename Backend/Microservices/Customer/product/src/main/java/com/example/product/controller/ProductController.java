package com.example.product.controller;

import com.example.product.Services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
        @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts()
    {
        return "ffghjfghj";
    }

}

