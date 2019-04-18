package pattern.creational.singleton;

public class LazyDoubleCheckSingleton {
    //volatile关键字能防止指令重排序，主要是内存可见性
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton=null;

    private LazyDoubleCheckSingleton(){}
    //双重检查锁来提高多线程判断锁的效率
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton==null){
                    lazyDoubleCheckSingleton=new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
