package com.example.testjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName TestJackson
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/27 0027 0:36
 * @Version 1.0
 **/
public class TestJackson {
    public static void main(String[] args) throws Exception{
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
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(person);
        System.out.println(s);
        Person person1 = objectMapper.readValue(s, Person.class);
        System.out.println(person1);

        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "张三");
        map.put("年龄", 22);
        String[] string1 = new String[]{"理发", "挖掘机"};
        String s1 = objectMapper.writeValueAsString(map);
        System.out.println(s1);
        Map map1 = objectMapper.readValue(s1, Map.class);
        System.out.println(map1);
        String s2 = objectMapper.writeValueAsString(string1);
        System.out.println(s2);
        List list = objectMapper.readValue(s2, List.class);
        System.out.println(list);

    }
}
