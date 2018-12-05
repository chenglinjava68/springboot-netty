package com.dxp.springbootnetty;

import com.dxp.springbootnetty.config.NettyProperties;
import com.dxp.springbootnetty.netty.ChannelRepository;
import com.dxp.springbootnetty.netty.handler.SocketChannelInitializer;
import com.dxp.springbootnetty.netty.handler.StringHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * @author carzy.
 * @date 14:51 2018/12/4
 * <p>
 * netty 配置
 */
@Configuration
public class NettyConfiguration {

    @Bean
    public ServerBootstrap serverBootstrap(
            @Qualifier("bossGroup") NioEventLoopGroup bossGroup,
            @Qualifier("workerGroup") NioEventLoopGroup workerGroup,
            SocketChannelInitializer socketChannelInitializer) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(socketChannelInitializer);
        return serverBootstrap;
    }

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup(NettyProperties nettyProperties) {
        return new NioEventLoopGroup(nettyProperties.getBossCount());
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup(NettyProperties nettyProperties) {
        return new NioEventLoopGroup(nettyProperties.getWorkerCount());
    }

    @Bean
    public InetSocketAddress socketAddress(NettyProperties nettyProperties) {
        return new InetSocketAddress(nettyProperties.getPort());
    }

}
