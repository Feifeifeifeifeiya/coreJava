package juc;

import com.sun.scenario.animation.shared.TimerReceiver;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 18:05
 * @Version 1.0
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 信号量主要用于两个目的，一个用于多个共享资源的互斥使用，一个用于并发线程数量的控制
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t驶进车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
