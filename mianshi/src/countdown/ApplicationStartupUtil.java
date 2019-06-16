package countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ApplicationStartupUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 22:57
 * @Version 1.0
 **/
public class ApplicationStartupUtil {

    private static List<BaseHealthChecker> heakthService;

    private static CountDownLatch latch;

    private ApplicationStartupUtil(){

    }

    private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance(){
        return INSTANCE;
    }

    public static boolean checkExternalServices(){
        heakthService = new ArrayList<>();
        heakthService.add(new NewWorkHealthChecker(latch));
        heakthService.add(new DatabaseHealthChecker(latch));
        heakthService.add(new CacheHealthChecker(latch));
        latch = new CountDownLatch(3);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for(BaseHealthChecker bb:heakthService){
            threadPoolExecutor.execute(bb);
        }

        try {
            latch.await();
    }catch (Exception e){
        e.printStackTrace();
    }

        for(BaseHealthChecker bb:heakthService){
            if(!bb.isServiceUp()){
                return false;
            }
        }

        return true;
    }


}
