package cn.jvtd.netty.demo.controller;

import cn.jvtd.netty.demo.service.ServerHanlder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

/**
 * @author Aaronglyang
 */
public class Server {

    private int port;
    private ServerSocketChannel serverSocketChannel;

    /**
     * 构造方法保证调用启动服务器端
     */
    public Server(int port){
        this.port = port;
        bind();
    }

    private void bind(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //服务端要建立两个group，一个负责接收客户端的连接，一个负责处理数据传输
                //连接Group
                EventLoopGroup boss = new NioEventLoopGroup();
                //处理Group
                EventLoopGroup worker = new NioEventLoopGroup();

                //启动服务器端
                ServerBootstrap serverBootstrap = new ServerBootstrap();

                serverBootstrap.group(boss,worker)
                        .channel(NioServerSocketChannel.class)
                        //保持连接数
                        .option(ChannelOption.SO_BACKLOG,300)
                        //有数据立即发送
                        .option(ChannelOption.TCP_NODELAY,true)
                        //保持连接
                        .childOption(ChannelOption.SO_KEEPALIVE,true)
                        //处理新连接
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel sc) throws Exception{
                                //增加任务处理
                                ChannelPipeline p = sc.pipeline();
                                p.addLast(
                                        new StringDecoder(),
                                        new StringEncoder(),
                                        new ServerHanlder());
                            }
                        });
                //绑定端口，同步等待成功
                ChannelFuture future;
                try{
                    future = serverBootstrap.bind(port).sync();
                    if(future.isSuccess()){
                        serverSocketChannel = (ServerSocketChannel) future.channel();
                        System.out.println("服务器端口启动成功。。。。。。。");
                    }else {
                        System.out.println("服务器端口启动失败。。。。。。。");
                    }
                    future.channel().closeFuture().sync();

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    boss.shutdownGracefully();
                    worker.shutdownGracefully();
                }
            }
        });
        thread.start();
    }

    /**
     * 发送消息测试
     * @param msg
     */
    public void sendMessage(Object msg){
        if(serverSocketChannel!=null){
            serverSocketChannel.writeAndFlush(msg);
        }
    }

//    public static void main(String[] args){
//        Server server = new Server(8088);
//    }
}
