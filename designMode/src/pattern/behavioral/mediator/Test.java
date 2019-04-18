package pattern.behavioral.mediator;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:58
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        User geely = new User("geely");
        User tom = new User("tom");
        geely.sendMessage("hello,tom");
        tom.sendMessage("hello geely");
    }
}
