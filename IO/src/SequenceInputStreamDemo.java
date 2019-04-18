import java.io.*;
import java.util.*;

/**
 * @ClassName SequenceInputStreamDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/14 0014 23:17
 * @Version 1.0
 **/
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //需求：将1.txt,2.txt,3.txt合并到一个txt文件中
//        Vector<FileInputStream> vector = new Vector<>();
//        vector.add(new FileInputStream("d:\\1.avi"));
//        vector.add(new FileInputStream("d:\\2.avi"));
//        vector.add(new FileInputStream("d:\\3.avi"));
//        Enumeration<FileInputStream> elements = vector.elements();
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        fileInputStreams.add(new FileInputStream("d:\\1.avi"));
        fileInputStreams.add(new FileInputStream("d:\\2.avi"));
        fileInputStreams.add(new FileInputStream("d:\\3.avi"));
        Iterator<FileInputStream> iterator = fileInputStreams.iterator();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(new Enumeration<InputStream>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public InputStream nextElement() {
                return iterator.next();
            }
        });
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\66.avi");
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=sequenceInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes);
        }
        sequenceInputStream.close();
        fileOutputStream.close();
    }
}
