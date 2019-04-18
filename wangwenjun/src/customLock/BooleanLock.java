package customLock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BooleanLock implements Lock {

    private boolean flag;

    private Collection<Thread> blockThreads=new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        flag=false;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            while (flag){
                blockThreads.add(Thread.currentThread());
                this.wait();
            }
            blockThreads.remove(Thread.currentThread());
            this.currentThread=Thread.currentThread();
            flag=true;
        }
    }

    @Override
    public void lock(long millis) throws InterruptedException, TimeOutException {

    }

    @Override
    public void unlock() {
        if(currentThread==Thread.currentThread()){
            this.flag=false;
            blockThreads.remove(Thread.currentThread());
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockThread() {
        return Collections.unmodifiableCollection(blockThreads);
    }

    @Override
    public int getBlockSize() {
        return blockThreads.size();
    }
}
