package com.haha.java;

public class FilterEmployeeAsSalary implements MyProdict<Employee> {
    @Override
    public Boolean MyConpare(Employee employee) {
        return employee.getSalary()>=4000;
    }
}
