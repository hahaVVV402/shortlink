package org.nageoffer.shortlink.project.mq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nageoffer.shortlink.project.common.convention.exception.ServiceException;
import org.nageoffer.shortlink.project.dto.biz.ShortLinkStatsRecordDTO;
import org.nageoffer.shortlink.project.mq.idempotent.MessageQueueIdempotentHandler;
import org.nageoffer.shortlink.project.service.ShortLinkService;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

import static org.nageoffer.shortlink.project.common.constant.RedisKeyConstant.DELAY_QUEUE_STATS_KEY;
@Slf4j
@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsConsumer implements InitializingBean {

    private final RedissonClient redissonClient;
    private final ShortLinkService shortLinkService;
    private final MessageQueueIdempotentHandler messageQueueIdempotentHandler;

    public void onMessage() {
        Executors.newSingleThreadExecutor(
                        runnable -> {
                            Thread thread = new Thread(runnable);
                            thread.setName("delay_short-link_stats_consumer");
                            thread.setDaemon(Boolean.TRUE);
                            return thread;
                        })
                .execute(() -> {
                    RBlockingDeque<ShortLinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
                    RDelayedQueue<ShortLinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
                    for (; ; ) {
                        try {
                            ShortLinkStatsRecordDTO statsRecord = delayedQueue.poll();
                            if (statsRecord != null) {
                                if (messageQueueIdempotentHandler.isMessageProcessed(statsRecord.getKeys())) {
                                    // 判断当前的这个消息是否执行完成
                                    if (messageQueueIdempotentHandler.isMessageAccomplish(statsRecord.getKeys())){
                                        return;
                                    }
                                    throw new ServiceException("消息未完成流程，需要消息队列重试");
                                }
                                try {
                                    shortLinkService.shortLinkStats(null, null, statsRecord);
                                } catch (Throwable ex) {
                                    messageQueueIdempotentHandler.delMessageProcessed(statsRecord.getKeys());
                                    log.error("延迟记录短链接监控消费异常",ex);
                                }
                                messageQueueIdempotentHandler.setMessageAccomplish(statsRecord.getKeys());
                                continue;
                            }
                            LockSupport.parkUntil(500);
                        } catch (Throwable ignored) {
                        }
                    }
                });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        onMessage();
    }
}
