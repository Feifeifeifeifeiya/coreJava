package pattern.behavioral.chainofresponsibility;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:18
 * @Version 1.0
 **/
public class Course {
    private String name;
    private String article;
    private String video;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
