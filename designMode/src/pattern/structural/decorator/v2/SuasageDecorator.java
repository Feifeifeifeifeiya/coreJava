package pattern.structural.decorator.v2;

/**
 * @ClassName SuasageDecorator
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:31
 * @Version 1.0
 **/
public class SuasageDecorator extends AbstractDecorator {
    public SuasageDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
