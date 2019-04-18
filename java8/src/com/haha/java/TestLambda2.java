package com.haha.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static javafx.scene.input.KeyCode.L;

/**
 * 左侧是lambda的参数列表
 * 右侧是lambda表达式所需要的功能，即lambda体
 */
public class TestLambda2 {
    //语法格式一：无参数，无返回值
    @Test
    public void test1(){
        int num=0;//jdk1.7之前内部类要使用局部变量必须要加final修饰，1.8之后jdk会隐式的帮你加上
        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                System.out.println("hello world"+num);
            }
        };
        runnable.run();
        System.out.println("-------------------------");
        Runnable r=()-> System.out.println("Hello lambda");
        r.run();
    }

    @Test
    public void test2(){
        //语法格式2：有一个参数，并且无返回值（一个参数的话左边参数的()可以不写）
        Consumer c=(x)-> System.out.println(x);
        c.accept("吴飞很可爱");
    }

    @Test
    public void test3(){
        //语法格式3：有两个参数，有返回值，并且有多条语句
        Comparator<Integer> comparator= (x,y)->{
            System.out.println("我好帅");
            return Integer.compare(x,y);
        };
        int i = comparator.compare(1, 2);
        System.out.println(i);
    }

    @Test
    public void test4(){
        //语法格式4：有返回值并且只有一条语句，return和{}都可以不写
                   //lambda表达式的参数数据类型可以不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        int compare = comparator.compare(2, 1);
        System.out.println(compare);
    }

    //需求：对一个数进行计算

    @Test
    public void test5(){
        Integer option = option(100, (x) -> x * x);
        System.out.println(option);
        System.out.println(option(200,(y)->y+200));
    }

    public Integer option(Integer i,MyFunction fun){
        return fun.mycount(i);

    }


    List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 99.99),
            new Employee("王五", 50, 4499.99),
            new Employee("赵六", 16, 2299.99),
            new Employee("田七", 8, 9229.99)
    );
    @Test
    public void test6(){
    Collections.sort(list,(x,y)->{
        if(x.getAge()>y.getAge()){
            return x.getName().compareTo(y.getName());
        }else{
            return Integer.compare(x.getAge(),y.getAge());
        }

    });
        System.out.println(list);
}

    @Test
    public void test7(){
        MyFunInter fun=(x)->x.toUpperCase();
        String value = fun.getValue("shiofdahs");
        System.out.println(value);
    }

    @Test
    public void test8(){
        String s = strHandler("       ajrfee  sdf    ", (x) -> x.trim().toUpperCase().substring(2,5));
        System.out.println(s);
    }

    public String strHandler(String i,MyFunInter fun){
        return fun.getValue(i);
    }

    @Test
    public void test9(){
        op(23,547,(x,y)->(int)x *(int) y);
    }

    public void op(Integer l1,Integer l2,MyFunctionInteface fun){
        System.out.println(fun.longHandler(l1,l2));
    }

}
