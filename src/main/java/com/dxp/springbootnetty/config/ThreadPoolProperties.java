package com.dxp.springbootnetty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author carzy.
 * @date 16:10 2018/12/4
 */
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {

    private int coreSize;

    private int maxSize;

    private int aliveTime;

    private int queueCapacity;

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getAliveTime() {
        return aliveTime;
    }

    public void setAliveTime(int aliveTime) {
        this.aliveTime = aliveTime;
    }
}
