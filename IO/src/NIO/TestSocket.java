package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * @ClassName TestSocket
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 20:51
 * @Version 1.0
 **/
public class TestSocket {
    public static void main(String[] args) throws IOException {
        //客户端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        //切换成非阻塞模式
        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //把要发送的数据添加进来
        byteBuffer.put(new Date().toString().getBytes());
        //切换成读模式
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        socketChannel.close();
    }
}
