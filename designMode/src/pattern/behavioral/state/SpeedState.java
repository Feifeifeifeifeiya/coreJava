package pattern.behavioral.state;

/**
 * @ClassName SpeedState
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 18:23
 * @Version 1.0
 **/
public class SpeedState extends CourseVideoState  {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("快进播放视频的状态");
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
