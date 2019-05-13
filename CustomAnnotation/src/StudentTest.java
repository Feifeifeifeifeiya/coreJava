import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        boolean annotationPresent = studentClass.isAnnotationPresent(Persion.class);
        if(!annotationPresent){
            return;
        }
        Persion persion = studentClass.getAnnotation(Persion.class);
        System.out.println(persion.age());
        System.out.println(persion.name());
        String[] hobby = persion.hobby();
        for (String s:hobby){
            System.out.println(s);
        }
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            if(!field.isAnnotationPresent(StudentGender.class)){
                return;
            }
            StudentGender studentGender = field.getAnnotation(StudentGender.class);
            StudentGender.Gender gender = studentGender.gender();
            System.out.println(gender);
        }
    }
}
