package com.example.product.controller;

import com.example.product.Services.OrderService;
import com.example.product.dto.OrderDto;
import com.example.product.dto.ProductResponseDto;
<<<<<<< HEAD
=======
import com.example.product.dto.UserResponseDto;
>>>>>>> 1b7073e (Order Services)
import com.example.product.table.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 1b7073e (Order Services)

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
<<<<<<< HEAD
    public  List<ProductResponseDto>  getProducts()
    {
        return orderService.getProducts();
    }

    @GetMapping("/user")
    public List<Object> getUsers()
    {
        return orderService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderEntity>> getUserOrderById(@PathVariable Long userId) {
        List<OrderEntity> userOrders = orderService.getUserOrderById(userId);
        if (userOrders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userOrders);
=======
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

//    @GetMapping("/product/{id}")
//    public ProductResponseDto getProductsById(@PathVariable Long id) {
//        return orderService.getProductsById(id);
//    }

//    @GetMapping("/user")
//    public List<UserResponseDto> getUsers() {
//        return orderService.getUsers();
//    }

//    @GetMapping("/id/{id}")
//    public UserResponseDto getUsersById(@PathVariable Long id) {
//        return orderService.getUserById(id);
//    }

    @GetMapping("/user/{userId}")
    public List<OrderEntity> getUserOrderById(@PathVariable Long userId) {
        return orderService.getUserOrderById(userId);
>>>>>>> 1b7073e (Order Services)
    }

    @PostMapping("/place-order")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderRequest) {
        OrderEntity createdOrder = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(createdOrder);
    }
<<<<<<< HEAD
=======

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderEntity> updateOrder(
            @PathVariable Long orderId,
            @RequestBody OrderDto orderRequest) {
        OrderEntity updatedOrder = orderService.updateOrder(orderId, orderRequest);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order with ID " + orderId + " has been deleted successfully.");
    }
>>>>>>> 1b7073e (Order Services)
}
