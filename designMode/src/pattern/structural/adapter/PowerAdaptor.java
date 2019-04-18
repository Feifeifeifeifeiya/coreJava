package pattern.structural.adapter;

/**
 * @ClassName PowerAdaptor
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 1:11
 * @Version 1.0
 **/
public class PowerAdaptor implements DC5 {
    private AC220 ac220=new AC220();
    @Override
    public int outDC5() {
       int input= ac220.outAC220V();
       //认为这是个变压器
       int output=input/44;
        System.out.println("输入交流电AC"+input+"V,"+"输出直流电DC"+output+"V");
        return output;
    }
}
