package com.example.product.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Customer {

    private Long id;
    private String name;
    private String email;

}
