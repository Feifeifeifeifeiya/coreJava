package juc;

import sun.awt.SunHints;

import java.security.KeyFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReentrantReadWriteDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/7 0007 2:56
 * @Version 1.0
 **/
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在写入\t"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在读取");
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成\t"+value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}


public class ReentrantReadWriteDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i=0;i<10;i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.put(String.valueOf(tempInt),""+tempInt);
            },String.valueOf(i)).start();
        }

        for(int i=0;i<10;i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.get(String.valueOf(tempInt));
            },String.valueOf(i)).start();
        }
    }
}
