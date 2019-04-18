import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName URLDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 22:59
 * @Version 1.0
 **/
public class URLDemo {
    public static void main(String[] args) throws IOException {
        String str_url="https://www.bilibili.com/";
        URL url = new URL(str_url);
//        url.openStream();
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[1024];
        int i=0;
        while ((i=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,bytes.length));
        }
        System.out.println(connection);
    }
}
