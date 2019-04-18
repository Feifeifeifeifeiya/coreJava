package com.example.testjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName TestJson
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 0026 22:58
 * @Version 1.0
 **/
public class TestFastJson {
    public static void main(String[] args) throws ParseException, IOException {
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


        String s = JSONObject.toJSONString(person);

        System.out.println(s);
        JSONObject o = (JSONObject) JSONObject.parse(s);
        System.out.println(o);
        Person person1 = JSONObject.toJavaObject(o, Person.class);
        System.out.println(person1);

        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "张三");
        map.put("年龄", 22);
        String[] string1 = new String[]{"理发", "挖掘机"};
        map.put("职业",string1);
        JSONObject jsonObject = new JSONObject(map);
        String[] strings = (String[])jsonObject.get("职业");
        System.out.println(strings);
        System.out.println(jsonObject);
        System.out.println("=======================================");
        File file = new File(TestFastJson.class.getResource("/haha.json").getFile());
        String s1 = FileUtils.readFileToString(file);
        JSONObject object  = (JSONObject)JSONObject.parse(s1);
        Object name = object.get("name");
        Integer age = object.getInteger("age");
        System.out.println(age);
        System.out.println(name);
        JSONArray major = object.getJSONArray("major");
        System.out.println(major);
        System.out.println( major.toArray()[1]);
        Person person2 = JSONObject.toJavaObject(object, Person.class);
        System.out.println(object);
        System.out.println(person2);
    }
}

