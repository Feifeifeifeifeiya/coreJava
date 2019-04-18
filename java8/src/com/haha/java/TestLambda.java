package com.haha.java;

import org.junit.Test;

import java.util.*;

public class TestLambda {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(com);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> integers = new TreeSet<>(com);
    }

    //需求：获取员工岁数大于35的对象
    List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 99.99),
            new Employee("王五", 50, 4499.99),
            new Employee("赵六", 16, 2299.99),
            new Employee("田七", 8, 9229.99)
    );

    public List<Employee> filterEmplyees(List<Employee> list) {
        List<Employee> empleyees = new ArrayList<Employee>();
        for (Employee e : list) {
            if (e.getAge() > 35) {
                empleyees.add(e);
            }

        }
        return empleyees;
    }

    @Test
    public void test3() {
        List<Employee> employees = filterEmplyees(list);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    //需求：获取员工工资大于4000的对象
    public List<Employee> filterAsSalary(List<Employee> list) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee e : list) {
            if (e.getSalary() >= 4000) {
                employees.add(e);
            }
        }
        return employees;
    }

    @Test
    public void test4() {
        List<Employee> employees = filterAsSalary(list);
        System.out.println(employees);
    }


    //优化方式1:策略模式
    public List<Employee> filterEmplayee(List<Employee> list, MyProdict<Employee> emp) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee e : list) {
            if (emp.MyConpare(e)) {
                employees.add(e);
            }

        }
        return employees;
    }

    @Test
    public void test6(){
        List<Employee> employees = filterEmplayee(list, new FilterEmplayeeAsAge());
        System.out.println(employees);
    }

    @Test
    public void test7(){
        List<Employee> employees = filterEmplayee(list, new FilterEmployeeAsSalary());
        System.out.println(employees);
    }

    //优化方式2：匿名内部类
    @Test
    public void test8(){
        List<Employee> employees = filterEmplayee(list, new MyProdict<Employee>() {
            @Override
            public Boolean MyConpare(Employee employee) {
                return employee.getSalary() > 4000;
            }
        });

        System.out.println(employees);
    }
    //优化方式3：lambda表达式
    @Test
    public void test9(){
        List<Employee> employees1 = filterEmplayee(list, (e) -> e.getSalary() > 4000);
        List<Employee> employees2 = filterEmplayee(list, (e) -> e.getAge() > 30);
        employees1.forEach(System.out::println);
        System.out.println(employees1);
        System.out.println(employees2);
    }

    //优化方式4：Stream API
    @Test
    public void test10(){
        list.stream().filter((e)->e.getSalary()>4000)
                .limit(2)
                .forEach(System.out::println);

        list.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}