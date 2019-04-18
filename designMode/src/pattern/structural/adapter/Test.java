package pattern.structural.adapter;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 1:15
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        DC5 dc5=new PowerAdaptor();
        dc5.outDC5();
    }
}
