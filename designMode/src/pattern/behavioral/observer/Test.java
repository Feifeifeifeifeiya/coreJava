package pattern.behavioral.observer;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 14:29
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Course course = new Course("java设计模式精讲");
        Teacher geely = new Teacher("Geely");
        //添加一个观察者
        course.addObserver(geely);
        //业务逻辑代码
        Question question = new Question();
        question.setUserName("wufei");
        question.setQuestionContent("java的主函数如何编写");

        course.produceQuestion( course,question);
    }
}
