import javax.xml.bind.Element;
import java.lang.annotation.*;

/**
 * @ClassName Description
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 23:50
 * @Version 1.0
 **/
//注解应用在什么上
@Target({ElementType.METHOD,ElementType.TYPE})
//在运行时保留
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    //成员使用无参无异常的方式声明
    //类型只能是基本数据类型和String class annotation
    //只有一个成员必须起名叫value
    String desc();
//    String author();
//    int age() default 18;
}
