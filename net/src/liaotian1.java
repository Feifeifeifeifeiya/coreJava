import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @ClassName liaotian1
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 0017 2:08
 * @Version 1.0
 **/
public class liaotian1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10010);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            if("over".equals(line)){
                break;
            }
            byte[] bytes = line.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10086);
            datagramSocket.send(datagramPacket);
        }
//        byte[] bytes = new byte[1024];
//        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
//        datagramSocket.receive(datagramPacket);
//        InetAddress address = datagramPacket.getAddress();
//        int port = datagramPacket.getPort();
//        byte[] data = datagramPacket.getData();
//        System.out.println("地址"+address+"端口"+port+"内容"+new String(data,0,data.length));
 //       datagramSocket.close();
    }
}
