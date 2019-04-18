import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @ClassName Mytimer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 0:27
 * @Version 1.0
 **/
public class Mytimer {
    public static void main(String[] args) {
        //创建一个Timer实例
        Timer timer = new Timer();
        //创建一个任务实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");
        //通过timer定时频率调用myTimerTask的业务逻辑
        //即第一次执行是在当前时间的两秒之后，之后每隔一秒执行一次
//        timer.schedule(myTimerTask,200l,1000L);

        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.SECOND,3);
        /*
         *@Author WuFei
         *@Description //TODO1.在时间等于或者超过time的时间的时候执行且执行一次task
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
//        timer.schedule(myTimerTask,calendar.getTime());
        /*
         *@Author WuFei
         *@Description //TODO1.在时间等于或者超过time的时间的时候执行且执行一次task,第三个参数是执行任务的间隔
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
//        timer.schedule(myTimerTask,calendar.getTime(),2000L);
        /*
         *@Author WuFei
         *@Description //TODO1.等待delay毫秒之后执行且执行一次task
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
        timer.schedule(myTimerTask,5000L);
        System.out.println(simpleDateFormat.format(myTimerTask.scheduledExecutionTime()));

        /*
         *@Author WuFei
         *@Description //TODO1.等待delay毫秒之后执行且执行一次task,第三个参数是执行任务的间隔
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
//        timer.schedule(myTimerTask,2000L,1000L);

        /*
         *@Author WuFei
         *@Description //TODO1.在时间等于或者超过time的时间的时候执行且执行一次task,第三个参数是执行任务的间隔
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
//        timer.scheduleAtFixedRate(myTimerTask,calendar.getTime(),1000L);

        /*
         *@Author WuFei
         *@Description //TODO1.等待delay毫秒之后执行且执行一次task,第三个参数是执行任务的间隔
         *@Date 0:37 2019/2/26 0026
         *@Param [args]
         *@Return void
         **/
//        timer.scheduleAtFixedRate(myTimerTask,4000L,2000L);
    }
}
