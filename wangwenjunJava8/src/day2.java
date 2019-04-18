import day1.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName day2
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 2:22
 * @Version 1.0
 **/
public class day2 {
    public static void main(String[] args) {
        Comparator comparator=new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(comparator);

        Comparator<Apple> comparator1=(o1,o2)->o1.getColor().compareTo(o2.getColor());

        //一个入参，一个出参
        Function<String,Integer> function=(s)->s.length();

        //返回一个boolean类型的参数
        Predicate<Apple> predicate=(Apple a)->{return a.getColor().equals("green");};

        Function<Apple,Boolean> function1=(a)->{return a.getColor().equals("green");};

        Runnable r=()->{};


    }
}
