package com.example.product.email;


import com.example.product.table.OrderEntity;
import com.example.product.table.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderEmailBuilder {

    public String buildOrderDetails(OrderEntity order, String title) {
        StringBuilder emailContent = new StringBuilder();
        emailContent.append(title).append("\n");
        emailContent.append("Order ID: ").append(order.getOrderId()).append("\n");
        emailContent.append("Total Price: ").append(order.getTotalPrice()).append("\n\n");
        emailContent.append("Order Items:\n");

        for (OrderItem item : order.getOrderItems()) {
            emailContent.append("- Product: ").append(item.getProductName())
                    .append(" (").append(item.getProductCompany()).append(")\n")
                    .append("  Quantity: ").append(item.getQuantity()).append("\n")
                    .append("  Price: ").append(item.getProductPrice()).append("\n\n");
        }

        return emailContent.toString();
    }
}

