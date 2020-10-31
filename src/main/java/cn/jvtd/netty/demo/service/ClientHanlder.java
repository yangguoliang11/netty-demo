package cn.jvtd.netty.demo.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Aaronglyang
 */
public class ClientHanlder extends SimpleChannelInboundHandler {
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext){
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("Nett Rock!!",StandardCharsets.UTF_8));
    }

    public void expectionCaught(ChannelHandlerContext channelHandlerContext,Throwable cause){
        cause.printStackTrace();
        channelHandlerContext.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("Netty Client received:"+o.toString());
        //字节码
        ByteBuf byteBuf = (ByteBuf)o;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);

        String body = new String(req,StandardCharsets.UTF_8);
        System.out.println("接受到客户端数据:"+body);
    }
}
