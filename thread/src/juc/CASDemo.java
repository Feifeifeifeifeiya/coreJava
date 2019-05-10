package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 2:30
 * @Version 1.0
 **/
public class CASDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\tcome in");
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    public  void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"\tgo out");
    }

    public static void main(String[] args) {
        CASDemo casDemo = new CASDemo();
        new Thread(()->{
            casDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
            casDemo.myUnLock();
        },"t1").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }


        new Thread(()->{
            casDemo.myLock();
            casDemo.myUnLock();
        },"t2").start();
    }
}
