package pattern.creational.factoryMethod;

public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getNewClass() {
        return new JavaVideo();
    }
}
