import java.lang.reflect.Field;

public class ReflectTest {

    public static void main(String[] args){
        Person person = new Person();
        Class<? extends Person> clazz = person.getClass();
        System.out.println(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }
    }
}
