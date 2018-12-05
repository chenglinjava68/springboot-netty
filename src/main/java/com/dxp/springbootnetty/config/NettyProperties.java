package com.dxp.springbootnetty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author carzy.
 * @date 14:06 2018/12/4
 */
@ConfigurationProperties(prefix = "netty")
public class NettyProperties {

    private int port;

    private int bossCount;

    private int workerCount;

    private boolean keepAlive;

    private int backlog;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossCount() {
        return bossCount;
    }

    public void setBossCount(int bossCount) {
        this.bossCount = bossCount;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }
}
