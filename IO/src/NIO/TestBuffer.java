package NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @ClassName TestBuffer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 0021 0:25
 * @Version 1.0
 **/
public class TestBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("f:\\photo\\126.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\2.jpg");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileChannel inchannel = fileInputStream.getChannel();
        FileChannel outchannel = fileOutputStream.getChannel();
        while (inchannel.read(buffer)!=-1){
            buffer.flip();//切换成读数据模式
            outchannel.write(buffer);
            buffer.clear();
        }
        inchannel.close();
        outchannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
