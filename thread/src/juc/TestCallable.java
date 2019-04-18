package juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        //执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        //FutrureTask实现Future接口
        FutureTask<Integer> task = new FutureTask<>(threadDemo);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Integer integer = task.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //接收线程运算过的结果

    }
}

class ThreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i <10000 ; i++) {
            sum+=i;
        }
        return sum;
    }
}
