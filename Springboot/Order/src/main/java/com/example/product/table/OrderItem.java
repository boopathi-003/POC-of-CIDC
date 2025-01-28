package com.example.product.table;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
>>>>>>> 1b7073e (Order Services)
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.math.BigDecimal;

=======
>>>>>>> 1b7073e (Order Services)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String productName;
    private String productCompany;
    private Long productPrice;
    private Long quantity;
<<<<<<< HEAD
    private Long totalPrice; // Calculated as price * quantity
=======
    private Long totalPrice;
>>>>>>> 1b7073e (Order Services)
}




