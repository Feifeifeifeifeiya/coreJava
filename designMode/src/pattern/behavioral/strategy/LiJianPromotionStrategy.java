package pattern.behavioral.strategy;

/**
 * @ClassName LiJianPromotionStrategy
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:08
 * @Version 1.0
 **/
public class LiJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销，课程的价格直接减去配置的价格");
    }
}
