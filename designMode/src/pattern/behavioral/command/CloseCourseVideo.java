package pattern.behavioral.command;

/**
 * @ClassName CloseCourseVideo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:35
 * @Version 1.0
 **/
public class CloseCourseVideo implements Command {
    private CourseVideo courseVideo;

    public CloseCourseVideo(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}
