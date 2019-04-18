package pattern.creational.abstractFactory;

public class JavaFactory implements AbstractFactory {
    @Override
    public Article getArticle() {
        return new JavaArticle();
    }

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
