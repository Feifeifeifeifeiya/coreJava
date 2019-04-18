package pattern.behavioral.chainofresponsibility;

/**
 * @ClassName ArticleApprover
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:22
 * @Version 1.0
 **/
public class ArticleApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if(course.getArticle()!=null){
            System.out.println(course.getName()+"含有手记，批准");
            if(approver!=null){
                approver.deploy(course);
            }
        }else{
            System.out.println("没有手记,不批准");
        }
    }
}
