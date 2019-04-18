package liaxi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 1:25
 * @Version 1.0
 **/
public class Executor {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is"+simpleDateFormat.format(instance.getTime()));
        Timer timer = new Timer();
        DancingRobot dancingRobot = new DancingRobot();
        WaterRobot waterRobot = new WaterRobot(timer);
        timer.schedule(dancingRobot,instance.getTime(),2000L);
        timer.scheduleAtFixedRate(waterRobot,instance.getTime(),1000L);

    }
}
