import java.io.File;
import java.io.FilenameFilter;

/**
 * @ClassName FilterByJava
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/13 0013 23:31
 * @Version 1.0
 **/
public class FilterByJava implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        System.out.println(dir+"--"+name);
        return name.endsWith(".java");
    }
}
