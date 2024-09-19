package com.infofys.demowebapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardsControllerTests {

    @MockBean
    private RewardService service = Mockito.mock(RewardService.class);
    private final RewardsController controller = new RewardsController(service);

    @Test
    public void calculateRewardsReturnsCalculatedRewards() {

        Transaction requestTransaction = new Transaction("testId", 120, "2024-09-18");
        Map<String, Map<String, Integer>> serviceResponse = Map.of("testId", Map.of("", 90));
        Mockito.when(service.calculateRewards(List.of(requestTransaction))).thenReturn(serviceResponse);

        Map<String, Map<String, Integer>> response = controller.calculateRewards(List.of(requestTransaction));

        assertThat(response).isNotNull();
        assertThat(response).isNotEmpty();
        assertThat(response).containsAllEntriesOf(serviceResponse);
    }
}
