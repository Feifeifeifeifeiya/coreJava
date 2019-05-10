package juc;

import java.util.concurrent.*;


// 线程池的7大参数
// corePoolSize: 线程池的常驻核心线程数
// maximumPoolSize:线程池能够容纳同时执行的最大线程数，此值必须大于等于1
// keepAliveTime:多余的空闲线程的存活时间
// unit:keepAliveTime的时间单位
// workQueue:任务队列，提交但是未执行的任务
// threadFactory:表示生成线程池中的工作线程的线程工厂，一般用默认的即可
// RejectedExecutionHandler:拒绝策略


/**
 * @ClassName Thread_Pool_Demo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/8 0008 1:24
 * @Version 1.0
 **/
public class Thread_Pool_Demo {
    public static void main(String[] args) {
        // 查看cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // ExecutorService executorService = Executors.newFixedThreadPool(5); //固定数量的线程池
        // ExecutorService executorService = Executors.newSingleThreadExecutor(); //只有一个线程的线程池
        // ExecutorService executorService = Executors.newCachedThreadPool(); //数量不固定的带缓存的线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i=0;i<10;i++){
                final int temp = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"为"+temp+"号客户办理业务");
                });
            }
        }finally {
            executorService.shutdown();
        }

    }
}
