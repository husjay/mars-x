package com.mars.x.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author: sj.hu
 * @date: 2020/3/26 18:10
 **/
@Service
public class SpringRetry {

    @Retryable(value = RuntimeException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 5000L, multiplier = 2))
    public void call() {
        System.out.println("Call something...");
        throw new RuntimeException("RPC调用异常");
    }

    /**
     * recover 机制
     * @param e 异常
     */
    @Recover
    public void recover(RuntimeException e) {
        System.out.println("Start do recover things....");
        System.out.println("We meet ex: ");
    }
}
