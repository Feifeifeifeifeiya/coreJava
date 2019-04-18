import java.io.File;

/**
 * @ClassName FileRecursion
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 23:48
 * @Version 1.0
 **/
public class FileRecursion {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects");
        listAll(file);
    }

    private static void listAll(File file) {
        File[] files = file.listFiles();
        for(File file1:files){
            if(file1.isDirectory()){
                listAll(file1);
            }
            System.out.println(file1.getName());
        }
    }
}
