package com.haha.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Testlambda3 {
    /**
     * java8内置的四大函数式接口
     *
     * Consumer<T>:消费型接口
     * void accept(T t);
     *
     * Supplier<T>: 供给型接口
     * T get();
     *
     * Function<T,R>:函数型接口
     * R apply(T t);
     *
     * Predicate<T>:断言型接口
     * Boolean test(T t);
     */

    //断言式接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("wufei", "zhangsan", "lisi", "wangwu");
        List<String> filterStr = filterStr(list, (x) -> x.length() > 3);
        System.out.println(filterStr);
    }

    //需求：把满足条件的字符串放入到集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList=new ArrayList<>();
        for (String s:list
             ) {
            if(pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }

    //函数型接口
    @Test
    public void test3(){
        String s = strHandler("\t\t\t sadj ksa  ", (str) -> str.trim().toUpperCase());
        System.out.println(s);
    }

    //需求：用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);

    }

    //供给型接口
    @Test
    public void test2(){
        List<Integer> list = production(50, () -> (int) (Math.random() * 100));
        System.out.println(list);
        System.out.println(Math.random()*100);
    }
    //需求：产生一些整数，并且放入集合中
    public List<Integer> production(int num,Supplier supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            Integer integer=(Integer)supplier.get();
            list.add(integer);
        }
        return list;
    }
    //消费型接口
    @Test
    public void test1(){
        happy(1000,(x)-> System.out.println("阿三喜欢舔美国屁眼，每次花费"+x+"元"));
    }

    public void happy(Integer money, Consumer<Integer> con){
        con.accept(money);
    };
}
