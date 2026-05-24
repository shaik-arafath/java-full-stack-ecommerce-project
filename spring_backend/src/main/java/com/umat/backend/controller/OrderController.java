package com.umat.backend.controller;

import com.umat.backend.model.*;
import com.umat.backend.repository.CartItemRepository;
import com.umat.backend.repository.OrderRepository;
import com.umat.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final CartItemRepository cartRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;
    
    public OrderController(CartItemRepository cartRepo, OrderRepository orderRepo, UserRepository userRepo) {
        this.cartRepo = cartRepo; this.orderRepo = orderRepo; this.userRepo = userRepo;
    }

    private Optional<User> getUser(HttpServletRequest req) {
        String email = (String) req.getAttribute("userEmail");
        if (email == null) return Optional.empty();
        return userRepo.findByEmail(email);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderEntity order, HttpServletRequest req) {
        Optional<User> uo = getUser(req);
        if (uo.isEmpty()) return ResponseEntity.status(401).body("Unauthorized");
        if (order == null || order.getItems() == null || order.getItems().isEmpty()) {
            return ResponseEntity.badRequest().body("Order must contain at least one item");
        }
        User user = uo.get();
        // calculate total from items
        double total = 0.0;
        for (OrderItem it : order.getItems()) {
            if (it == null || it.getPrice() == null || it.getQuantity() == null) {
                return ResponseEntity.badRequest().body("Order items must include price and quantity");
            }
            total += it.getPrice() * it.getQuantity();
        }
        order.setTotalAmount(total);
        order.setUser(user);
        order.setStatus("CREATED");
        OrderEntity saved = orderRepo.save(order);
        // clear cart after creating order
        cartRepo.deleteByUser(user);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id, HttpServletRequest req) {
        Optional<User> uo = getUser(req);
        if (uo.isEmpty()) return ResponseEntity.status(401).body("Unauthorized");
        Optional<OrderEntity> maybeOrder = orderRepo.findById(id);
        if (maybeOrder.isEmpty()) {
            return ResponseEntity.status(404).body("Order not found or unauthorized");
        }
        OrderEntity order = maybeOrder.get();
        if (order.getUser() == null || !order.getUser().getId().equals(uo.get().getId())) {
            return ResponseEntity.status(404).body("Order not found or unauthorized");
        }
        return ResponseEntity.ok(order);
    }
}
