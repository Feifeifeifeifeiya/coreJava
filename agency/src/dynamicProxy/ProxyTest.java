package dynamicProxy;


import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Human tea = new Teacher("张三");

        //创建一个与代理对象相关联的InvocationHandler
        StuInvocationHandler<Human> handler = new StuInvocationHandler<>(tea);

        //创建一个dai代理对象teaProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中invoke

        Human instance =(Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class<?>[]{Human.class}, handler);

        //代理执行上交班费的方法
        instance.giveMoney();
    }
}
