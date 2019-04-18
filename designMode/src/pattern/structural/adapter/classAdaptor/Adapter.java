package pattern.structural.adapter.classAdaptor;

/**
 * @ClassName Adapter
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:58
 * @Version 1.0
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
