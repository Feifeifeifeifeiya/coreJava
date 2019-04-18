package staticProxy;

public class StudentProxy implements Person {
    //被代理类
    Student stu;

    public StudentProxy() {
    }

    public StudentProxy(Person stu) {
        this();

        if(stu.getClass()==Student.class) {
            this.stu = (Student) stu;
        }
    }

    @Override
    public void giveMoney() {
        System.out.println("最近学习进步很大");
        stu.giveMoney();
    }

    public static void main(String[] args) {
        Person wufei = new Student("wufei");
        new StudentProxy(wufei).giveMoney();
    }
}
