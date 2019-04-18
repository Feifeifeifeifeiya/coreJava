package pattern.structural.decorator.v2;

/**
 * @ClassName EggDecorator
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:29
 * @Version 1.0
 **/
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    protected int cost() {
        return super.cost()+1;
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一个鸡蛋";
    }
}
