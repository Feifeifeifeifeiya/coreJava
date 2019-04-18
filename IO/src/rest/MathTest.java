package rest;

import java.util.Random;

/**
 * @ClassName MathTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 3:28
 * @Version 1.0
 **/
public class MathTest {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;i<9;i++){
 //           double d = (int)(Math.random()*10);
            int d=(int)(random.nextDouble()*10+1);
            System.out.println(d);
        }
    }
}
