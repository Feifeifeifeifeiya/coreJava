package countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName NewWorkHealthChecker
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 22:47
 * @Version 1.0
 **/
public class NewWorkHealthChecker extends BaseHealthChecker {

    public NewWorkHealthChecker(CountDownLatch latch) {
        super(latch, "NewWork Service");
    }

    @Override
    public void verifyService() {
        System.out.println("Check"+this.getServiceName());
        try {
            Thread.sleep(7000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+"get up");
    }
}
