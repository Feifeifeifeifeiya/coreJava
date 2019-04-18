import java.io.*;
import java.net.Socket;

/**
 * @ClassName TxtClient
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 16:40
 * @Version 1.0
 **/
public class TxtClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10010);
        File file = new File("d:\\1.txt");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[1024];
        int i = inputStream.read(bytes);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        inputStream.close();
        socket.close();
    }
}
