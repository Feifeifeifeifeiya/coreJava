package day4;

import day1.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName MethodRefenlance
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 17:00
 * @Version 1.0
 **/
public class MethodRefenlance {
    public static void main(String[] args) {
        useComsumer((t)->System.out.println(t),"hello");
        useComsumer(System.out::println,"hello world");

        int i = Integer.parseInt("123");
        System.out.println(i);

        Function<String,Integer> function=Integer::parseInt;
        System.out.println(function.apply("123"));

        List<Apple> apples = Arrays.asList(new Apple("green", 180L), new Apple("red", 130L), new Apple("green", 140l));
        apples.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));
        apples.stream().forEach(System.out::println);
        System.out.println("======================================");
        apples.forEach(System.out::println);

        //一个参数没有的构造方法
        Supplier<String> stringSupplier=String::new;
        String s = stringSupplier.get();
        System.out.println(s);

        //两个参数的构造方法
        BiFunction<String,Long,Apple> biFunction=Apple::new;
        Apple apple = biFunction.apply("yellow", 180L);
        System.out.println(apple);

        //三个参数的构造方法,需要自己定义一个函数式接口
        ThreeFunction<String,Long,String,SimpleApple> threeFunction=SimpleApple::new;
        SimpleApple apply = threeFunction.apply("yellow", 180L, "hahaha");
        System.out.println(apply);

        List<Apple> app = Arrays.asList(new Apple("green", 180L), new Apple("red", 130L), new Apple("green", 140l));
        app.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));
        app.sort(Comparator.comparing(Apple::getWeight));

    }

    public static <T> void useComsumer(Consumer<T> consumer,T t){
         consumer.accept(t);
    }
}
