package cn.jvtd.netty.demo.controller;

/**
 * @author guoliang
 */
public class TicketWindow extends Thread {

    private final String name;

    private static final int MAX = 50;

    private static int index = 1;

    @Override
    public void run(){
        while (index <= MAX){
            System.out.println("guitai "+name + "haoma:"+ (index++));
        }

    }

    public TicketWindow(String name ){
        this.name = name;
    }

}
