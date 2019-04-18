package pattern.creational.factoryMethod;

public class Test {
    public static void main(String[] args) {
        JavaVideoFactory javaVideoFactory = new JavaVideoFactory();
        Video video = javaVideoFactory.getNewClass();
        video.produce();
    }
}
