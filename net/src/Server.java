import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 3:21
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        String s = new String(bytes, 0, bytes.length);
        String s1 = s.toUpperCase();
        System.out.println(s);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(s1.getBytes());

        socket.close();
        serverSocket.close();
    }
}
