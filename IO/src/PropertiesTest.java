import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/14 0014 22:17
 * @Version 1.0
 **/
public class PropertiesTest {
    public static void main(String[] args) throws IOException{
        //需求：一个程序启动记录次数，超过5次就收费
        recordCount();
    }

    private static void recordCount() throws IOException {
        File file = new File("11.ini");
        if(!file.exists()){
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String time = properties.getProperty("time");
        int count=0;
        if(time!=null){
            count = Integer.parseInt(time);
            if(count>5){
                throw new RuntimeException("使用超过5次，给钱");
            }else if(count<=5){
                System.out.println("您已经使用"+count+"次,剩余"+(5-count)+"次免费使用机会");
            }
        }
        count++;
        properties.setProperty("time",String.valueOf(count));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream,"");
        fileInputStream.close();
        fileOutputStream.close();

    }
}
