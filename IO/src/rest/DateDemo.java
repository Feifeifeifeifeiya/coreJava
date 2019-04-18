package rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/16 0016 3:25
 * @Version 1.0
 **/
public class DateDemo {
//    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
//        String format = simpleDateFormat.format(date);
//        DateFormat dateInstance = DateFormat.getDateInstance();
//        String format1 = dateInstance.format(date);
//        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
//        String format2 = dateTimeInstance.format(date);
//        System.out.println(format);
//
//    }
      public static void main(String[] args) throws ParseException {
      //将两个日期字符串“2018-12-25”到“2019-2-14”算出他们之间的间隔
          String str1="2018-12-25";
          String str2="2019-2-14";
          DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.DEFAULT);
          Date date1 = dateInstance.parse(str1);
          Date date2 = dateInstance.parse(str2);
          long time1 = date1.getTime();
          int t1=(int)(time1/1000/60/60/24);
          long time2 = date2.getTime();
          int t2=(int)(time2/1000/60/60/24);
          System.out.println(t2-t1);
      }
}
