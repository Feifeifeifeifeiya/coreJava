package juc;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @ClassName BlockQueueDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 18:20
 * @Version 1.0
 **/
public class BlockQueueDemo {
    public static void main(String[] args) throws Exception{
        // 什么是阻塞队列？
        // 当阻塞队列为空的时候，从队列中获取元素的操作将会被阻塞
        // 当阻塞队列为满的时候，往队列中添加元素的操作将会被阻塞

        // 为什么需要阻塞队列？
        // 好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，这一切BlockQueue帮我们办了

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

        blockingQueue.add("a");
        blockingQueue.element();
        blockingQueue.remove();

        System.out.println("上面的是会抛异常的");

        blockingQueue.offer("b");
        blockingQueue.peek();
        blockingQueue.poll();

        System.out.println("上面的是成功返回true，失败返回false");

        blockingQueue.put("c");
        blockingQueue.take();
        System.out.println("上面的是不成功则会阻塞");

        blockingQueue.offer("d",2L,TimeUnit.SECONDS);
        blockingQueue.poll(2l,TimeUnit.SECONDS);
        System.out.println("超过超时时间返回false");

        // 不存储元素的阻塞队列,每一个put操作必须等待一个take操作，反之亦然
        BlockingQueue<Object> queue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                queue.put("1");
                TimeUnit.SECONDS.sleep(1);
                queue.put("2");
                TimeUnit.SECONDS.sleep(1);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }
}
