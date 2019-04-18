package pattern.behavioral.visitor;

/**
 * @ClassName IVisitor
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:44
 * @Version 1.0
 **/
public interface IVisitor {
    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);
}
