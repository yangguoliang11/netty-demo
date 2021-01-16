package cn.jvtd.netty.demo.controller;

import javax.annotation.Resource;

/**
 * @author guoliang
 */
public class ThreadSynchronized extends Thread {
    private int i = 1;
    private String name;

    private Plusplus plusplus;



    @Override
    public void run(){
        sync(name);
    }

    private synchronized void sync(String name){
        plusplus.sync(name);
    }

    public ThreadSynchronized(String name,Plusplus plusplus){
        this.name = name;
        this.plusplus = plusplus;
    }


}
