import java.io.UnsupportedEncodingException;

/**
 * @ClassName EbookTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 1:28
 * @Version 1.0
 **/
public class EbookTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="联通";
        byte[] bytes = s.getBytes("gbk");
        for (byte b:bytes){
//            System.out.print(b+"  ");//-63  -86  -51  -88
            System.out.print(Integer.toBinaryString(b&255));
            //11000001     10101010     11001101     10101000 正好符合utf-8解码的规范
            System.out.print("     ");
        }
    }
}
