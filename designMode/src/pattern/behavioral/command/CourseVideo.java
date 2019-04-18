package pattern.behavioral.command;

/**
 * @ClassName CourseVideo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:33
 * @Version 1.0
 **/
public class CourseVideo {
    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open(){
        System.out.println(name+"课程视频开放");
    }

    public void close(){
        System.out.println(name+"课程视频关闭");
    }
}
