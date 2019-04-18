import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName ParseAnnotation
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 0:01
 * @Version 1.0
 **/
public class ParseAnnotation {
    public static void main(String[] args) throws Exception{
        Class<?> child = Class.forName("Child");
        //判断类上面是否有注解
        boolean annotationPresent = child.isAnnotationPresent(Description.class);
        if(annotationPresent){
            Description annotation = child.getAnnotation(Description.class);
            System.out.println(annotation.desc());
        }
        //解析方法上的注解
        Method[] methods = child.getMethods();
        for(Method method:methods){
            boolean present = method.isAnnotationPresent(Description.class);
            if(present){
                Description annotation = method.getAnnotation(Description.class);
                System.out.println(annotation.desc());
            }
        }
        //另一种解析方法
        for(Method method:methods){
            Annotation[] annotations = method.getAnnotations();
            for(Annotation annotation:annotations){
                if(annotation instanceof Description){
                    Description description=(Description)annotation;
                    System.out.println(description.desc());
                }
            }
        }

    }
}
