package pattern.behavioral.strategy;

/**
 * @ClassName PromotionActivity
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:12
 * @Version 1.0
 **/
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excutePromotionStrategy(){
        promotionStrategy.doPromotion();
    }
}
