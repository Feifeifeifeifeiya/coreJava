/**
 * @ClassName Main
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/14 0014 21:26
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        MyClassLoader mcl = new MyClassLoader();
        ClassLoader parent = mcl.getParent();
        Class<?> c1 = Class.forName("Person", true, mcl);
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(parent);
    }
}
