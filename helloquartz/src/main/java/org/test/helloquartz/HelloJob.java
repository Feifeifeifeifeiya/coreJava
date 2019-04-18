package org.test.helloquartz;

import org.quartz.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName HelloJob
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 0025 23:53
 * @Version 1.0
 **/
@Component
public class HelloJob implements Job {
    private String message;
    private String jobdetail;
    private String trigger;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJobdetail() {
        return jobdetail;
    }

    public void setJobdetail(String jobdetail) {
        this.jobdetail = jobdetail;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印当前的执行时间，格式为2019-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Execute Is"+simpleDateFormat.format(date));

//        JobKey key = context.getJobDetail().getKey();
//        System.out.println("jobdetail:"+key.getName()+key.getGroup());
//        TriggerKey key1 = context.getTrigger().getKey();
//        System.out.println("trigger:"+key.getName()+key.getGroup());
//
//        JobDataMap jobDataMap1 = context.getJobDetail().getJobDataMap();
//        System.out.println(jobDataMap1.get("message")+""+jobDataMap1.get("jobdetail"));
//        JobDataMap jobDataMap2 = context.getTrigger().getJobDataMap();
//        System.out.println(jobDataMap2.get("message")+""+jobDataMap2.get("trigger"));
//
//        JobDataMap jobDataMap = context.getMergedJobDataMap();
//        System.out.println(jobDataMap.get("message")+""+jobDataMap.get("jobdetail")+""+jobDataMap.get("trigger"));
        System.out.println("message"+message);
        System.out.println("jobdetail"+jobdetail);
        System.out.println("trigger"+trigger);
    }
}
