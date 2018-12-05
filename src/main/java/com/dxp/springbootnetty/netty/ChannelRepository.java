package com.dxp.springbootnetty.netty;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author carzy.
 * @date 11:54 2018/12/4
 */
public class ChannelRepository {

    private ConcurrentMap<String, Channel> channelCache = new ConcurrentHashMap<String, Channel>();

    /**
     * 记录channel
     *
     * @param key   客户端唯一标识符,最好是有含义的，例如userId 等（禁止使用  channelID）
     * @param value {@link Channel}
     */
    public void put(String key, Channel value) {
        channelCache.put(key, value);
    }

    /**
     * 通过关键标识符获取对应的Channel
     *
     * @param key 客户端唯一标识符
     * @return {@link Channel}
     */
    public Channel get(String key) {
        return channelCache.get(key);
    }

    /**
     * 移除当前Channel
     *
     * @param key 客户端唯一标识符
     */
    public void remove(String key) {
        this.channelCache.remove(key);
    }

    /**
     * 获取当前客户端连接数
     *
     * @return 连接数
     */
    public int size() {
        return this.channelCache.size();
    }

    /**
     * 清除所有的Channel
     */
    public void cleanAll() {
        this.channelCache.clear();
    }

}
