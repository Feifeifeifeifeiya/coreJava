package countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName DatabaseHealthChecker
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 22:52
 * @Version 1.0
 **/
public class DatabaseHealthChecker extends BaseHealthChecker{

    public DatabaseHealthChecker(CountDownLatch latch) {
        super(latch, "Data Service");
    }

    @Override
    public void verifyService() {
        System.out.println("Chack"+this.getServiceName());
        try {
            Thread.sleep(7000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+"Get up");
    }
}
