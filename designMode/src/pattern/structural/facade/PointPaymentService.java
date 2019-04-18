package pattern.structural.facade;
//支付验证系统
public class PointPaymentService {

    public boolean pay(PointGift pointGift){
        System.out.println("用户"+pointGift.getName()+"支付验证通过");
        return true;
    }
}
