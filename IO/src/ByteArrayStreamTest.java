import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @ClassName ByteArrayStreamTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 0:39
 * @Version 1.0
 **/
public class ByteArrayStreamTest {
    public static void main(String[] args) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("你哈哈哈".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int cc=0;
        while ((cc=byteArrayInputStream.read())!=-1){
            byteArrayOutputStream.write(cc);
        }
        System.out.println(byteArrayOutputStream.toString());
    }
}
