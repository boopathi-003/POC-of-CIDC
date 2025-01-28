package com.example.product.feign;

import com.example.product.dto.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-service", url = "${external.api.login-url}")
public interface login {
    @PostMapping("/login")
    String getToken(@RequestBody LoginResponse lo);
}
