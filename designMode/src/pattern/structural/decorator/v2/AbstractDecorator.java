package pattern.structural.decorator.v2;

/**
 * @ClassName AbstractDecorator
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:27
 * @Version 1.0
 **/
public class AbstractDecorator extends ABatterCake {
    private ABatterCake aBatterCake;

    public AbstractDecorator(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    @Override
    protected String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBatterCake.cost();
    }
}
