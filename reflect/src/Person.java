public class Person {
    //私有属性
    private String name="wufei";
    //公有属性
    public int age=10;

    public Person() {
    }
    //私有方法
    private void say(){
        System.out.println("private say().....");
    }

    //公有方法
    public void work(){
        System.out.println("public work().....");
    }
}
