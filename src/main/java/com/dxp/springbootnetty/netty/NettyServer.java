package com.dxp.springbootnetty.netty;

import com.dxp.springbootnetty.config.NettyProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2018-11-26
 */
@Component
public class NettyServer {

    private final ServerBootstrap serverBootstrap;
    private final NettyProperties nettyProperties;
    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    @Autowired
    public NettyServer(ServerBootstrap serverBootstrap, NettyProperties nettyProperties) {
        this.serverBootstrap = serverBootstrap;
        this.nettyProperties = nettyProperties;
    }

    public void start() {
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(nettyProperties.getPort()).sync();
            logger.info("netty server is running, port: {}", nettyProperties.getPort());
            // 监听服务器关闭监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
