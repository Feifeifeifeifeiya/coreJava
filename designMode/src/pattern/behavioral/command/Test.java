package pattern.behavioral.command;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:42
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("java设计模式精讲");
        OpenCourseVideo openCourseVideo = new OpenCourseVideo(courseVideo);
        CloseCourseVideo closeCourseVideo = new CloseCourseVideo(courseVideo);
        Staff staff = new Staff();
        staff.addCommands(openCourseVideo);
        staff.addCommands(closeCourseVideo);
        staff.executeCommands();
    }
}
