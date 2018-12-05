package com.dxp.springbootnetty.test;

import com.dxp.springbootnetty.service.vo.StudentInfo;
import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author carzy
 * @date 2018/12/04
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {

    private Gson gson = new Gson();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接成功");
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(gson.toJson(new StudentInfo("username" + i, "pwd" + i, "remark" + i)));
        }
    }
}
