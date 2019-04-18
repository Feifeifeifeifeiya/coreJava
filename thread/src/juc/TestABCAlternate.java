package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*编写一个程序，开启3个线程，这3个线程的ID分别为A，B，C，每个线程将自己的ID在屏幕上打印10遍，要求输出的结果必须按顺序显示
* */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlertDemo alertDemo = new AlertDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    alertDemo.LoopA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    alertDemo.LoopB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    alertDemo.LoopC(i);
                    System.out.println("-------------------------");
                }
            }
        },"C").start();

    }
}

class AlertDemo{
    private int number=1;//当前正在执行的线程维护的变量
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void LoopA(int totalLoop ){  //totalLoop表示轮数
        lock.lock();
        try {
            //判断
            if(number !=1){
                condition1.await();
            }
            //打印

            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }
            //唤醒
            number=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void LoopB(int totalLoop){
        lock.lock();
        try{
            //判断
            if(number!=2){
                condition2.await();
            }
            //打印
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }
            //唤醒
            number=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void LoopC(int totalLoop){
        lock.lock();
        try{
            //判断
            if(number!=3){
                condition3.await();
            }
            //打印
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }
            //唤醒
            number=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}