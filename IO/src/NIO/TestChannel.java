package NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName TestChannel
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 1:15
 * @Version 1.0
 **/
public class TestChannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fw = new RandomAccessFile("f:\\photo\\126.jpg", "rw");
        //获取通道
        FileChannel channel = fw.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(20);
        //分散读取
        ByteBuffer[] byteBuffers={byteBuffer1,byteBuffer2};
        channel.read(byteBuffers);
        for(ByteBuffer byteBuffer:byteBuffers){
            byteBuffer.flip();
        }
        //聚集写入
        RandomAccessFile rw = new RandomAccessFile("d:\\111.jpg", "rw");
        FileChannel channel1 = rw.getChannel();
        channel1.write(byteBuffers);
    }
}
