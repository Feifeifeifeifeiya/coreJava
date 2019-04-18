package pattern.behavioral.strategy;

/**
 * @ClassName ManJianPromotionStrategy
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:09
 * @Version 1.0
 **/
public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销，满200减20");
    }
}
