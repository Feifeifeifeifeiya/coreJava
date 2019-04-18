package pattern.structural.adapter.ObjectAdaptor;

/**
 * @ClassName Adapter
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:58
 * @Version 1.0
 **/
public class Adapter  implements Target {
    private Adaptee adaptee=new Adaptee();
    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
