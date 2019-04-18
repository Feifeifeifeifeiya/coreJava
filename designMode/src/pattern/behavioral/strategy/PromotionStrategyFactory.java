package pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PromotionStrategyFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:21
 * @Version 1.0
 **/
public class PromotionStrategyFactory {
    private PromotionStrategyFactory(){}

    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP=new HashMap<>();

    private static final PromotionStrategy emptyPromotionStrategy=new EmptyPromotionStrategy();
    private interface PromotionKey{
        String LIJIAN="LIJIAN";
        String MANJIAN="MANJIAN";
        String FANXIAN="FANXIAN";
    }
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN,new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN,new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN,new FanXianPromotionStrategy());
    }

    public static  PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy==null? emptyPromotionStrategy:promotionStrategy;
    }
}
