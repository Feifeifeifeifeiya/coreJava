package pattern.creational.factoryMethod;

public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getNewClass() {
        return new PythonVideo();
    }
}
