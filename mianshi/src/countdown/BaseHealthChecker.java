package countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName BaseHealthChecker
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/22 0022 22:40
 * @Version 1.0
 **/
public abstract class BaseHealthChecker implements Runnable{

    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    public BaseHealthChecker(CountDownLatch latch, String serviceName) {
        this.latch = latch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
        }catch (Exception e){
            e.printStackTrace();
            serviceUp = false;
        }finally {
            if(latch != null){
                latch.countDown();
            }
        }
    }


    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }
    //This methos needs to be implemented by all specific service checker
    public abstract void verifyService();
}
