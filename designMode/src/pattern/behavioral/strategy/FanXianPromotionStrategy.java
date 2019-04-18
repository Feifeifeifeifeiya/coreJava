package pattern.behavioral.strategy;

/**
 * @ClassName FanXianPromotionStrategy
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:10
 * @Version 1.0
 **/
public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额存入到慕课网的账户余额中");
    }
}
