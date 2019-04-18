import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileWriterDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 22:29
 * @Version 1.0
 **/
public class FileWriterDemo {
    public static void main(String[] args)throws IOException {
        //构造函数加入true可以续写
        FileWriter fileWriter = new FileWriter("demo.txt",true);
        //调用write方法，写入数据，其实数据是写入到临时存储缓冲区中
        fileWriter.write("哈哈哈"+System.getProperty("line.separator")+"嘻嘻嘻");
        fileWriter.write("牛牛牛");
        //进行刷新，将数据写入到目的地
//        fileWriter.flush();
        fileWriter.close();
    }
}
