package com.dxp.springbootnetty.netty.handler;

import com.dxp.springbootnetty.netty.ChannelRepository;
import com.dxp.springbootnetty.service.StudentService;
import com.dxp.springbootnetty.service.vo.StudentInfo;
import com.google.gson.Gson;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author carzy
 * @date 2018/08/28
 */
@Component
@ChannelHandler.Sharable
public class StringHandler extends SimpleChannelInboundHandler<String> {

    private final ChannelRepository channelRepository;
    private final Gson gson;
    private final StudentService studentService;

    @Autowired
    public StringHandler(ChannelRepository channelRepository,
                         Gson gson,
                         StudentService studentService) {
        this.channelRepository = channelRepository;
        this.gson = gson;
        this.studentService = studentService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        StudentInfo studentInfo = this.gson.fromJson(msg, StudentInfo.class);

        /*
         *  调用异步方法 studentService.add()
         */
        this.studentService.add(studentInfo);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelRepository.put(channel.id().asLongText(), channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        channelRepository.remove(channel.id().asLongText());
        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelRepository.remove(channel.id().asLongText());
    }
}
