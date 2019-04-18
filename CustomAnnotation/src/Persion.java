import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Persion {
    String name() default "wufei";
    int age() default 24;
    String[] hobby() default {"football","basketball"};
}
