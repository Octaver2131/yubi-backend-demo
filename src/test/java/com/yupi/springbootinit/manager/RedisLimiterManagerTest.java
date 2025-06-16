package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisLimiterManagerTest {

    @Resource
    private RedisLimiterManager redisLimiterManager;

    @Test
    void doRateLimit() throws InterruptedException {
        String userId = "1";
        for (int i = 0; i < 5; i++) {
            try {
                redisLimiterManager.doRateLimit(userId);
                System.out.println("第 " + i + " 次请求通过");
            } catch (BusinessException e) {
                System.out.println("第 " + i + " 次请求被限流");
            }
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            try {
                redisLimiterManager.doRateLimit(userId);
                System.out.println("第 " + i + " 次请求通过");
            } catch (BusinessException e) {
                System.out.println("第 " + i + " 次请求被限流");
            }
        }
    }
}