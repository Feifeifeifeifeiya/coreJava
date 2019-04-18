package pattern.behavioral.templateMethod;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:24
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println("后端设计模式课程start");
        ACourse patternCourse = new DesignPatternCourse();
        patternCourse.makeCourse();
        System.out.println("后端设计模式课程end");

        System.out.println("前端课程start");
        ACourse fECourse = new FECourse(true);
        fECourse.makeCourse();
        System.out.println("前端课程end");
    }
}
