package openclose;

public class JavaCourse implements ICourse {
    private int id;
    private String name;
    private int price;

    public JavaCourse(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
