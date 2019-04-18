import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @ClassName SimpleCase2
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 22:24
 * @Version 1.0
 **/
public class SimpleCase2 {
    public static void main(String[] args) throws IOException {
        //将一个中文字符串数据按照指定的编码表写入到文件中
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\55.txt"), "utf-8"));
//        String s="吴飞是个人才";
//        char[] chars = s.toCharArray();
//        bufferedWriter.write(chars);
        bufferedWriter.write("hahhahahahhahah");
        bufferedWriter.close();
    }
}
