import java.io.File;

/**
 * @ClassName RemoveDirTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/14 0014 20:47
 * @Version 1.0
 **/
public class RemoveDirTest {
    public static void main(String[] args) {
        //删除文件夹要进行深度遍历
        File file = new File("D:\\logs");
        removeDir(file);
    }

    private static void removeDir(File file) {
        File[] files = file.listFiles();
        for(File file1:files){
            if(file1.isDirectory()){
                removeDir(file1);
            }else {
                file1.delete();
            }
        }
        file.delete();
    }
}
