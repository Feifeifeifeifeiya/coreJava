package pattern.structural.adapter.classAdaptor;

/**
 * @ClassName ConcurrentTarget
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:59
 * @Version 1.0
 **/
public class ConcurrentTarget implements Target{

    @Override
    public void request() {
        System.out.println("当前的目标方法");
    }
}
