import java.io.UnsupportedEncodingException;

/**
 * @ClassName EncodingTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 1:07
 * @Version 1.0
 **/
public class EncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="你好啊";
        byte[] bytes = s.getBytes("gbk");
        for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]+"  ");
        }
        String s1 = new String(bytes, "iso8859-1");
        System.out.println(s1);
        byte[] bytes1 = s1.getBytes("iso8859-1");
        String s2 = new String(bytes1, "gbk");
        System.out.println(s2);

    }
}
