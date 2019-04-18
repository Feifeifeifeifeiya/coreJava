package pattern.behavioral.visitor;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:42
 * @Version 1.0
 **/
public abstract class Course {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(IVisitor visitor);
}
