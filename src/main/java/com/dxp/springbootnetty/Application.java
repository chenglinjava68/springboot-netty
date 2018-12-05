package com.dxp.springbootnetty;

import com.dxp.springbootnetty.config.NettyProperties;
import com.dxp.springbootnetty.config.ThreadPoolProperties;
import com.dxp.springbootnetty.netty.ChannelRepository;
import com.dxp.springbootnetty.netty.NettyServer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author carzy
 */
@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(value = {NettyProperties.class, ThreadPoolProperties.class})
@MapperScan(basePackages = "com.dxp.springbootnetty.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "contextRefreshed")
    public ApplicationListener<ContextRefreshedEvent> applicationListener() {
        return event -> {
            NettyServer nettyServer = event.getApplicationContext().getBean(NettyServer.class);
            nettyServer.start();
        };
    }

    @Bean
    public ChannelRepository channelRepository() {
        return new ChannelRepository();
    }

    @Autowired
    public Gson gson() {
        return new Gson();
    }

}
