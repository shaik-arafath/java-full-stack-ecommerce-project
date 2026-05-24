package com.umat.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(properties = {"razorpay.key=", "razorpay.secret="})
public class PaymentControllerTest {

    @Autowired
    private MockMvc mvc;

    // Security filters disabled for controller behavior tests

    @Test
    @WithMockUser
    public void createOrder_whenNotConfigured_returns503() throws Exception {
        mvc.perform(post("/api/payment/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\":100.0}"))
                .andExpect(status().isServiceUnavailable());
    }

    @Test
    @WithMockUser
    public void verifyPayment_missingFields_returns400() throws Exception {
        mvc.perform(post("/api/payment/verify")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    public void createLink_whenNotConfigured_returns503() throws Exception {
        mvc.perform(post("/api/payment/create-link")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\":50.0}"))
                .andExpect(status().isServiceUnavailable());
    }
}
