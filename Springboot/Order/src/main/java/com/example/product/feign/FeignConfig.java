package com.example.product.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig implements RequestInterceptor {

    @Value("${jwt.token}")
    private  String API_TOKEN;  // Replace with your token
    @Value("${jwt.secret}")
    private  String SECRET_KEY ; // Replace with your secret key

    @Override
    public void apply(RequestTemplate template) {
        // Add the Authorization header with the Bearer token
        template.header("Authorization", "Bearer " + API_TOKEN);

        // Add the secret key to the header (if required)
        template.header("x-secret-key", SECRET_KEY);
    }
}

