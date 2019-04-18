package customLock;

import java.util.Collection;

public interface Lock {

    class TimeOutException extends Exception{
        public TimeOutException(String message ){
            super(message);
        }
    }
    //开启锁
    void lock() throws InterruptedException;
    //开启锁
    void lock(long millis) throws InterruptedException,TimeOutException;
    //释放锁
    void unlock();
    //获取阻塞的线程
    Collection<Thread> getBlockThread();
    //获取阻塞队列的长度
    int getBlockSize();
}
