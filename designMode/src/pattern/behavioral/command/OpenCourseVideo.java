package pattern.behavioral.command;

/**
 * @ClassName OpenCourseVideo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:35
 * @Version 1.0
 **/
public class OpenCourseVideo implements Command {
    private CourseVideo courseVideo;

    public OpenCourseVideo(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }
    @Override
    public void execute() {
        courseVideo.open();
    }
}
