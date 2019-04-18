package NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 23:08
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        //获取管道
        Pipe pipe = Pipe.open();
        //将缓冲区的数据写入通道
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sink=pipe.sink();
        byteBuffer.put("发送数据".getBytes());
        byteBuffer.flip();
        sink.write(byteBuffer);

        Pipe.SourceChannel source = pipe.source();
        byteBuffer.flip();
        int i = source.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,i));
        source.close();
        sink.close();
    }
}
