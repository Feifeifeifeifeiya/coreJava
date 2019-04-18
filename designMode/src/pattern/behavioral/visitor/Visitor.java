package pattern.behavioral.visitor;

/**
 * @ClassName Visitor
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:48
 * @Version 1.0
 **/
public class Visitor implements IVisitor {
    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程"+freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程"+codingCourse.getName()+"价格"+codingCourse.getPrice());
    }
}
