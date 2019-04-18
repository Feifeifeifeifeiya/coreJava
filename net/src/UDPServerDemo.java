import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UDPServerDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 1:52
 * @Version 1.0
 **/
public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(4000);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        String hostAddress = datagramPacket.getAddress().getHostAddress();
        int port = datagramPacket.getPort();
        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(s);
        datagramSocket.close();
    }
}
