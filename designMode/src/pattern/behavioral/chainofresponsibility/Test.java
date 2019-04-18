package pattern.behavioral.chainofresponsibility;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:27
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Course course = new Course();
        course.setName("java设计模式精讲");
        course.setArticle("设计模式精讲的手记");
        course.setVideo("设计模式精讲的视频");
        ArticleApprover articleApprover = new ArticleApprover();
        VideoApprover videoApprover = new VideoApprover();
        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
