package liaxi;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * @ClassName DancingRobot
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 1:11
 * @Version 1.0
 **/
public class DancingRobot extends TimerTask {

    @Override
    public void run() {
        //获取最近一次的任务执行时间，并将其格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("scheduled execute time is "+simpleDateFormat.format(this.scheduledExecutionTime()));
        System.out.println("Dancing happily");
    }
}
