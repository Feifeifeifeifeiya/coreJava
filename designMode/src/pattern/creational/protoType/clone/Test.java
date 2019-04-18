package pattern.creational.protoType.clone;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pig pig = new Pig();
        Date date = new Date(0L);
        pig.setName("佩奇");
        pig.setBirthday(date);
        Pig pigg= (Pig) pig.clone();
        System.out.println(pig);
        System.out.println(pigg);
        pig.getBirthday().setTime(6666666L);
        System.out.println(pig);
        System.out.println(pigg);
    }
}
