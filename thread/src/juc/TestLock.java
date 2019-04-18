package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"1号").start();
        new Thread(ticket,"2号").start();
        new Thread(ticket,"3号").start();
    }
}


class Ticket implements Runnable{
    private int tick=100;

    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            if(tick>0){
                try {
                    Thread.sleep(200);
                    tick--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName()+"完成售票-------------"+tick);
            }
        }
    }
}