import java.util.concurrent.*;

public class CustomThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        CustomThread customThread = new CustomThread();
//        Future future = threadPool.submit(customThread);
//        Object o = future.get();
//        System.out.println(o);
//        threadPool.shutdown();
        CustomThread thread = new CustomThread();
        FutureTask task = new FutureTask<>(thread);
        for(int i=0;i<3;i++){
            new Thread(task).start();
        }
    }

}
class CustomThread implements Callable{
    private int sum=0;
    @Override
    public Object call() throws Exception {

        Thread.sleep(1000);
        for(int j=0;j<1000000;j++){
            sum+=j;
            System.out.println(Thread.currentThread().getName()+":"+sum);
        }
        return sum;
    }

}