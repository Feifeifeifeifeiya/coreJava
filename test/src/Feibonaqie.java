/**
 * @ClassName Feibonaqie
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/8 0008 14:45
 * @Version 1.0
 **/
public class Feibonaqie {

    public static void main(String[] args) {

        System.out.println(feibo(10));

    }


    public static int feibo(int n){
        if (n == 1 || n == 2){
            return n;
        }
        return feibo(n-2)+feibo(n-1);
    }
}
