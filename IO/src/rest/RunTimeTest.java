package rest;

import java.io.IOException;

/**
 * @ClassName RunTimeTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 3:09
 * @Version 1.0
 **/
public class RunTimeTest {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("F:\\CloudMusic\\cloudmusic.exe");
    }
}
