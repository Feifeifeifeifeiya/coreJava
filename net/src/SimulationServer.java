import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SimulationServer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 22:06
 * @Version 1.0
 **/
public class SimulationServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress()+"已连接");
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);
        //给客户一个反馈信息
//        File file = new File("f:\\photo\\126.jpg");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
//        byte[] bytes1 = new byte[1024];
//        int read1 = bufferedInputStream.read(bytes1);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
//        bufferedOutputStream.write(bytes1);
//        bufferedOutputStream.flush();
//        socket.close();
//        serverSocket.close();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("欢迎光临");
        socket.close();
        serverSocket.close();
    }
}
