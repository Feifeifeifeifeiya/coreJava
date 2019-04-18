package pattern.behavioral.visitor;

/**
 * @ClassName CodingCourse
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 17:46
 * @Version 1.0
 **/
public class CodingCourse extends Course {
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
