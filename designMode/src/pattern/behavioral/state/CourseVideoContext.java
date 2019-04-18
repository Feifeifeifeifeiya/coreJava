package pattern.behavioral.state;

/**
 * @ClassName CourseVideoContext
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 18:11
 * @Version 1.0
 **/
public class CourseVideoContext {
    private CourseVideoState courseVideoState;
    public static final PlayState PLAY_STATE=new PlayState();
    public static final SpeedState SPEED_STATE=new SpeedState();
    public static final PauseState PAUSE_STATE=new PauseState();
    public static final StopState STOP_STATE=new StopState();

    public CourseVideoState getCourseVideoState() {
        return courseVideoState;
    }

    public void setCourseVideoState(CourseVideoState courseVideoState) {
        this.courseVideoState = courseVideoState;
        this.courseVideoState.setCourseVideoContext(this);
    }

    public void play(){
        this.courseVideoState.play();
    }
    public void speed(){
        this.courseVideoState.speed();
    }
    public void pause(){
        this.courseVideoState.pause();
    }
    public void stop(){
        this.courseVideoState.stop();
    }
}
