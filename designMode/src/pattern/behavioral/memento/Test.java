package pattern.behavioral.memento;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:09
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();
        Article article = new Article("如影随形的设计模式A", "手记内容A", "手记图片A");
        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println("标题:"+article.getTitle()+"内容:"+article.getContent()+"图片:"+article.getImgs());
        System.out.println("手记完整信息:"+article);
        System.out.println("修改手记内容start");
        article.setTitle("如影随形的设计模式B");
        article.setContent("手记内容B");
        article.setImgs("手记图片B");
        System.out.println("修改手记内容end");
        System.out.println("手记完整信息:"+article);
        articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        article.setTitle("如影随形的设计模式C");
        article.setContent("手记内容C");
        article.setImgs("手记图片C");
        System.out.println("手记完整信息:"+article);
        System.out.println("暂存回退start");
        System.out.println("回退出栈一次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("回退出栈两次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);
        System.out.println("暂存回退end");
        System.out.println("手记完整信息:"+article);
    }
}
