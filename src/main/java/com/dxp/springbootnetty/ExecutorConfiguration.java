package com.dxp.springbootnetty;

import com.dxp.springbootnetty.config.ThreadPoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author carzy.
 * @date 15:54 2018/12/4
 * <p>
 * 线程池配置
 */
@Configuration
public class ExecutorConfiguration {

    @Primary
    @Bean
    public AsyncTaskExecutor asyncExecutor(ThreadPoolProperties threadPoolProperties) {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(threadPoolProperties.getCoreSize());
        threadPool.setMaxPoolSize(threadPoolProperties.getMaxSize());
        threadPool.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        threadPool.setThreadNamePrefix("dxp-");
        threadPool.setKeepAliveSeconds(threadPoolProperties.getAliveTime());
        return threadPool;
    }

}
