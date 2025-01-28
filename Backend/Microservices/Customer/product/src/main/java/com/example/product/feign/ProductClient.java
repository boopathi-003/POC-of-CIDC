package com.example.product.feign;

import com.example.product.config.ProductClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "product-service",url = "${external.api.product-url}",configuration = ProductClientConfig.class)
public interface ProductClient {
    @PostMapping("/product")
    List<Object> getProducts();
}

