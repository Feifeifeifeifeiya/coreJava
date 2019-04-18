package pattern.structural.decorator.v1;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:19
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println("商品描述"+batterCake.getDesc()+"价格："+batterCake.cost());
        BatterCake batterCake2 =new BatterCakeWithEgg();
        System.out.println("商品描述"+batterCake2.getDesc()+"价格："+batterCake2.cost());
        BatterCake batterCake3 =new BatterCakeWithSuasage();
        System.out.println("商品描述"+batterCake3.getDesc()+"价格："+batterCake3.cost());
    }
}
