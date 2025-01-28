package com.example.product.dto;

<<<<<<< HEAD
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponseDto {

    @JsonProperty("userId")
    private Long id;
    @JsonProperty("username")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
>>>>>>> 1b7073e (Order Services)
    private String address;
}
