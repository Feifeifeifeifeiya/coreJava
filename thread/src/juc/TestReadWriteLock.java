package juc;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        new Thread(new Runnable() {
            @Override
            public void run() {
           threadDemo2.set(18);
            }
        },"write").start();

        for (int i = 0; i <20 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo2.get();
                }
            },"read").start();
        }
    }
}

class ThreadDemo2{
    private int number=0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();


    public void  get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":"+number);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }

    }
}