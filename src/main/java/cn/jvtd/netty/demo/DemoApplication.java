package cn.jvtd.netty.demo;

import cn.jvtd.netty.demo.thread.MyThread;
import cn.jvtd.netty.demo.thread.SyncTwoThread;
import cn.jvtd.netty.demo.thread.TwoThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Aaronglyang
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("222222");
    }

}
