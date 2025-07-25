package org.nageoffer.shortlink.project.mq.idempotent;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 消息队列幂等处理器
 */
@Component
@RequiredArgsConstructor
public class MessageQueueIdempotentHandler {
    private final StringRedisTemplate stringRedisTemplate;
    private static final String IDEMPOTENT_KEY_PREFIX = "short-link:idempotent:";

    public boolean isMessageBeingProcessed(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        // 尝试设置 key,如果 key 不存在则设置成功
        // setIfAbsent 相当于 Redis 的 SETNX 命令
        // 设置值为"0",过期时间为 2 分钟
        return Boolean.FALSE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, "0", 2, TimeUnit.MINUTES));
    }

    /**
     * 判断消息是否已经处理完成
     * @param messageId
     * @return
     */
    public boolean isAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        return Objects.equals(stringRedisTemplate.opsForValue().get(key), "1");
    }

    /**
     * 设置消息处理完成的幂等标识
     * @param messageId
     */
    public void setAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.opsForValue().set(key, "1", 10, TimeUnit.MINUTES);
    }
    /**
     * 如果消息处理遇到异常情况，删除幂等标识
     */
    public void delMessageProcessed(String messageId){
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.delete(key);
    }
}
