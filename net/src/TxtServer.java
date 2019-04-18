import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TxtServer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 16:40
 * @Version 1.0
 **/
public class TxtServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        FileOutputStream fileOutputStream = new FileOutputStream("e:\\1.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
