import java.io.*;

/**
 * @ClassName DataStreamTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 0:26
 * @Version 1.0
 **/
public class DataStreamTest {
    public static void main(String[] args) throws IOException {
 //       writeDemo();
        readDemo();
    }

    private static void readDemo() throws IOException{
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("d:\\11.txt"));
        String s = dataInputStream.readUTF();
        System.out.println(s);
        dataInputStream.close();
    }

    private static void writeDemo() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("d:\\11.txt"));
        dataOutputStream.writeUTF("你好哦");
        dataOutputStream.close();
    }

}
