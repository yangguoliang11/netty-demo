package cn.jvtd.netty.demo;

import cn.jvtd.netty.demo.controller.Plusplus;
import cn.jvtd.netty.demo.controller.ThreadSynchronized;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

/**
 * @author Aaronglyang
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
//        TicketWindow ticketWindow1 = new TicketWindow("1hao");
//        ticketWindow1.start();
//        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
//        System.out.println("threadGroup :"+threadGroup.getName());
//
//        TicketWindow ticketWindow2 = new TicketWindow("2hao");
//        ticketWindow2.start();
//
//        TicketWindow ticketWindow3 = new TicketWindow("3hao");
//        ticketWindow3.start();

//        Plusplus plusplus = new Plusplus();
//        ThreadSynchronized ts1 = new ThreadSynchronized("一号窗口",plusplus);
//        ts1.start();
//        ThreadSynchronized ts2 = new ThreadSynchronized("二号窗口",plusplus);
//        ts2.start();
//        ThreadSynchronized ts3 = new ThreadSynchronized("三号窗口",plusplus);
//        ts3.start();
//        ThreadSynchronized ts4 = new ThreadSynchronized("四号窗口",plusplus);
//        ts4.start();
//        ThreadSynchronized ts5 = new ThreadSynchronized("五号窗口",plusplus);
//        ts5.start();
    //线程池开启
        long startTime = System.currentTimeMillis();
        //获取开始时间
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("gateway-dispatcher-%d").build();

        ExecutorService esPool =new ThreadPoolExecutor(5,6,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(6),threadFactory,new ThreadPoolExecutor.AbortPolicy());
        Plusplus plusplus = new Plusplus();
        ThreadSynchronized ts1 = new ThreadSynchronized("测试1",plusplus);
        esPool.execute(ts1);
        ThreadSynchronized ts2 = new ThreadSynchronized("测试2",plusplus);
        esPool.execute(ts2);
        ThreadSynchronized ts3 = new ThreadSynchronized("测试3",plusplus);
        esPool.execute(ts3);
        ThreadSynchronized ts4 = new ThreadSynchronized("测试4",plusplus);
        esPool.execute(ts4);
        ThreadSynchronized ts5 = new ThreadSynchronized("测试5",plusplus);
        esPool.execute(ts5);
        ThreadSynchronized ts6 = new ThreadSynchronized("测试6",plusplus);
        esPool.execute(ts6);
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        //输出程序运行时间
        esPool.shutdown();
    }

}
