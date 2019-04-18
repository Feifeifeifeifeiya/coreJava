package pattern.behavioral.templateMethod;

/**
 * @ClassName FECourse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:23
 * @Version 1.0
 **/
public class FECourse extends ACourse {
    private boolean needArticleFlag=false;

    public FECourse(boolean needArticleFlag) {
        this.needArticleFlag = needArticleFlag;
    }

    @Override
    protected boolean needArticle() {
        return this.needArticleFlag;
    }

    @Override
    void packageCourse() {
        System.out.println("提供课程的源代码");
        System.out.println("提供课程的图片等流素材");
    }
}
