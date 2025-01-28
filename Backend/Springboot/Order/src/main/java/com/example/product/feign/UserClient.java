package com.example.product.feign;

import com.example.product.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

import java.util.List;

@FeignClient(name = "user-service",url = "${external.api.user-url}")
public interface UserClient {
    @GetMapping("/user")
    List<Object> getUser();
=======
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service",configuration = FeignConfig.class,url = "${external.api.user-url}")
public interface UserClient {
    @GetMapping("/user")
    List<UserResponseDto> getUser();

    @GetMapping("/user/{id}")
    UserResponseDto getUserById(@PathVariable Long id);
>>>>>>> 1b7073e (Order Services)
}
