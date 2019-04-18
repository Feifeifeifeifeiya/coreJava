import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 22:50
 * @Version 1.0
 **/
public class FileTest {
//    public static void main(String[] args) {
//        File file = new File("d:\\55.txt");
//        System.out.println(file.getName());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());
//        System.out.println(file.length());
//        long time = file.lastModified();
//        Date date = new Date(time);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm E");
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
//        System.out.println(file.getParent());
//        System.out.println(file.getAbsoluteFile());
//    }


//public static void main(String[] args) throws IOException {
//    //文件的创建和删除
//    File file = new File("d:\\file.txt");
//    boolean newFile = file.createNewFile();
//    System.out.println("newFile"+newFile);
//    boolean delete = file.delete();
//    System.out.println(delete);
//}

//    public static void main(String[] args) {
//        File file = new File("d:\\abc");
//        boolean mkdir = file.mkdir();
//        boolean ccc = file.renameTo(new File("d:\\ccc"));
//        System.out.println(mkdir);
//        System.out.println(ccc);
//
//    }
//public static void main(String[] args) {
//    File[] files = File.listRoots();
//    for(File file:files){
//        System.out.println(file);
//    }
//}
public static void main(String[] args) {
    File file = new File("E:\\IdeaProjects");
    String[] list = file.list(new FilterByJava());
    for(String s:list){
        System.out.println(s);
    }
}
}
