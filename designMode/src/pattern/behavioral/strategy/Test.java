package pattern.behavioral.strategy;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 13:15
 * @Version 1.0
 **/
public class Test {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
//        PromotionActivity promotionActivity1111 = new PromotionActivity(new ManJianPromotionStrategy());
//        promotionActivity618.excutePromotionStrategy();
//        promotionActivity1111.excutePromotionStrategy();
//    }
//public static void main(String[] args) {
//    PromotionActivity promotionActivity=null;
//    String promotionKey="LiJian";
//    if("LiJian".equals(promotionKey)){
//        promotionActivity=new PromotionActivity(new LiJianPromotionStrategy());
//    }else if("ManJian".equals(promotionKey)){
//        promotionActivity=new PromotionActivity(new ManJianPromotionStrategy());
//    }//...
//    promotionActivity.excutePromotionStrategy();
//}
public static void main(String[] args) {
    String positionKey="FANXIAN";
    PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(positionKey));
    promotionActivity.excutePromotionStrategy();
}
}
