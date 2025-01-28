package com.example.product.config;



import com.example.product.externalapi.ExternalApiService;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductClientConfig {

    private final ExternalApiService externalApiService;

    public ProductClientConfig(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Get the token dynamically (username and password should be passed as needed)
            String token = externalApiService.getToken("test@gmail.com", "1234");
            // Add the token to the Authorization header for every request
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}

