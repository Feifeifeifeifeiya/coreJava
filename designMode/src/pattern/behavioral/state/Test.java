package pattern.behavioral.state;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 20:53
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        CourseVideoContext courseVideoContext = new CourseVideoContext();
        courseVideoContext.setCourseVideoState(new PlayState());
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
        courseVideoContext.pause();
        System.out.println("当前状态："+courseVideoContext.getCourseVideoState().getClass().getSimpleName());
    }
}
