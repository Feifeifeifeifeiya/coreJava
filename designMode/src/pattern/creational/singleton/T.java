package pattern.creational.singleton;

public class T implements Runnable {

    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"   "+instance);
    }
}
