package com.example.product.table;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


=======
import jakarta.persistence.*;
import lombok.Data;

>>>>>>> 1b7073e (Order Services)
import java.util.List;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long orderId; // Order reference
    private Long userId;  // User placing the order
    private Long totalPrice;

=======
    private Long orderId;
    private Long userId;
    private Long totalPrice;
>>>>>>> 1b7073e (Order Services)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private List<OrderItem> orderItems;
}
