package single;

/**
 * @ClassName Single2
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/15 0015 0:23
 * @Version 1.0
 **/
public class Single2 {
    private static Single2 single2 = null;

    private Single2(){}

    public static Single2 instance(){
        if (single2 == null){
            synchronized(Single2.class){
                if (single2 == null){
                    single2 = new Single2();
                }
            }
        }
        return single2;
    }

    public void Single2(){
        System.out.println("hahha");
    }
}
