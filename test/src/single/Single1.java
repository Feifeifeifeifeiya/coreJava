package single;

/**
 * @ClassName Single1
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/15 0015 0:21
 * @Version 1.0
 **/
public class Single1 {
    private Single1(){

    }

    private static class Inner{
        private  static Single1 single1 = new Single1();
    }

    public static Single1 instance(){
        return Inner.single1;
    }

}
