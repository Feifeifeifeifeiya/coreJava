package pattern.behavioral.memento;

import java.util.Stack;

/**
 * @ClassName ArticleMementoManager
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 14:55
 * @Version 1.0
 **/
public class ArticleMementoManager {
    private final Stack<ArticleMemento> ARTICLE_MEMENTO_STACK=new Stack<>();

    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = ARTICLE_MEMENTO_STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento){
        ARTICLE_MEMENTO_STACK.push(articleMemento);
    }
}
