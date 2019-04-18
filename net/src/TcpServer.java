import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TcpServer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 2:53
 * @Version 1.0
 **/
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket accept = serverSocket.accept();
        byte[] address = accept.getInetAddress().getAddress();
        int port = accept.getPort();
        InputStream inputStream = accept.getInputStream();
        int cc=0;
        byte[] bytes = new byte[1024];
        while ((cc=inputStream.read(bytes))!=-1){
            System.out.println("地址"+address+"端口"+port+"内容"+new String(bytes,0,bytes.length));
            System.out.println(bytes.length);
            if (bytes.length>0){
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("收到书就".getBytes());
            }
        }

        accept.close();
        serverSocket.close();
    }
}
