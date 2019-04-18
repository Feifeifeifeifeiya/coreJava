package day3;

import day1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

/**
 * @ClassName FilterApple
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 3:00
 * @Version 1.0
 **/
public class FilterApple {

    public static List<Apple> filterLoveApple(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> loveApples = new ArrayList<>();
        for(Apple apple:source){
            if(predicate.test(apple)){
                loveApples.add(apple);
            }
        }
        return loveApples;
    }

    public static List<Apple> filterGetWeight(List<Apple> source, LongPredicate predicate){
        ArrayList<Apple> apples = new ArrayList<>();
        for(Apple apple:source){
            if(predicate.test(apple.getWeight())){
                apples.add(apple);
            }
        }
        return apples;
    }

    public static List<Apple> filterBi(List<Apple> source, BiPredicate<String,Long> predicatee){
        ArrayList<Apple> apples = new ArrayList<>();
        for(Apple apple:source){
            if(predicatee.test(apple.getColor(),apple.getWeight())){
                apples.add(apple);
            }
        }
        return apples;
    }

    public static String filterPlusTen(Apple a,Function<Apple,String> function){

        return function.apply(a);
    }

    public static Apple producer(String color,Long weight,BiFunction<String,Long,Apple> function){
        return function.apply(color,weight);
    }

    public static String filterplus(Apple apple,LongFunction<String> intFunction){
        return intFunction.apply(apple.getWeight());
    }

    public static void getEvery(List<Apple> source, Consumer<Apple> consumer){
        for(Apple apple:source){
            consumer.accept(apple);
        }
    }

    public static void getSome(List<Apple> apples,BiConsumer<Apple,String> consumer){
        for(Apple apple:apples){
            consumer.accept(apple,apple.getColor());
        }
    }

    public static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 120L), new Apple("red", 130L), new Apple("green", 140l));
//        List<Apple> loveApples =filterLoveApple(apples,(apple)->apple.getColor().equals("green"));
//        loveApples.forEach(System.out::println);

//        List<Apple> loveApples=filterGetWeight(apples,(w)-> w>100L);
//        loveApples.forEach(System.out::println);

//        List<Apple> list=filterBi(apples,(s,m)->s.equals("green")&&(m>100));
//        list.forEach(System.out::println);

//        getEvery(apples,(apple -> System.out.println(apple)));

//        getSome(apples,(apple,s)-> System.out.println(apple.getColor()+apple.getWeight()));

//        for(Apple a:apples){
//            String s =filterPlusTen(a ,(apple) ->a.toString());
//            System.out.println(s);
//        }

//        for(Apple apple:apples){
//            String s=filterplus(apple,(c)->String.valueOf(apple.getWeight()+c));
//            System.out.println(s);
//        }

//        Apple d=producer("yellow",123L,(s,w)-> new Apple(s,w));
//        System.out.println(d);

//        Supplier<String> s=String::new;
//        System.out.println(s.get().getClass());

        Apple apple=createApple(()-> new Apple("green",100L));
        System.out.println(apple);
    }
}
