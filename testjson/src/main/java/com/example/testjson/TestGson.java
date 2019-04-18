package com.example.testjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestGson
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 23:57
 * @Version 1.0
 **/
public class TestGson {
    public static void main(String[] args)throws Exception {
        Person person = new Person();
        person.setName("王小二");
        person.setAge(25);
        String dateStr = "1990-2-1";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(dateStr);
        person.setBirthday(parse);
        String[] string = new String[]{"理发", "挖掘机"};
        person.setMajor(Arrays.asList(string));
        person.setHasGirlFriend(false);
        person.setCar(false);
        person.setHouse(false);
        person.setComment("这是一个注释");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson1 = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        String s1 = gson1.toJson(person);
        System.out.println(s1);
        Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s2 = gson2.toJson(person);

        System.out.println(s2);
        Person person2 = gson2.fromJson(s2, Person.class);
        System.out.println(person2);
        Gson gson3 = new Gson();
        String s3 = gson3.toJson(person.getMajor());
        System.out.println(s3);
        List list = gson3.fromJson(s3, List.class);
        System.out.println(list);
    }
}
