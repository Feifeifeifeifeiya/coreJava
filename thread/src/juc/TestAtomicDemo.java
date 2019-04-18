package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestAtomicDemo  i++的原子性问题，i++是读，改，写的三步操作
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/18 0018 23:28
 * @Version 1.0
 **/
//原子变量：1.volatile保证了内存可见性
//        2.（compare-and-swap）CAS算法保证了原子性
//        CAS算法是计算机硬件对于并发操作共享数据的支持
//        包含三个值：A内存值
//                  B预估值
//                  V更新值
//                  当且仅当A==B时，A=V，否则，什么也不做
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for(int i=0;i<10;i++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSerNumber());
    }

    public int getSerNumber(){

        return atomicInteger.getAndIncrement();
    }
}
