public class TestFinal {
    public static void  main(String[] args){
        MyClass class1=new MyClass();
        MyClass class2=new MyClass();
        System.out.println(class1.i);
        System.out.println(class2.i);
        System.out.println("---------------------");
        System.out.println(class1.j);
        System.out.println(class2.j);

    }
}

class MyClass{
    public final double i=Math.random();
    public static double j=Math.random();
}
