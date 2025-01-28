package com.example.product.Services;

import com.example.product.dto.OrderDto;
import com.example.product.dto.ProductResponseDto;
<<<<<<< HEAD
=======
import com.example.product.dto.UserResponseDto;
import com.example.product.email.EmailService;
import com.example.product.email.OrderEmailBuilder;
import com.example.product.exceptionhandler.customexceptions.ProductNotFoundException;
>>>>>>> 1b7073e (Order Services)
import com.example.product.feign.ProductClient;
import com.example.product.feign.UserClient;
import com.example.product.repo.OrderRepo;
import com.example.product.table.OrderEntity;
import com.example.product.table.OrderItem;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
=======
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> 1b7073e (Order Services)
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
=======
@Slf4j
>>>>>>> 1b7073e (Order Services)
public class OrderService {

    private final UserClient userClient;
    private final ProductClient productClient;
<<<<<<< HEAD
    private  final OrderRepo orderRepo;
    public  List<ProductResponseDto>  getProducts() {
     return productClient.getProducts();
    }
    public List<Object> getUsers() {
        return userClient.getUser();
    }


    public OrderEntity createOrder(OrderDto orderRequest) {
        // Fetch products from the product service
        List<ProductResponseDto> products = productClient.getProducts();

        // Map OrderItemsDto to OrderItemEntity
        List<OrderItem> orderItems = orderRequest.getOrderItems().stream()
                .map(item -> {
                    // Find the matching product
                    Optional<ProductResponseDto> productOpt = products.stream()
                            .filter(product -> product.getId() != null && product.getId().equals(item.getProductId()))
                            .findFirst();

                    if (productOpt.isEmpty()) {
                        throw new IllegalArgumentException("Product not found for ID: " + item.getProductId());
                    }

                    ProductResponseDto product = productOpt.get();

                    // Create OrderItemEntity
                    OrderItem orderItemEntity = new OrderItem();
                    orderItemEntity.setProductId(product.getId());
                    orderItemEntity.setProductName(product.getProduct());
                    orderItemEntity.setProductCompany(product.getCompany());
                    orderItemEntity.setProductPrice(product.getPrice());
                    orderItemEntity.setQuantity(item.getQuantity());
                    orderItemEntity.setTotalPrice(product.getPrice() * item.getQuantity());

                    return orderItemEntity;
                })
                .collect(Collectors.toList());

        // Calculate total price
=======
    private final OrderRepo orderRepo;
    private final EmailService emailService;
    private final OrderItemService orderItemService;
    private final OrderEmailBuilder orderEmailBuilder;

    public OrderEntity createOrder(OrderDto orderRequest) {

        UserResponseDto user = getUserById(orderRequest.getUserId());
        List<ProductResponseDto> products = productClient.getProducts();

        List<OrderItem> orderItems = orderItemService.mapOrderItems(orderRequest.getOrderItems(), products);

>>>>>>> 1b7073e (Order Services)
        Long totalPrice = orderItems.stream()
                .mapToLong(OrderItem::getTotalPrice)
                .sum();

<<<<<<< HEAD
        // Create OrderEntity
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setUserId(orderRequest.getUserId());
        orderEntity.setOrderItems(orderItems);
        orderEntity.setTotalPrice(totalPrice);

        // Save the order
        return orderRepo.save(orderEntity);
    }

    public List<OrderEntity> getUserOrderById(Long userId) {
        return orderRepo.findByUserId(userId);
=======
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(orderRequest.getUserId());
        orderEntity.setOrderItems(orderItems);
        orderEntity.setTotalPrice(totalPrice);
        OrderEntity savedOrder = orderRepo.save(orderEntity);

        UserResponseDto userResponseDto = userClient.getUserById(orderEntity.getUserId());
        String emailContent = orderEmailBuilder.buildOrderDetails(savedOrder, "Order Confirmation");
        emailService.sendOrderConfirmationEmail(userResponseDto.getEmail(), emailContent);

        return savedOrder;
    }


    public OrderEntity updateOrder(Long orderId, OrderDto orderRequest) {
        OrderEntity existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " not found"));

        List<ProductResponseDto> products = productClient.getProducts();
        if (products.isEmpty()) {
            throw new IllegalArgumentException("No products available for updating the order.");
        }

        List<OrderItem> updatedOrderItems = orderItemService.mapOrderItems(orderRequest.getOrderItems(), products);
        existingOrder.setUserId(orderRequest.getUserId());
        existingOrder.setOrderItems(updatedOrderItems);
        existingOrder.setTotalPrice(updatedOrderItems.stream().mapToLong(OrderItem::getTotalPrice).sum());

        return orderRepo.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        OrderEntity existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " not found"));

        orderRepo.delete(existingOrder);
    }

    public List<OrderDto> getOrders() {
        List<OrderEntity> orders = orderRepo.findAll();
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("No orders found.");
        }
        return orders.stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            orderDto.setUserId(order.getUserId());
            orderDto.setOrderItems(order.getOrderItems());
            return orderDto;
        }).collect(Collectors.toList());
    }

    public List<OrderEntity> getUserOrderById(Long userId) {
        List<OrderEntity> orders = orderRepo.findByUserId(userId);
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("No orders found for user ID " + userId);
        }
        return orders;
    }

    public ProductResponseDto getProductsById(Long productId) {
        List<ProductResponseDto> products = productClient.getProducts();
        return products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found."));
    }

    public UserResponseDto getUserById(Long id) {
        List<UserResponseDto> products = userClient.getUser();
        return products.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("User with ID " + id + " not found."));
>>>>>>> 1b7073e (Order Services)
    }

}

