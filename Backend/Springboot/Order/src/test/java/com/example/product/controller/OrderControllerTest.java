package com.example.product.controller;

import com.example.product.Services.OrderService;
import com.example.product.dto.OrderDto;
import com.example.product.table.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private OrderDto orderDto;
    private OrderEntity orderEntity;

    @BeforeEach
    void setUp() {
        // Setup test data
        orderDto = new OrderDto();
        orderDto.setUserId(1L);
        // Set other necessary fields on orderDto

        orderEntity = new OrderEntity();
        orderEntity.setUserId(1L);
        // Set other necessary fields on orderEntity
    }

    @Test
    void getOrders() {
        // Mock the service behavior
        List<OrderDto> orderList = Collections.singletonList(this.orderDto);
        when(orderService.getOrders()).thenReturn(orderList);

        // Call the controller method
        List<OrderDto> result = orderController.getOrders();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals(this.orderDto, result.get(0));
        verify(orderService, times(1)).getOrders();
    }

    @Test
    void getUserOrderById() {
        // Mock the service behavior
        List<OrderEntity> orderList = Collections.singletonList(this.orderEntity);
        when(orderService.getUserOrderById(1L)).thenReturn(orderList);

        // Call the controller method
        List<OrderEntity> result = orderController.getUserOrderById(1L);

        // Verify the result
        assertEquals(1, result.size());
        assertEquals(this.orderEntity, result.get(0));
        verify(orderService, times(1)).getUserOrderById(1L);
    }

    @Test
    void createOrder() {
        // Mock the service behavior
        when(orderService.createOrder(orderDto)).thenReturn(orderEntity);

        // Call the controller method
        ResponseEntity<OrderEntity> result = orderController.createOrder(orderDto);

        // Verify the result
        assertNotNull(result);
        assertEquals(this.orderEntity, result);
        verify(orderService, times(1)).createOrder(orderDto);
    }

    @Test
    void updateOrder() {
        // Mock the service behavior
        when(orderService.updateOrder(1L, orderDto)).thenReturn(orderEntity);

        // Call the controller method
        ResponseEntity<OrderEntity> result = orderController.updateOrder(1L, orderDto);

        // Verify the result
        assertNotNull(result);
        assertEquals(this.orderEntity, result);
        verify(orderService, times(1)).updateOrder(1L, orderDto);
    }

    @Test
    void deleteOrder() {
        // Mock the service behavior
        doNothing().when(orderService).deleteOrder(1L);

        // Call the controller method
        String result = String.valueOf(orderController.deleteOrder(1L));

        // Verify the result
        assertEquals("Order with ID 1 has been deleted successfully.", result);
        verify(orderService, times(1)).deleteOrder(1L);
    }
}
