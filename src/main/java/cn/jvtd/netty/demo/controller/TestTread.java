package cn.jvtd.netty.demo.controller;

import cn.jvtd.netty.demo.thread.MyThread;
import cn.jvtd.netty.demo.thread.SyncTwoThread;
import cn.jvtd.netty.demo.thread.TwoThread;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TestTread {

    @PostConstruct
    public void test() throws InterruptedException {
        String str = LocalDateTime.now().toString();


        System.out.println(str);

        //验证一下Optional
        List<String> list = new ArrayList<>();
        list.add("guoliang");
        list.add(null);
        list.add(null);
        String str2 = Optional.ofNullable(list.get(1)).orElse("aa");


        System.out.println("str2:"+str2);

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("线程结束！！");

        for(Integer i = 0; i<10; i++){
            int time = (int)(Math.random()*1000);
            Thread.sleep(time);
            System.out.println("main="+Thread.currentThread().getName());

        }

        TwoThread a = new TwoThread("a");
        TwoThread b = new TwoThread("b");
        TwoThread c = new TwoThread("c");

        a.start();
        b.start();
        c.start();

        SyncTwoThread aa = new SyncTwoThread("A");
        SyncTwoThread bb = new SyncTwoThread("B");
        SyncTwoThread cc = new SyncTwoThread("C");

        aa.start();
        bb.start();
        cc.start();
    }
}
