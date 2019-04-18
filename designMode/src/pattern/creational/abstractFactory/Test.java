package pattern.creational.abstractFactory;

public class Test {
    public static void main(String[] args) {
        AbstractFactory abstractFactory= new JavaFactory();
        Article article = abstractFactory.getArticle();
        Video video = abstractFactory.getVideo();
        article.produce();
        video.produce();
    }
}
