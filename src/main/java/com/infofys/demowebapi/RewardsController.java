package com.infofys.demowebapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Accepts a collection of transactions and returns each transaction with its associated reward points
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardService rewardsService;

    public RewardsController(RewardService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @PostMapping("/calculate")
    public Map<String, Map<String, Integer>> calculateRewards(@RequestBody List<Transaction> transactions) {
        return rewardsService.calculateRewards(transactions);
    }
}
