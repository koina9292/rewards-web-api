package com.infofys.demowebapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DemoWebApiApplicationTests {

    private final RewardsController controller;
    private final RewardService service;

    @Autowired
    public DemoWebApiApplicationTests(RewardsController controller, RewardService service) {
        this.controller = controller;
        this.service = service;

    }

    @Test
    void contextLoads() {
        assertThat(this.controller).isNotNull();
        assertThat(this.service).isNotNull();
    }

}
