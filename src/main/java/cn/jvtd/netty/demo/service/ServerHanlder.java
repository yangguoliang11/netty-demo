package cn.jvtd.netty.demo.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * @author Aaronglyang
 */
public class ServerHanlder extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务器端连接开始....");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务器端连接关闭...");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收到了信息："+msg);

        //字节码
        //ByteBuf byteBuf = (ByteBuf)msg;
        //byte[] req = new byte[byteBuf.readableBytes()];
        //byteBuf.readBytes(req);

        //String body = new String(req,StandardCharsets.UTF_8);
        System.out.println("接受到客户端数据:"+msg);

        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(Unpooled.copiedBuffer("收到 Nett Rock!!",StandardCharsets.UTF_8));
        ctx.writeAndFlush(pingMessage);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        System.out.println("信息接收完毕...");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
