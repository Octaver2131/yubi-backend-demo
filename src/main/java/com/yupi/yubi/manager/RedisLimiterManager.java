package com.yupi.yubi.manager;

import com.yupi.yubi.common.ErrorCode;
import com.yupi.yubi.exception.BusinessException;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 专门提供 RedisLimiter 的限流服务 (提供通用能力)
 */
@Service
public class RedisLimiterManager {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 限流操作
     * @param key 区分不同的限流器，比如不同的用户 id 应该分别统计
     */
    public void doRateLimit(String key) {
        // 创建一个名称为user_limiter的限流器，每秒最多访问 2 次
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        // 限流器的统计规则（每秒 2 个请求，连续的请求，最多只能有 1 个请求被允许通过）
        // RateType.OVERALL 表示速率限制作用于整个令牌桶，即限制所有的请求速率
        rateLimiter.trySetRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
        // 每当一个操作来后，请求一个令牌
        boolean canOp = rateLimiter.tryAcquire(1);
        // 如果没有令牌，还想操作，就抛出异常
        if (!canOp) {
            throw new BusinessException(ErrorCode.TOO_MANY_REQUEST);
        }
    }
}
