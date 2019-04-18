package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName TestDatagram
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 22:19
 * @Version 1.0
 **/
public class TestDatagramSend {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            byteBuffer.put((new Date().toString()+":\n"+str).getBytes());
            byteBuffer.flip();
            datagramChannel.send(byteBuffer,new InetSocketAddress("127.0.0.1",8080));
            byteBuffer.clear();
        }
        datagramChannel.close();

    }
}
