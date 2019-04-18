package pattern.behavioral.state;

/**
 * @ClassName CourseVideoState
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 18:11
 * @Version 1.0
 **/
public abstract class CourseVideoState {
    protected CourseVideoContext courseVideoContext;

    public void setCourseVideoContext(CourseVideoContext courseVideoContext) {
        this.courseVideoContext = courseVideoContext;
    }

    public abstract void play();
    public abstract void speed();
    public abstract void pause();
    public abstract void stop();
}
