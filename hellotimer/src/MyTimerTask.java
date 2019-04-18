import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 * @ClassName MyTimerTask
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 0:24
 * @Version 1.0
 **/
public class MyTimerTask extends TimerTask {
    private String name;

    private int count=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//      Date date = new Date();
       if(count<3){
           Calendar instance = Calendar.getInstance();
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
           System.out.println(simpleDateFormat.format(instance.getTime()));
           System.out.println("Current excute name is "+name);
           count++;
       }else{
           this.cancel();
           System.out.println("Cancel");
       }
    }
}
