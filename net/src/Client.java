import java.io.*;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 3:21
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10010);
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        while ((s = bufferedReader.readLine())!=null){
            outputStream.write(s.getBytes());
        }
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s1 = bufferedReader1.readLine();
        System.out.println(s1);
        socket.close();
    }
}
