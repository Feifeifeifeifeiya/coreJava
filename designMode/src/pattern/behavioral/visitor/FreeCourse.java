package pattern.behavioral.visitor;

/**
 * @ClassName FreeCourse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:45
 * @Version 1.0
 **/
public class FreeCourse extends Course {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
