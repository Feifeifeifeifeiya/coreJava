import java.io.*;
import java.util.*;


/**
 * @ClassName SplitFileTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/15 0015 0:13
 * @Version 1.0
 **/
public class SplitFileTest {
    private static final int SIZE=1024*1024;
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\1.avi");
        FileInputStream fileInputStream = new FileInputStream(file);
        splitFile(fileInputStream,file);
        mergeFile();
    }

    private static void mergeFile() throws IOException {
        File file = new File("d:\\part");
        File[] files = file.listFiles();
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for(int i=0;i<files.length;i++){
            fileInputStreams.add(new FileInputStream(files[i]));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(fileInputStreams);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        byte[] bytes=new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\2.avi");
        int len=0;
        while ((len=sequenceInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes);
        }
        sequenceInputStream.close();
        fileOutputStream.close();
    }

    private static void splitFile(FileInputStream fileInputStream ,File yuan) throws IOException {
        byte[] bytes = new byte[SIZE];
        File file = new File("d:\\part");
        if(!file.exists()){
            file.mkdir();
        }
        int len = 0;
        int count=1;
        FileOutputStream fileOutputStream=null;
        while ((len = fileInputStream.read(bytes))!=-1){
            fileOutputStream = new FileOutputStream(new File(file, (count++) + ".part"));
            fileOutputStream.write(bytes,0,len);
        }
        Properties properties = new Properties();
        FileOutputStream fileOutputStream1 = new FileOutputStream(new File(file, count+".properties"));
        properties.setProperty("partcount",String.valueOf(count));
        properties.setProperty("filename",yuan.getName());
        properties.store(fileOutputStream1,"");
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
