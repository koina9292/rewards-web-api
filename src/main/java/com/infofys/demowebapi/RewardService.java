package com.infofys.demowebapi;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Applies the following conditions to calculate reward points associated to each transaction
 * A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
 * dollar spent between $50 and $100 in each transaction.
 */
@Component
public class RewardService {

    public Map<String, Map<String, Integer>> calculateRewards(List<Transaction> transactions) {
        Map<String, Map<String, Integer>> rewards = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            double amount = transaction.getAmount();
            String month = transaction.getDate();

            int points = calculatePoints(amount);

            rewards.putIfAbsent(customerId, new HashMap<>());
            rewards.get(customerId).put(month, rewards.get(customerId).getOrDefault(month, 0) + points);
        }

        return rewards;
    }

    private int calculatePoints(double amount) {
        if (amount <= 50) {
            return 0;
        } else if (amount <= 100) {
            return (int) (amount - 50);
        } else {
            return (int) (2 * (amount - 100) + 50);
        }
    }
}
