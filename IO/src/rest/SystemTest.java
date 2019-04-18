package rest;

import java.util.Properties;
import java.util.Set;

/**
 * @ClassName SystemTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 3:12
 * @Version 1.0
 **/
public class SystemTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<String> strings = properties.stringPropertyNames();
        for(String s:strings){
            System.out.println(s+":"+properties.getProperty(s));
        }
    }
}
