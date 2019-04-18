package pattern.behavioral.templateMethod;

/**
 * @ClassName DesignPatternCourse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:22
 * @Version 1.0
 **/
public class DesignPatternCourse extends ACourse {
    @Override
    protected boolean needArticle() {
        return true;
    }

    @Override
    void packageCourse() {
        System.out.println("提供课程的源代码");
    }
}
