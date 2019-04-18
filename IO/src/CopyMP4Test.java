import java.io.*;

/**
 * @ClassName CopyMP4Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 18:44
 * @Version 1.0
 **/
public class CopyMP4Test {
    public static void main(String[] args) throws IOException {
//        copy_1();
        copy_2();
    }

    private static void copy_2() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("d:\\111.mp4");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("d:\\222.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int len=0;
        while((len=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(len);
//            bufferedOutputStream.flush();
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copy_1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("d:\\111.mp4");
        int available = fileInputStream.available();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\222.mp4");
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
