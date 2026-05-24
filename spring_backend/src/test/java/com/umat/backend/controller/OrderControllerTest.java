package com.umat.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.umat.backend.security.JwtFilter;
import com.umat.backend.security.JwtUtil;
import com.umat.backend.repository.CartItemRepository;
import com.umat.backend.repository.OrderRepository;
import com.umat.backend.repository.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
@TestPropertySource(properties = {"app.jwt.secret=01234567890123456789012345678901", "app.jwt.expirationMs=3600000"})
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private CartItemRepository cartItemRepository;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getOrder_unauthenticated_returns401() throws Exception {
        mvc.perform(get("/api/orders/1")).andExpect(status().isUnauthorized());
    }
}
