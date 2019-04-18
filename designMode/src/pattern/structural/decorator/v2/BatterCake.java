package pattern.structural.decorator.v2;

/**
 * @ClassName BatterCake
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:25
 * @Version 1.0
 **/
public class BatterCake extends ABatterCake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
