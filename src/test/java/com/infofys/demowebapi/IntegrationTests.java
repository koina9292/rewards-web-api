package com.infofys.demowebapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<Transaction> transactions;

    @BeforeEach
    public void setUp() {
        transactions = Arrays.asList(
                new Transaction("cust1", 120.0, "2024-06"),
                new Transaction("cust1", 80.0, "2024-06"),
                new Transaction("cust2", 200.0, "2024-06"),
                new Transaction("cust1", 150.0, "2024-07"),
                new Transaction("cust2", 30.0, "2024-07")
        );
    }

    @Test
    public void calculateRewardsReturnsSuccessfulResponse() throws Exception {
        mockMvc.perform(post("/api/rewards/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactions)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
