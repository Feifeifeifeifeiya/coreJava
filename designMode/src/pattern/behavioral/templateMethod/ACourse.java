package pattern.behavioral.templateMethod;

/**
 * @ClassName ACourse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 1:16
 * @Version 1.0
 **/
public abstract class ACourse {

    protected final void makeCourse(){
        this.makePPT();
        this.makeVideo();
        if(this.needArticle()){
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePPT(){
        System.out.println("制作PPT");
    }

    final void makeVideo(){
        System.out.println("制作视频");
    }

    final void writeArticle(){
        System.out.println("制作手记");
    }

    //钩子方法
    protected boolean needArticle(){
        return false;
    }

    abstract void packageCourse();
}
