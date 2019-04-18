package pattern.structural.composite;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/11 0011 16:25
 * @Version 1.0
 **/
public class Course extends CatalogComponent {
    private String name;
    private double price;
    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public Double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println("课程名称："+this.name+"课程价格："+this.price);
    }
}
