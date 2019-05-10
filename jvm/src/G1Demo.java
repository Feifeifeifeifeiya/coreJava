import java.util.Random;

/**
 * @ClassName G1Demo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/10 0010 18:50
 * @Version 1.0
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 *
 **/
public class G1Demo {
    public static void main(String[] args) {
        String str = "wufei";

        while (true){
            str += str + new Random().nextInt(777777777) + new Random().nextInt(88888888);
            str.intern();
        }
    }
}
