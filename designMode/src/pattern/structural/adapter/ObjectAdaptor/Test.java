package pattern.structural.adapter.ObjectAdaptor;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 1:00
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        Target concurrentTarget = new ConcurrentTarget();
        concurrentTarget.request();
        Target adapter = new Adapter();
        adapter.request();
    }
}
