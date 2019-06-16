package countdown;

/**
 * @ClassName Main
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 23:13
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        boolean result = false;

        try {
            result = ApplicationStartupUtil.checkExternalServices();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
