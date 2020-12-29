package cn.jvtd.netty.demo.controller;


import cn.jvtd.netty.demo.service.ClientHanlder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Aaronglyang
 */
public class Client {

    private int port;

    public Client(int port){
        this.port = port;
        bind();
    }

    private void bind(){
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress("localhost",this.port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ClientHanlder());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e){
            e.printStackTrace();
        }


    }

//    public static void main(String[] args){
//        Client client = new Client(8088);
//    }
}
