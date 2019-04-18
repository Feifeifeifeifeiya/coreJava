import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName IPDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 0:58
 * @Version 1.0
 **/
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for(InetAddress i:allByName){
            System.out.println(i.getHostAddress());
        }
    }
}
