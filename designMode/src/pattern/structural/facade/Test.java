package pattern.structural.facade;

public class Test {
    public static void main(String[] args) {
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.setQualifyService(new QualifyService());
        giftExchangeService.setPointPaymentService(new PointPaymentService());
        giftExchangeService.setShoppingService(new ShoppingService());
        PointGift pointGift = new PointGift();
        pointGift.setName("衬衫");
        giftExchangeService.getExchange(pointGift);
    }
}
