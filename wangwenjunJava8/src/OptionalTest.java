import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName Optional
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 21:51
 * @Version 1.0
 **/
public class OptionalTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional<Integer> any = stream.filter(i -> i < 10).findAny();
        Integer integer = any.get();
        System.out.println(integer);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream1.filter(i -> i % 2 == 0).findFirst().ifPresent(System.out::println);
    }
}
