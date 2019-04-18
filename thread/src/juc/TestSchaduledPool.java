package juc;

import java.util.concurrent.*;

public class TestSchaduledPool {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i <3 ; i++) {
            ScheduledFuture<Integer> future = pool.schedule(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int i = (int) Math.random() * 100;
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    return i;
                }
            }, 3, TimeUnit.SECONDS);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
