package streamFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamFilter
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/24 0024 21:52
 * @Version 1.0
 **/
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 5, 6);
        List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("========================================================");
        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        collect1.forEach(System.out::println);
        System.out.println("========================================================");
        List<Integer> collect2 = list.stream().skip(3).collect(Collectors.toList());
        collect2.forEach(System.out::println);
        list.stream().map(i->i*2).forEach(System.out::println);
        String[] strings={"hello","world"};
        List<String> strings1 = Arrays.asList(strings);
        strings1.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
