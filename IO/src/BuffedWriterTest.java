import java.io.*;

/**
 * @ClassName BuffedWriterTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 1:48
 * @Version 1.0
 **/
public class BuffedWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("demo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(int i=1;i<=4;i++){
            bufferedWriter.write("abcdef"+i);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        FileReader fileReader = new FileReader("demo.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        char[] chars=new char[1024];
//        bufferedReader.read(chars);
//        System.out.println(chars);
//        bufferedReader.close();
        String  line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}
