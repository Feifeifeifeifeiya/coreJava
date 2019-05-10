package juc;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/8 0008 2:41
 * @Version 1.0
 **/
class HelloThread implements Runnable{
    private String lockA;
    private String lockB;

    public HelloThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println("获取"+lockA+",尝试获取"+lockB);
            synchronized (lockB){
                System.out.println("获取"+lockB+",尝试获取"+lockA);
            }
        }
    }
}


public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HelloThread(lockA,lockB)).start();
        new Thread(new HelloThread(lockB,lockA)).start();
    }
}
