package countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CacheHealthChecker
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 22:54
 * @Version 1.0
 **/
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(CountDownLatch latch) {
        super(latch, "Cache Service");
    }

    @Override
    public void verifyService() {
        System.out.println("Check"+this.getServiceName());
        try {
            Thread.sleep(7000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+"Get up");
    }
}
