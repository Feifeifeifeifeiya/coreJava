package day4;

/**
 * @ClassName ThreeFunction
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 17:34
 * @Version 1.0
 **/
@FunctionalInterface
public interface ThreeFunction<A ,B ,C ,D> {

    D apply(A a,B b,C c);
}
