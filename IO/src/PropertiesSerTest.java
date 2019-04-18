import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName PropertiesSerTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/14 0014 21:13
 * @Version 1.0
 **/
public class PropertiesSerTest {
    public static void main(String[] args) throws IOException{
//        methodDemo_3();
//        methodDemo_2();
        methodDemo_4();
    }


    private static void methodDemo_4() throws IOException {
        //对已有的文件信息进行修改
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("22.txt");
        properties.load(fileInputStream);
        Set<String> strings = properties.stringPropertyNames();
        for(String s:strings){
            System.out.println(s+"="+properties.getProperty(s));
            if("zhaoliu".equals(s)){
                properties.setProperty(s,"16");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("22.txt");
        properties.store(fileOutputStream,"haha");
        fileInputStream.close();
        fileOutputStream.close();

    }

    private static void methodDemo_2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("22.txt"));
        properties.list(System.out);
    }

    private static void methodDemo_3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("22.txt");
        Properties properties = new Properties();
        properties.setProperty("zhangsan","2");
        properties.setProperty("lisi","3");
        properties.setProperty("wangwu","5");
        properties.setProperty("zhaoliu","5");
        properties.store(fileOutputStream,"优秀");
        fileOutputStream.close();
    }
}
