package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/8 0008 0:54
 * @Version 1.0
 **/
class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("come in");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        // 已有的结果会复用
        new Thread(futureTask).start();
        int temp = 10;
        // 也可以判断线程是否已经计算完毕
        while (!futureTask.isDone()){

        }
        // get方法是阻塞方法，要放在最后，否则会阻塞住程序的进行
        Integer integer = futureTask.get();
        System.out.println(integer+temp);
    }
}
