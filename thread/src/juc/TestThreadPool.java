package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
*工具类：Executors
*ExecutorService newFixedThreadPool():创建固定大小的线程池
*ExecutorService newCachedThreadPool():缓存线程池，线程的数量不固定，可以根据需求自动的改变数量
*ExecutorService newSingleThreadPool():创建单个线程池，只有一个线程
*ExecutorService newScheduledThreadPool():创建固定大小的线程池，可以延时或定时的执行任务
* */
public class TestThreadPool {
    public static void main(String[] args) throws Exception{
        //创建线程池
        ExecutorService service =Executors.newFixedThreadPool(5);
        ThreadPoolDemo poolDemo = new ThreadPoolDemo();
        List<Future<Integer>> list = new ArrayList<>();
        //为线程池中的线程分配任务
        for (int i = 0; i <10 ; i++) {
            Future<Integer> future = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int j = 0; j <= 100; j++) {
                        sum += j;
                    }
                    return sum;
                }
            });
            list.add(future);
        }
        service.shutdown();
        for (Future<Integer> future:list){
            System.out.println(future.get());
        }
       /* for (int i = 0; i < 10; i++) {
            service.submit(poolDemo);
        }

        //关闭线程池
        service.shutdown();*/
    }
}
class ThreadPoolDemo implements Runnable{
    private int i=0;
    @Override
    public void run() {
        while(i<=100){
            System.out.println(Thread.currentThread().getName()+"\t"+i);
            i++;
        }
    }
}