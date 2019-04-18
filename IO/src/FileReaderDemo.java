import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName FileReaderDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 0:28
 * @Version 1.0
 **/
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("demo.txt");
//        int ch=0;
//        while((ch=fileReader.read())!=-1){
//            System.out.println((char) ch);
//        }
//        fileReader.close();
        char[] chars=new char[1024];
        int read = fileReader.read(chars);
        System.out.println(new String(chars));
        System.out.println(read);
        fileReader.close();
    }
}
