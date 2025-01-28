package com.example.product.Services;


import com.example.product.dto.ProductResponseDto;
import com.example.product.table.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    public List<OrderItem> mapOrderItems(List<OrderItem> orderItemDto, List<ProductResponseDto> products) {
        return orderItemDto.stream()
                .map(itemDto -> {
                    Optional<ProductResponseDto> productOpt = products.stream()
                            .filter(product -> product.getId() != null && product.getId().equals(itemDto.getProductId()))
                            .findFirst();

                    if (productOpt.isEmpty()) {
                        throw new IllegalArgumentException("Product not found for ID: " + itemDto.getProductId());
                    }

                    ProductResponseDto product = productOpt.get();
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(product.getId());
                    orderItem.setProductName(product.getProduct());
                    orderItem.setProductCompany(product.getCompany());
                    orderItem.setProductPrice(product.getPrice());
                    orderItem.setQuantity(itemDto.getQuantity());
                    orderItem.setTotalPrice(product.getPrice() * itemDto.getQuantity());

                    return orderItem;
                })
                .collect(Collectors.toList());
    }
}

