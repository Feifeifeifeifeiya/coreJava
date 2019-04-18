package pattern.structural.decorator.v1;

/**
 * @ClassName BatterCakeWithEgg
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/6 0006 0:16
 * @Version 1.0
 **/
public class BatterCakeWithEgg extends BatterCake {

    @Override
    public String getDesc() {
        return super.getDesc()+"加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }
}
