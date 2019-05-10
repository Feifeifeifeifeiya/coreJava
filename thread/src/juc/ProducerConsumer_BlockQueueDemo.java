package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ProducerConsumer_BlockQueueDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 22:41
 * @Version 1.0
 **/
class MyResource{
    private volatile boolean FLAG = true; //标志位

    private AtomicInteger atomicInteger=new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(Thread.currentThread().getName());
    }

    public void myProducer() throws InterruptedException {
        String data;
        boolean result;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            result = blockingQueue.offer(data,2L,TimeUnit.SECONDS);
            if (result){
                System.out.println(Thread.currentThread().getName()+"\t"+"插入数据"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t"+"插入数据失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停,表示FLAG==false,生产动作结束");
    }


    public void myConsumer() throws InterruptedException {
        String result;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (result==null || result.equals("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t等待超过两秒钟，退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费数据"+result+"成功");
        }
    }


    public void stop(){
        this.FLAG = false;
    }

}


public class ProducerConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            try {
                myResource.myProducer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                myResource.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"B").start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("大老板叫停");
        myResource.stop();
    }
}
