package cn.jvtd.netty.demo.controller;

/**
 * @author guoliang
 */
public class Plusplus {

    private int i = 1;

    private final int MAX = 500;

    public void sync(String name){
        while (i< MAX) {
            System.out.println("当前的线程[" + name + "]是跑到:" + (i++));
        }
    }

}
