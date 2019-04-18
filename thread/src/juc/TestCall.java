package juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCall {
    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        FutureTask<Integer> task = new FutureTask<>(demo);
        new Thread(task).start();
        try {
            Integer integer = task.get();
            System.out.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class TestDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<=100;i++){
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}