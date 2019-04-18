import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName StreamReduce
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 21:58
 * @Version 1.0
 **/
public class StreamReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional<Integer> reduce = stream.reduce(Integer::max);
        reduce.ifPresent(System.out::println);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream1.reduce((i,j)->i*j).ifPresent(System.out::println);

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream2.reduce(Integer::max).ifPresent(System.out::println);
    }
}
