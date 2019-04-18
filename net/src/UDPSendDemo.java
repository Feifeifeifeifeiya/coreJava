import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPSendDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 1:52
 * @Version 1.0
 **/
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "哈哈哈哈哈哈哈哈哈".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"),4000);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();

    }
}
