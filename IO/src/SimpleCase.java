import java.io.*;

/**
 * @ClassName SimpleCase
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 21:25
 * @Version 1.0
 **/
public class SimpleCase {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        String line = null;
//        while((line = bufferedReader.readLine())!=null){
//            if("over".equals(line)){
//                break;
//            }
//            bufferedWriter.write(line.toUpperCase());
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//        }
//    }

    //将键盘录入的数据写入到另一个文件中去
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\333.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\44.txt")));
//        String s = null;
//        while((s = bufferedReader.readLine())!=null){
//            bufferedWriter.write(s);
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//        }
//    }

    public static void main(String[] args) throws IOException {
        //将文件的内容显示在控制台上
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\44.txt")));
        String s = null;
        while ((s = bufferedReader.readLine())!=null){
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }
}
