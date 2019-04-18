import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName StreamMatch
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 21:46
 * @Version 1.0
 **/
public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        boolean match = stream.allMatch(i -> i > 10);
        System.out.println(match);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        boolean b = stream1.noneMatch(i -> i < 0);
        System.out.println(b);

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        boolean b1 = stream2.anyMatch(i -> i > 5);
        System.out.println(b1);
    }
}
