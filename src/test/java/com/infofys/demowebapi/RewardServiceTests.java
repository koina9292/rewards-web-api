package com.infofys.demowebapi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardServiceTests {

    private final RewardService rewardService = new RewardService();

    @Test
    public void calculateRewardsReturnsExpectedPoints() {
        Transaction requestTransaction = new Transaction("testId", 120, "2024-09-18");
        Map<String, Map<String, Integer>> expected = Map.of("testId", Map.of("2024-09-18", 90));

        Map<String, Map<String, Integer>> result = rewardService.calculateRewards(List.of(requestTransaction));

        assertThat(result).containsAllEntriesOf(expected);
    }
}
