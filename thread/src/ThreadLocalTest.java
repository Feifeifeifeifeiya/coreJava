/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/13 0013 22:41
 * @Version 1.0
 **/
public class ThreadLocalTest {

    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

//    public void set(){
//        longThreadLocal.set(Thread.currentThread().getId());
//        stringThreadLocal.set(Thread.currentThread().getName());
//    }

    public Long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        //threadLocalTest.set();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

        Thread thread = new Thread(() -> {
            //threadLocalTest.set();
            System.out.println(threadLocalTest.getLong());
            System.out.println(threadLocalTest.getString());
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

    }
}
