package pattern.behavioral.chainofresponsibility;

/**
 * @ClassName VideoApprover
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:25
 * @Version 1.0
 **/
public class VideoApprover extends Approver{
    @Override
    public void deploy(Course course) {
        if(course.getVideo()!=null){
            System.out.println(course.getName()+"含有视频，批准");
            if(approver!=null){
                approver.deploy(course);
            }
        }else{
            System.out.println("没有视频,不批准");
        }
    }
}
