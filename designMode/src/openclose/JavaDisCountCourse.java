package openclose;

public class JavaDisCountCourse extends JavaCourse {

    public JavaDisCountCourse(int id, String name, int price) {
        super(id, name, price);
    }

    public int getOldPrice(){
        return super.getPrice();
    }

    @Override
    public int getPrice() {
        return super.getPrice()*2;
    }
}
