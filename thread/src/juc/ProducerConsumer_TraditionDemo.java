package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProducerConsumer_TraditionDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 19:30
 * @Version 1.0
 * 题目：一个初始值为0的变量，两个线程对其操作，一个加1，一个减1，来5次
 * 1. 线程              操作                   资源类
 * 2. 判断              干活                   通知
 * 3. 防止虚假唤醒
 **/
class ShareData{ //资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (0 != number){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (0 == number){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


public class ProducerConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i=0;i<5;i++){
                shareData.increment();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i=0;i<5;i++){
                shareData.decrement();
            }
        },"BBB").start();

    }

}
