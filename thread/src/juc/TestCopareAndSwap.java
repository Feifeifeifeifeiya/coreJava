package juc;

/**
 * @ClassName TestCopareAndSwap
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/18 0018 23:58
 * @Version 1.0
 **/
public class TestCopareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean compareAndSet = compareAndSwap.compareAndSet(compareAndSwap.getValue(), (int)(Math.random() * 101) );
                    System.out.println(compareAndSet);
                }
            }).start();
        }
    }
}

class CompareAndSwap{
    private int value;

    //获取
    public int getValue(){
        return value;
    }

    //设值
    public synchronized int compareAndSwap(int expected,int newValue){
        int oldValue = this.value;
        if(oldValue == expected){
            this.value = newValue;
        }
        return oldValue;
    }

    //比较
    public synchronized boolean compareAndSet(int expected,int newValue){
        return expected == compareAndSwap(expected,newValue);
    }



}
