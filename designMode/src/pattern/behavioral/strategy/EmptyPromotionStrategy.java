package pattern.behavioral.strategy;

/**
 * @ClassName EmptyPromotionStrategy
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:28
 * @Version 1.0
 **/
public class EmptyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
