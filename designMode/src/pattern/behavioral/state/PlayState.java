package pattern.behavioral.state;

/**
 * @ClassName PlayState
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 18:23
 * @Version 1.0
 **/
public class PlayState extends CourseVideoState {
    @Override
    public void play() {
        System.out.println("正常播放视频的状态");
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
