import java.io.*;

/**
 * @ClassName CopyTextTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 0:47
 * @Version 1.0
 **/
public class CopyTextTest {
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader("d:\\111.txt");
//        char[] chars=new char[1024];
//        fileReader.read(chars);
//        System.out.println(new String(chars));
//        fileReader.close();
//        FileWriter fileWriter = new FileWriter("c:\\222.txt");
//        fileWriter.write(chars);
//        fileWriter.close();


//        File file = new File("d:\\111.txt");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        InputStreamReader reader = new InputStreamReader(fileInputStream, "GBK");
//        char[] chars=new char[1024];
//        reader.read(chars);
//        System.out.println(new String(chars));
//        reader.close();
//        fileInputStream.close();
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("c:\\222.txt"));
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
//        outputStreamWriter.write(chars);
//        outputStreamWriter.close();
//        fileOutputStream.close();

        FileReader fileReader = new FileReader("d:\\111.txt");
        FileWriter fileWriter = new FileWriter("c:\\222.txt");
        int ch;
        while ((ch=fileReader.read())!=-1){
            fileWriter.write(ch);
        }
        fileReader.close();
        fileWriter.close();
    }
}
