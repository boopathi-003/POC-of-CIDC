package com.example.product.Services;

//import com.example.product.feign.CustomerClient;
import com.example.product.feign.ProductClient;
import com.example.product.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService  {

    private final ProductRepo productRepo;
    @Autowired
    private ProductClient productClient;


    public List<Object> getProduct() {
        return productClient.getProducts();
    }
    }


//    private final RestTemplate restTemplate;
//    public ProductService() {
//        this.restTemplate = new RestTemplate();
//    }
//    @Value("${external.api.product-url}")
//    String apiUrl;
//
//    public List<Object> getProducts() {
//
//        Object[] productArray = restTemplate.getForObject(apiUrl, Object[].class);
//
//        if (productArray != null) {
//            return Arrays.asList(productArray);
//        } else {
//            throw new RuntimeException("Failed to fetch product data");
//        }
//    }


