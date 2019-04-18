package pattern.structural.decorator.v2;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:31
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        ABatterCake aBatterCake;
        aBatterCake=new BatterCake();
        aBatterCake=new EggDecorator(aBatterCake);
        aBatterCake=new EggDecorator(aBatterCake);
        aBatterCake=new SuasageDecorator(aBatterCake);
        System.out.println("商品："+aBatterCake.getDesc()+"价格："+aBatterCake.cost());
    }
}
