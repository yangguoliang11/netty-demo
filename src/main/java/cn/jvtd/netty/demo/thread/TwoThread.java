package cn.jvtd.netty.demo.thread;

public class TwoThread extends Thread{
    private  int count = 5;
    public TwoThread(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run(){
        super.run();
        while(count>0){
            count--;
            System.out.println("由"+ currentThread().getName()+"计算 count="+count);
        }
    }
}
