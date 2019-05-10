package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProducerConsumer_LockDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 20:11
 * @Version 1.0
 * 题目:多线程间按顺序调用，实现a->b->c三个线程的启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。
 * 来10轮
 **/
class ShareResource{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int number = 1;

    public void print5(){
        lock.lock();
        try {
            //判断
            while (number != 1){
                condition1.await();
            }
            //干活
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //唤醒
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print10(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                condition2.await();
            }
            //干活
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //唤醒
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print15(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                condition3.await();
            }
            //干活
            for (int i=0;i<15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //唤醒
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


public class ProducerConsumer_LockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                shareResource.print5();
            },"A").start();

            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                shareResource.print10();
            },"B").start();

            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                shareResource.print15();
            },"C").start();
        }
    }
}
