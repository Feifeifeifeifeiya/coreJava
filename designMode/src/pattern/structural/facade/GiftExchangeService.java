package pattern.structural.facade;

public class GiftExchangeService {
    private PointPaymentService pointPaymentService;
    private QualifyService qualifyService;
    private ShoppingService shoppingService;

    public void setPointPaymentService(PointPaymentService pointPaymentService) {
        this.pointPaymentService = pointPaymentService;
    }

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setShoppingService(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    public void getExchange(PointGift pointGift){
        if(qualifyService.isAvailable(pointGift)){
            //如果积分校验通过，进入支付校验系统
            if(pointPaymentService.pay(pointGift)){
                //如果支付校验通过，进入物流发货阶段
                String shipGift = shoppingService.shipGift(pointGift);
                System.out.println(shipGift);
            }
        }
    }
}
