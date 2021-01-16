package cn.jvtd.netty.demo;

import cn.jvtd.netty.demo.controller.Plusplus;
import cn.jvtd.netty.demo.controller.ThreadSynchronized;
import cn.jvtd.netty.demo.controller.TicketWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        Plusplus plusplus = new Plusplus();
        ThreadSynchronized ts1 = new ThreadSynchronized("一号窗口",plusplus);
        ts1.start();
        ThreadSynchronized ts2 = new ThreadSynchronized("二号窗口",plusplus);
        ts2.start();
        ThreadSynchronized ts3 = new ThreadSynchronized("三号窗口",plusplus);
        ts3.start();
        ThreadSynchronized ts4 = new ThreadSynchronized("四号窗口",plusplus);
        ts4.start();
        ThreadSynchronized ts5 = new ThreadSynchronized("五号窗口",plusplus);
        ts5.start();

    }

}
