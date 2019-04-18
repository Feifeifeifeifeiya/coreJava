package liaxi;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName WaterRobot
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 1:15
 * @Version 1.0
 **/
public class WaterRobot extends TimerTask {
    private Timer timer;

    public WaterRobot(Timer timer) {
        this.timer = timer;
    }

    //最大容量为5L
    private Integer bucketCapicity=0;
    @Override
    public void run() {
        //灌水直到水桶满了为止
        if(bucketCapicity<5){
            System.out.println("Add 1L water into the bucket");
            System.out.println("当前移除的任务数"+timer.purge());
            bucketCapicity++;
        }else{
            //水满了停止执行
            this.cancel();
            System.out.println("The WaterRobot has been aborted");
            System.out.println("当前移除的任务数"+timer.purge());
            System.out.println("水桶里水的数量"+bucketCapicity+"L");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }
    }
}
