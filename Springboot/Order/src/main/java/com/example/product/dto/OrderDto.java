package com.example.product.dto;

import com.example.product.table.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 1b7073e (Order Services)
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long userId;
    private List<OrderItem> orderItems;
}
