package juc;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @ClassName TestForkJoinPool
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/19 0019 0:51
 * @Version 1.0
 **/
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant now = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinCulate forkJoinCulate = new ForkJoinCulate(0l, 100000000l);
        Long sum = forkJoinPool.invoke(forkJoinCulate);
        System.out.println(sum);
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now,now1).toMillis());
    }

    @Test
    public void test(){
        Instant now = Instant.now();
        long sum = LongStream.rangeClosed(0l, 10000000l)
                .parallel()
                .reduce(0l, Long::sum);
        System.out.println(sum);
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now,now1).toMillis());
    }
}




class ForkJoinCulate extends RecursiveTask<Long>{
    private long start;
    private long end;
    //递归的临界值
    private static final long THURSHOLD = 100000l;

    public ForkJoinCulate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0l;
            for(long i = start;i <= end; i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end)/2;
            ForkJoinCulate left = new ForkJoinCulate(start, middle);
            left.fork(); //进行拆分，同时压入线程队列
            ForkJoinCulate right = new ForkJoinCulate(middle + 1, end);
            right.fork();
            return left.join()+right.join();
        }
    }
}
