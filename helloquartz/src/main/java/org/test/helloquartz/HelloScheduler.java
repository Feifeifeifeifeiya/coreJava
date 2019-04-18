package org.test.helloquartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName HelloScheduler
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 0:04
 * @Version 1.0
 **/
public class HelloScheduler {
    public static void main(String[] args) throws Exception{
        //创建一个jobDetail的实例，将该实例与HelloJob绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myjob", "group1")
                .usingJobData("message","jobDetail").usingJobData("jobdetail",100L).build();
        System.out.println(jobDetail.getKey().getName());
        System.out.println(jobDetail.getKey().getGroup());
        System.out.println(jobDetail.getJobClass());
//        //创建一个SimpleTrigger的实例，定义该job立即执行，并且每隔两秒重复执行一次，直到永远
//        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
//                .usingJobData("message","trigger").usingJobData("trigger",0.400F).startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        //一个cornTrigger的实例
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/3 0 22 ? * *"))).build();
        //创建scheduler实例
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //打印当前的执行时间，格式为2019-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time Is"+simpleDateFormat.format(date));
        Date date1 = scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();


    }
}
