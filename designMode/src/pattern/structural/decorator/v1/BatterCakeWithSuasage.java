package pattern.structural.decorator.v1;

/**
 * @ClassName BatterCakeWithSuasage
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:18
 * @Version 1.0
 **/
public class BatterCakeWithSuasage extends BatterCakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc()+"加一个香肠";
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }
}
